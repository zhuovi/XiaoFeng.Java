package xiaofeng.xml;

import java.io.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * XML操作类
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
public class XmlHelper {
	private static XmlMapper xmlMapper = new XmlMapper();

	/**
	 * 反序列化
	 * 
	 * @param <T> 类型
	 * @param t   类型
	 * @param xml 内容
	 * @return 返回序列化后的对象
	 */
	public static <T> T fromXml(String xml, Class<T> t) {
		try {
			return xmlMapper.readValue(xml, t);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 反序列化
	 * 
	 * @param xml 内容
	 * @return 返回序列化后的对象
	 */
	public static Object fromXml(String xml) {
		return fromXml(xml, Object.class);
	}

	/**
	 * 序列化
	 * 
	 * @param <T>    类型
	 * @param entity 对象
	 * @return 反序列化后的XML内容
	 */
	public static <T> String toXml(T entity) {
		return toXml(entity, false);
	}

	/**
	 * 序列化
	 * 
	 * @param <T>      类型
	 * @param entity   对象
	 * @param Indented 是否格式化
	 * @return 反序列化后的XML内容
	 */
	public static <T> String toXml(T entity, boolean Indented) {
		try {
			return Indented ? xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity)
					: xmlMapper.writeValueAsString(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}
}