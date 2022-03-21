package xiaofeng.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON序列化类
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
public class JsonHelper {
	/**
	 * JSON对象
	 */
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 反序列化
	 * 
	 * @param <T>  类型
	 * @param json 内容
	 * @param t    类型
	 * @return 返回序列化后的对象
	 */
	public static <T> T fromJson(String json, Class<T> t) {
		try {
			return mapper.readValue(json, t);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 反序列化
	 * 
	 * @param json 内容
	 * @return 返回序列化后的对象
	 */
	public static Object fromJson(String json) {
		return fromJson(json, Object.class);
	}

	/**
	 * 序列化
	 * 
	 * @param <T>    类型
	 * @param entity 对象
	 * @return 反序列化后的JSON内容
	 */
	public static <T> String toJson(T entity) {
		return toJson(entity, false);
	}

	/**
	 * 序列化
	 * 
	 * @param <T>      类型
	 * @param entity   对象
	 * @param Indented 是否格式化
	 * @return 反序列化后的JSON内容
	 */
	public static <T> String toJson(T entity, boolean Indented) {
		try {
			return Indented ? mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity)
					: mapper.writeValueAsString(entity);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
}