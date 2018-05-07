package com.joy.java.util.lang;

import com.joy.java.util.common.CollectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 反射综合类。
 */
public class ReflectUtil {
	
	/**
	 * 检查某个属性是否存在,也有可能是因为安全问题无法访问到。
	 * @param clazz 类信息
	 * @param fieldName 属性名
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
    public static boolean chkFieldExist(Class clazz,String fieldName){
        try {
			clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			return false;
		} catch (SecurityException e) {
			return false;
		}
        return true;
    }
	
	/**
	 * 读取某个属性的值
	 * @param instance 实例
	 * @param clazz 类信息
	 * @param fieldName 属性名
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
    public static Object getFieldValue(Object instance,Class clazz,String fieldName) throws IllegalAccessException, NoSuchFieldException {
        Field field=clazz.getDeclaredField(fieldName);
        field.setAccessible(true);//取消java语言访问检查以访问private变量
        return field.get(instance);
    }


	/**
	 * 设置某个属性的值
	 * @param instance 实例
	 * @param clazz 类信息
	 * @param fieldName 属性名
	 * @param value 值
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
    public static void invokeField(Object instance,Class clazz,String fieldName,Object value) throws IllegalAccessException, NoSuchFieldException {
        Field field=clazz.getDeclaredField(fieldName);
        field.setAccessible(true);//取消java语言访问检查以访问private变量
        field.set(instance,value);
    }
	
	/**
	 * 功能：执行对象中的某个函数。(函数参数类型是接口或者基类，请调用另一个方法。)
	 * @param instance 对象
	 * @param methodName 函数名
	 * @param args 参数
	 * @return Object 执行后函数的返回值
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public static Object invokeMethod(Object instance,String methodName,Object... args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
		//根据参数得到对应的类型数组
		Class[] argArr=null;
		if(!CollectionUtil.isEmpty(args)){
			argArr=new Class[args.length];
			for(int i=0 ; i<args.length ; i++){
				argArr[i]=args[i].getClass();
			}
		}
        return ReflectUtil.invokeMethod(instance,methodName,argArr,args);
	}

    /**
     * 功能：执行对象中的某个函数。
     * @param instance 对象
     * @param methodName 函数名
     * @param parameterTypes 参数类型
     * @param args 参数
     * @return Object 执行后函数的返回值
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static Object invokeMethod(Object instance,String methodName,Class<?>[] parameterTypes,Object... args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Method m = instance.getClass().getDeclaredMethod(methodName, parameterTypes);
        //执行该类的中该方法
        return m.invoke(instance, args);
    }
	
	/**
	 * 功能：得到某个类的一个实例。
	 * @param className 全类名(含包名)
	 * @return <T> T
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T> T getInstance(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class testClass = Class.forName(className);  
        // 调用缺省构造函数，直接用testClass调用就可  
        Object obj = testClass.newInstance();  
        return (T)obj;
	}
	
	/**
	 * 功能：得到某个类的所有方法。
	 * @param classType 类
	 * @return Method[]
	 */
	public static Method[] getAllMethod(Class<?> classType){
		Method[] methods = classType.getDeclaredMethods();
		return methods;
	}
	
	/**
	 * 功能：执行一个静态函数。(函数参数是接口或者基类，请调用另一个方法。)
	 * @param cls 类
	 * @param methodName 静态函数名称
	 * @param args 参数
	 * @return Object 执行后的返回值
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Object invokeStaticMethod(Class<?> cls, String methodName,
            Object... args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		int arguments = args.length;
        Class<?>[] parameterTypes = new Class[arguments];
        for (int i = 0; i < arguments; i++) {
            parameterTypes[i] = args[i].getClass();
        }
        return ReflectUtil.invokeStaticMethod(cls,methodName,parameterTypes,args);
	}

    /**
     * 功能：执行一个静态函数。
     * @param cls 类
     * @param methodName 静态函数名称
     * @param parameterTypes 参数类型
     * @param args 参数
     * @return Object 执行后的返回值
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static Object invokeStaticMethod(Class<?> cls, String methodName,Class<?>[] parameterTypes,Object... args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        Method method = cls.getMethod(methodName, parameterTypes);
        return method.invoke(null, args);
    }
}
