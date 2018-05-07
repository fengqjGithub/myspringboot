package com.joy.java.util.lang;

import com.joy.java.util.common.CollectionUtil;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Object 工具类
 */
public class ObjectUtil {

	/**
	 * 克隆一个对象,必须实现 {@link Cloneable}接口.
	 *
	 * @param <T> 对象类型
	 * @param obj  被克隆的对象.如果为null,直接返回null
	 * @return 如果实现 {@link Cloneable}接口则返回克隆的对象,否则返回{@code null}
	 * @throws Exception 对象可以被克隆,但克隆失败
	 */
	public static <T> T clone(final T obj) {
		if (obj instanceof Cloneable) {
			final Object result;
			if (obj.getClass().isArray()) {
				final Class<?> componentType = obj.getClass().getComponentType();
				if (!componentType.isPrimitive()) {
					result = ((Object[]) obj).clone();
				} else {
					int length = Array.getLength(obj);
					result = Array.newInstance(componentType, length);
					while (length-- > 0) {
						Array.set(result, length, Array.get(obj, length));
					}
				}
			} else {
				try {
					final Method clone = obj.getClass().getMethod("clone");
					result = clone.invoke(obj);
				} catch (final NoSuchMethodException e) {
					throw new RuntimeException("Cloneable type "
							+ obj.getClass().getName()
							+ " has no clone method", e);
				} catch (final IllegalAccessException e) {
					throw new RuntimeException("Cannot clone Cloneable type "
							+ obj.getClass().getName(), e);
				} catch (final InvocationTargetException e) {
					throw new RuntimeException("Exception cloning Cloneable type "
							+ obj.getClass().getName(), e.getCause());
				}
			}
			@SuppressWarnings("unchecked") // OK because input is of type T
			final T checked = (T) result;
			return checked;
		}

		return null;
	}

	/**
	 * 获取出现次数最高的元素,如果存在相同最高次数则返回null.
	 * @param items
	 * @param <T>
     * @return <T>
     */
	public static <T> T mode(final T... items) {
		if (!CollectionUtil.isEmpty(items)) {
			final HashMap<T, Integer> occurrences = new HashMap<T, Integer>(items.length);
			for (final T t : items) {
				final Integer count = occurrences.get(t);
				if (count == null) {
					occurrences.put(t, 1);
				} else {
					occurrences.put(t, count+1);
				}
			}
			T result = null;
			int max = 0;
			for (final Map.Entry<T, Integer> e : occurrences.entrySet()) {
				final int cmp = e.getValue().intValue();
				if (cmp == max) {
					result = null;
				} else if (cmp > max) {
					max = cmp;
					result = e.getKey();
				}
			}
			return result;
		}
		return null;
	}

	/**
	 * 获取第一个不为null的对象
	 * @param values 对象数组
	 * @param <T>
     * @return <T>
     */
	public static <T> T firstNonNull(final T... values) {
		if (values != null) {
			for (final T val : values) {
				if (val != null) {
					return val;
				}
			}
		}
		return null;
	}

	/**
	 * 如果为空返回默认值
	 * @param object
	 * @param defaultValue 默认值
	 * @param <T>
     * @return <T>
     */
	public static <T> T defaultIfNull(final T object, final T defaultValue) {
		return object != null ? object : defaultValue;
	}

	/**
	 * 将map转换为Object，将map key对应的值赋值到Object的属性。
	 * 必须有set方法。
	 * @param map Map
	 * @param cls 类
	 * @return
	 * @throws Exception
	 */
	public static <T> T fromMap(Map<String, String> map, Class<T> cls)
			throws Exception {
		Field[] fields = cls.getDeclaredFields();
		T obj = cls.newInstance();
		for (Field field : fields) {
			Class<?> clsType = field.getType();
			String name = field.getName();
			String strSet = "set" + name.substring(0, 1).toUpperCase()
					+ name.substring(1, name.length());
			Method methodSet = cls.getDeclaredMethod(strSet, clsType);
			if (map.containsKey(name)) {
				Object objValue = typeConversion(clsType, map.get(name));
				methodSet.invoke(obj, objValue);
			}
		}
		return obj;
	}

	private static Object typeConversion(Class<?> cls, String str) {
		Object obj = null;
		String nameType = cls.getSimpleName();
		if ("Integer".equals(nameType)) {
			obj = Integer.valueOf(str);
		}
		if ("String".equals(nameType)) {
			obj = str;
		}
		if ("Float".equals(nameType)) {
			obj = Float.valueOf(str);
		}
		if ("Double".equals(nameType)) {
			obj = Double.valueOf(str);
		}

		if ("Boolean".equals(nameType)) {
			obj = Boolean.valueOf(str);
		}
		if ("Long".equals(nameType)) {
			obj = Long.valueOf(str);
		}

		if ("Short".equals(nameType)) {
			obj = Short.valueOf(str);
		}

		if ("Character".equals(nameType)) {
			obj = str.charAt(1);
		}

		return obj;
	}

	/**
	 * 将Object对象转换为Map，key为属性名，value为属性值。
	 * 必须有get方法。 
	 * @param obj
	 * @return Map<String, Object>
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws Exception
	 */
	public static Map<String, Object> toMap(Object obj)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Map<String, Object> mapValue = new HashMap<String, Object>();
		Class<?> cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			String strGet = "get" + name.substring(0, 1).toUpperCase()
					+ name.substring(1, name.length());
			Method methodGet = cls.getDeclaredMethod(strGet);
			Object value = methodGet.invoke(obj);
			mapValue.put(name, value);
		}
		return mapValue;
	}

	/**
	 * 功能：判断两个object是否为同一个引用。
	 * 
	 * @param obj1
	 *            对象1
	 * @param obj2
	 *            对象2
	 * @return boolean 是返回true，否则返回false。
	 */
	public static boolean equals(Object obj1, Object obj2) {
		return (obj1 != null) ? (obj1.equals(obj2)) : (obj2 == null);
	}

	/**
	 * 功能：判断两个object的类型是否相同。
	 * 
	 * @param object
	 *            第一个对象
	 * @param thiz
	 *            第二个对象
	 * @return boolean 是返回true，否则返回false。
	 */
	public static boolean equalsType(Object object, Object thiz) {
		return (object != null) && (object.getClass().equals(thiz.getClass()));
	}

}
