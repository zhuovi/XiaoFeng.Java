package xiaofeng.config;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.nio.charset.Charset;

import xiaofeng.annotations.ConfigFile;
import xiaofeng.annotations.EncryptFile;
import xiaofeng.cache.CacheManager;
import xiaofeng.core.StringHelper;
import xiaofeng.cryptography.EncryptUtil;
import xiaofeng.entity.EntityBase;
import xiaofeng.io.FileHelper;
import xiaofeng.json.JsonHelper;
import xiaofeng.reflect.Reflects;
import xiaofeng.xml.XmlHelper;

/**
 * 配置操作类
 * 
 * @author Author : Jacky<br>
 *         Company : 魔法精灵<br>
 *         QQ:7092734<br>
 *         Email : jacky@fayelf.com<br>
 *         Site : http://www.fayelf.com<br>
 *         Create Time : 2020-08-11
 * @since 1.0.0
 * @version 1.0.0
 */
public class ConfigSet<T> extends EntityBase implements IConfigSet<T> {
	/**
	 * 构造器
	 */
	public ConfigSet() {
		@SuppressWarnings("unchecked")
		Class<T> t = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.classT = t;
		ConfigFile config = t.getAnnotation(ConfigFile.class);
		if (config != null)
			this.config = config;
		EncryptFile encrypt = t.getAnnotation(EncryptFile.class);
		if (encrypt != null)
			this.Encrypt = encrypt.Value();
	}

	/**
	 * 配置文件
	 */
	private ConfigFile config;
	/**
	 * 是否加密
	 */
	private boolean Encrypt;
	/**
	 * 对象类型
	 */
	private Class<T> classT;
	private static Object instance;

	/**
	 * 获取实例化对象
	 * 
	 * @param t   类型
	 * @param <T> 类型
	 * 
	 * @return 实例化对象
	 */
	@SuppressWarnings("unchecked")
	public synchronized static <T> T Current(Class<T> t) {
		if (instance == null) {
			try {
				instance = ((ConfigSet<T>) t.getDeclaredConstructor().newInstance()).get(false);
			} catch (Exception e) {
				e.printStackTrace();
				instance = null;
			}
		}
		return (T) instance;
	}

	/**
	 * 打开文件
	 * 
	 * @param path 路径
	 * @return 返回文件内容
	 */
	@Override
	public String OpenFile(String path) {
		try {
			String flag = "Encrypt";
			@SuppressWarnings("resource")
			InputStream in = new FileInputStream(path);
			byte[] bytes = in.readAllBytes();
			int len = bytes.length;
			int flen = flag.length();
			/* 长度少于加密标识,说明一定不会加密,直接返回数据 */
			if (len <= flag.length()) {
				return new String(bytes);
			}
			/* 如果没有加密文件属性,说明一定会不加密,直接返回数据 */
			if (!this.Encrypt) {
				return new String(bytes);
			}
			Setting setting = Setting.Current(Setting.class);
			String DataKey = setting.getDataKey();
			byte[] flags = new byte[flen];
			System.arraycopy(bytes, 0, flags, 0, flen);
			if (new String(flags).equalsIgnoreCase(flag)) {
				byte[] bytecontent = new byte[len - flen];
				System.arraycopy(bytes, flen, bytecontent, 0, bytecontent.length);
				bytecontent = EncryptUtil.DES.Decrypt(bytecontent, DataKey);
				return new String(bytecontent);
			} else {
				String content = new String(bytes);

				if (setting.isDataEncrypt()) {
					bytes = EncryptUtil.DES.Encrypt(bytes, DataKey);
					byte[] fbyte = flag.getBytes(Charset.forName("UTF-8"));
					OutputStream out = new FileOutputStream(path);
					out.write(fbyte, 0, fbyte.length);
					out.write(bytes, 0, bytes.length);
					out.close();
				}
				return content;
			}

		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 读取文件内容
	 * 
	 * @return 文件内容
	 */
	@SuppressWarnings("unchecked")
	public String ReadContent() {
		ConfigFile attr = this.config;
		if (attr == null)
			return "";
		if (FileHelper.exits(attr.FileName())) {
			return this.OpenFile(attr.FileName());
		} else {
			try {
				T val = (T) this.classT.getDeclaredConstructor().newInstance();
				((ConfigSet<T>) val).save();
				if (attr.configFormat() == ConfigFormat.Json) {
					return JsonHelper.toJson(val, true);
				} else if (attr.configFormat() == ConfigFormat.Xml) {
					return XmlHelper.toXml(val, true);
				} else
					return "";
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
	}

	/**
	 * 获取对象
	 * 
	 * @param reload 是否重载
	 * @return 对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T get(boolean reload) {
		ConfigFile attr = this.config;
		if (attr == null || StringHelper.IsNullOrEmpty(attr.FileName()))
			return null;
		if (!reload) {
			T val = (T) CacheManager.get(attr.CacheKey());
			if (val == null)
				reload = true;
			else {
				//BeanUtils.copyProperties(val, this);
				Reflects.copyProperties(val, this);
				return val;
			}
		}
		if (reload) {
			String val = this.ReadContent();
			switch (attr.configFormat()) {
			case Xml:
				//BeanUtils.copyProperties(XmlHelper.fromXml(val), this);
				Reflects.copyProperties(XmlHelper.fromXml(val), this);
				break;
			default:
				//BeanUtils.copyProperties(JsonHelper.fromJson(val, this.classT), this);
				Reflects.copyProperties(JsonHelper.fromJson(val, this.classT), this);
				break;
			}
			if (this.config == null)
				this.config = attr;
			CacheManager.put(attr.CacheKey(), (T) this, 0);
		}
		return (T) this;
	}

	/**
	 * 保存文件
	 **/
	@SuppressWarnings("unchecked")
	@Override
	public void save() {
		ConfigFile attr = this.config;
		if (attr == null || StringHelper.IsNullOrEmpty(attr.FileName()))
			return;
		String filePath = StringHelper.TrimStart(attr.FileName(), "[/\\\\]");
		File file = new File(filePath);
		File parent = file.getParentFile();
		if (!parent.exists())
			parent.mkdirs();
		String val = "";
		switch (attr.configFormat()) {
		case Xml:
			val = XmlHelper.toXml((T) this, true);
			break;
		default:
			val = JsonHelper.toJson((T) this, true);
			break;
		}
		if (!StringHelper.IsNullOrEmpty(val)) {
			FileHelper.createFile(filePath, val);
			CacheManager.put(attr.CacheKey(), (T) this, 0);
		}
	}
}