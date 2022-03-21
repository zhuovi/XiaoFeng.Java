package xiaofeng.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import xiaofeng.core.ObjectHelper;
import xiaofeng.log.LogHelper;

/**
 * 反射基础类
 * 
 * @author Author : Jacky<br>
 *         Company : 魔法精灵<br>
 *         QQ:7092734<br>
 *         Email : jacky@fayelf.com<br>
 *         Site : http://www.fayelf.com<br>
 *         Create Time : 2020-08-14
 * @since 1.0.0
 * @version 1.0.0
 */
public class Reflects {
	/**
	 * 获取类型的所有字段包括父类的公共字段以及本身的public private proteced 字段
	 * 
	 * @param c 类型
	 * @return 所有字段
	 */
	public static Field[] getFields(Class<?> c) {
		Field[] p = c.getFields();
		Field[] d = c.getDeclaredFields();
		Field[] t = new Field[p.length + d.length];
		System.arraycopy(p, 0, t, 0, p.length);
		System.arraycopy(d, 0, t, p.length, d.length);
		return t;
	}

	/**
	 * 获取类型的所有字段包括父类的公共方法以及本身的方法
	 * 
	 * @param c 类型
	 * @return 所有方法
	 */
	public static Method[] getMethods(Class<?> c) {
		Method[] p = c.getMethods();
		Method[] d = c.getDeclaredMethods();
		Method[] t = new Method[p.length + d.length];
		System.arraycopy(p, 0, t, 0, p.length);
		System.arraycopy(d, 0, t, p.length, d.length);
		return t;
	}

	/**
	 * 获取字段
	 * 
	 * @param c    类型
	 * @param name 字段名称
	 * @return 字段
	 */
	public static Field getField(Class<?> c, String name) {
		try {
			return c.getDeclaredField(name);
		} catch (Exception e) {
			try {
				return c.getField(name);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * 获取方法
	 * 
	 * @param c    类型
	 * @param name 方法名称
	 * @return 方法
	 */
	public static Method getMethod(Class<?> c, String name) {
		try {
			return c.getDeclaredMethod(name);
		} catch (Exception e) {
			try {
				return c.getMethod(name);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * 复制属性
	 * 
	 * @param source 源对象
	 * @param target 目标对象
	 */
	public static void copyProperties(Object source, Object target) {
		if (ObjectHelper.IsNullOrEmpty(source) || ObjectHelper.IsNullOrEmpty(target)) {
			LogHelper.debug("源对象和目标对象不能为空.");
			return;
		}
		Class<?> sourceType = source.getClass();
		Class<?> targetType = target.getClass();

		for (Field field : Reflects.getFields(sourceType)) {
			field.setAccessible(true);
			Field targetField = Reflects.getField(targetType, field.getName());
			if (targetField != null) {
				try {
					targetField.setAccessible(true);
					targetField.set(target, field.get(source));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}