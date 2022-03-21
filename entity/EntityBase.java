package xiaofeng.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import xiaofeng.json.JsonHelper;
import xiaofeng.xml.XmlHelper;

/**
 * 对象基础类
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
public class EntityBase implements IEntityBase {
	/**
	 * 根据字段名称获取字段值
	 * 
	 * @param name 字段名称
	 * @return 字段值
	 */
	@Override
	public Object Get(String name) {
		try {
			Class<?> type = this.getClass();
			Field field = type.getDeclaredField(name);
			if (field != null) {
				field.setAccessible(true);
				return field.get(this);
			} else {
				String funName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
				Method method = type.getMethod(funName);
				if (method == null)
					return null;
				return method.invoke(this);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 输出字段名及字段值
	 * 
	 * @return 字段字符串
	 */
	public String ToString() {
		String str = this.getClass().getName() + " [";
		for (Field field : this.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				str += field.getName() + "=" + field.get(this) + ",";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str.replaceFirst(",$", "]");
	}

	/**
	 * 转换成JSON格式
	 * 
	 * @param indented 是否格式化
	 * @return JSON格式内容
	 */
	@Override
	public String toJson(boolean indented) {
		return JsonHelper.toJson(this, indented);
	}

	/**
	 * 转换成XML格式
	 * 
	 * @param indented 是否格式化
	 * @return XML格式内容
	 */
	@Override
	public String toXml(boolean indented) {
		return XmlHelper.toXml(this, indented);
	}
}