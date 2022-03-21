package xiaofeng.core;

import java.util.Collection;
import java.util.function.Predicate;

public class ArrayUtil {
	/**
	 * @查找字符串
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
	 * @查找字符串
	 * @param ts     数组集合
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
}