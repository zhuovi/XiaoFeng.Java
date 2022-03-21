package xiaofeng.cryptography;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import xiaofeng.core.EnumHelper;
import xiaofeng.cryptography.Enum.CipherEncryptType;
import xiaofeng.cryptography.Enum.MDEnum;

/**
 * MD加密类
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
public class MDCrypto extends CipherEncrypt {
	/**
	 * 无参构造器
	 */
	public MDCrypto() {
		super(CipherEncryptType.MD5);
	}

	/**
	 * 设置参数
	 * 
	 * @param md 加密模式
	 */
	public MDCrypto(MDEnum md) {
		this(md, Charset.forName("UTF-8"), SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param md      加密模式
	 * @param charset 编码
	 */
	public MDCrypto(MDEnum md, Charset charset) {
		this(md, charset, SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param md            加密模式
	 * @param charset       编码
	 * @param secretKeyType 密钥当key用还是当种子用
	 */
	public MDCrypto(MDEnum md, Charset charset, SecretKeyType secretKeyType) {
		super(EnumHelper.GetEnumValue(CipherEncryptType.class, a -> a.getEncryptType() == md.getEncryptType())
				.findFirst().get(), charset, secretKeyType);
	}

	/**
	 * 加密方法
	 * 
	 * @param data 字符串
	 * @return 字符串
	 */
	@Override
	public String Encrypt(String data) {
		return this.Encrypt(data, "32");
	}

	/**
	 * 加密方法
	 * 
	 * @param data    字符串
	 * @param slatKey 位数 只认 16和32
	 * @return 字符串
	 */
	@Override
	public String Encrypt(String data, String slatKey) {
		byte[] datas = this.encode(data.getBytes(this.getCharset()), slatKey, "", 1);
		String code = new BigInteger(1, datas).toString(16);
		for (int i = 0; i < 32 - code.length(); i++)
			code = "0" + code;
		return slatKey == "16" ? code.substring(8, 24) : code;
	}

	/**
	 * 加密解密方法
	 * 
	 * @param data      字符串
	 * @param slatKey   密钥
	 * @param vectorKey 偏移量
	 * @param mode      模式 1加密 2 解密
	 * @return 字符串
	 */
	@Override
	protected byte[] encode(byte[] data, String slatKey, String vectorKey, int mode) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(this.getEncryptType().getEncryptType());
			return messageDigest.digest(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
