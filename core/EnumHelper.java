package xiaofeng.core;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 枚举工具类
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
public class EnumHelper {
	/**
	 * 全局对象
	 */
	@SuppressWarnings("rawtypes")
	private static Map<Class, Object> map = new ConcurrentHashMap<>();

	/**
	 * 根据条件获取枚举对象
	 * 
	 * @param className 枚举类
	 * @param predicate 筛选条件
	 * @param <T>       类型
	 * @return 查找到的对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> Stream<T> GetEnumValue(Class<T> className, Predicate<T> predicate) {
		if (!className.isEnum()) {
			return null;
		}
		Object obj = map.get(className);
		T[] ts = null;
		if (obj == null) {
			ts = className.getEnumConstants();
			map.put(className, ts);
		} else {
			ts = (T[]) obj;
		}
		return Arrays.stream(ts).filter(predicate);
	}
}