package xiaofeng.core;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 数组工具类
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
public class ArrayHelper {
	/**
	 * 查找字符串
	 * 
	 * @param <T>       类型
	 * @param colls     数组集合
	 * @param predicate 表达式
	 * @return 查到的对象或空
	 */
	public static <T> T Find(Collection<T> colls, Predicate<? super T> predicate) {
		for (T t : colls) {
			if (predicate.test(t))
				return t;
		}
		return null;
	}

	/**
	 * 查找字符串
	 * 
	 * @param <T>       类型
	 * @param ts        数组集合
	 * @param predicate 表达式
	 * @return 查到的对象或空
	 */
	public static <T> T Find(T[] ts, Predicate<? super T> predicate) {
		for (T t : ts) {
			if (predicate.test(t))
				return t;
		}
		return null;
	}

	/**
	 * 遍历方法
	 * 
	 * @param <E>   类型
	 * @param colls 集合
	 * @param after 方法
	 * @return colls集合
	 */
	public static <E> E[] forEach(E[] colls, Consumer<? super E> after) {
		Objects.requireNonNull(after);
		for (E e : colls)
			after.accept(e);
		return colls;
	}

	/**
	 * 遍历方法
	 * 
	 * @param <E>   类型
	 * @param colls 集合
	 * @param after 方法
	 * @return colls集合
	 */
	public static <E> E[] forEach(E[] colls, Predicate<E> after) {
		Objects.requireNonNull(after);
		for (E e : colls)
			if (after.test(e))
				continue;
			else
				break;
		return colls;
	}
}