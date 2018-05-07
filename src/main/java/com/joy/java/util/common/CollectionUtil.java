package com.joy.java.util.common;

import java.util.*;


/**
 * 集合(List,Map,Set)辅助类。
 */
public class CollectionUtil {
	
	/**
	 * 功能：从List中随机取出一个元素。
	 * @param list 源List
	 * @return T List的一个元素
	 */
	public static <T> T randomOne(List<T> list){
		if(isEmpty(list)){
			return null;
		}
		return list.get(MathUtil.randomNumber(0, list.size()));
	}
	
	/**
	 * 功能：从set中随机取出一个元素。
	 * @param set 源
	 * @return T set的一个元素
	 */
	public static <T> T randomOne(Set<T> set){
		if(isEmpty(set)){
			return null;
		}
		//首先转成list
		List<T> list=toList(set.iterator());
		return list.get(MathUtil.randomNumber(0, list.size()));
	}
	
	/**
	 * 功能：从数组中随机取出一个元素。
	 * @param objs 源数组
	 * @return T 数组的一个元素
	 */
	public static <T> T randomOne(T[] objs){
		if(isEmpty(objs)){
			return null;
		}
		return objs[MathUtil.randomNumber(0, objs.length)];
	}
	
	/**
	 * 功能：数组中是否存在这个元素。
	 * @param objArr 数组
	 * @param compare 元素
	 * @return 存在返回true，否则返回false。
	 */
	public static <T> boolean arrayContain(T[] objArr,T compare){
		if(isEmpty(objArr)){
			return false;
		}
		for(T obj : objArr){
			if(obj.equals(compare)){
				return true;
			}
		}
		return false;
	}
	

	/**
	 * 功能：向list中添加数组。
	 * @param list List
	 * @param array 数组
	 */
	public static <T> void addArrayToList(List<T> list, T[] array) {
		if (isEmpty(array)) {
			return;
		}
		if(list==null){
			list=new ArrayList<T>();
		}
		for (T t : array) {
			list.add(t);
		}
	}
	
	/**
	 * 功能：将数组进行反转，倒置。
	 * @param objs 源数组
	 * @return T[] 反转后的数组
	 */
	public static <T> T[] reverse(T[] objs){
		if(isEmpty(objs)){
			return null;
		}
		T[] res=(T[])java.lang.reflect.Array.newInstance(objs[0].getClass(), objs.length);
		//新序号
		int k=0;
		for(int i=objs.length-1 ; i>=0 ; i--){
			res[k++]=objs[i];
		}
		return res;
	}
	
	/**
	 * 功能：将List进行反转，倒置。
	 * @param list 源
	 * @return list 反转后的list
	 */
	public static <T> List<T> reverse(List<T> list){
		if(isEmpty(list)){
			return null;
		}
		List<T> newlist=new LinkedList<T>();
		for(int i=list.size()-1 ; i>=0 ; i--){
			newlist.add(list.get(i));
		}
		return newlist;
	}
	
	/**
	 * 功能：将Set进行反转，倒置。
	 * @param set 源
	 * @return Set 反转后Set
	 */
	public static <T> Set<T> reverse(Set<T> set){
		if(isEmpty(set)){
			return null;
		}
		//首先转成list
		List<T> list=toList(set.iterator());
		return toSet(reverse(list).iterator());
	}
	
	/**
	 * 功能：将数组转为list。
	 * @param objs 源数组
	 * @return List
	 */
	public static <T> List<T> toList(T[] objs){
		if(isEmpty(objs)){
			return null;
		}
		List<T> list=new LinkedList<T>();
		for(T obj : objs){
			list.add(obj);
		}
		return list;
	}
	
	/**
	 * 功能：转为list。
	 * @param iterator
	 * @return List
	 */
	public static <T> List<T> toList(Iterator<T> iterator){
		List<T> list=new LinkedList<T>();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
		return list;
	}
	
	/**
	 * 功能：转为Set。
	 * @param iterator
	 * @return Set
	 */
	public static <T> Set<T> toSet(Iterator<T> iterator){
		Set<T> set=new LinkedHashSet<T>();
        while(iterator.hasNext()){
        	set.add(iterator.next());
        }
		return set;
	}
	
	/**
	 * 功能：将数组转为Set。
	 * @param objs 源数组
	 * @return Set
	 */
	public static <T> Set<T> toSet(T[] objs){
		if(isEmpty(objs)){
			return null;
		}
		Set<T> set=new LinkedHashSet<T>();
		for(T obj : objs){
			set.add(obj);
		}
		return set;
	}
	
	/**
	 * 功能：转为数组。
	 * @param iterator
	 * @return T[]
	 */
	public static <T> T[] toArray(Iterator<T> iterator){
		List<T> list=toList(iterator);
		T[] objs=(T[])java.lang.reflect.Array.newInstance(list.get(0).getClass(), list.size());
		int i=0; //数组下标。
		for(T obj : list){
			objs[i++]=obj;
		}
		return objs;
	}
	
	/**
	 * 将一个object添加到一个数组中，并返回一个新数组。
	 * @param array 被添加到的数组
	 * @param obj 被添加的object
	 * @return T[] 返回的新数组
	 */
	public static <T> T[] addToArray(T[] array, T obj) {
		//结果数组
		T[] resArray=null;
		if (isEmpty(array)) {
			resArray=(T[])java.lang.reflect.Array.newInstance(obj.getClass(), 1);
			resArray[0]=obj;
			return resArray;
		}
		//原数组不为空时。
		resArray=(T[])java.lang.reflect.Array.newInstance(array[0].getClass(), array.length+1);
		System.arraycopy(array, 0, resArray, 0, array.length);
		resArray[array.length] = obj;
		return resArray;
	}
	
	/**
	 * 将一个迭代添加到一个数组中，并返回一个新数组。
	 * @param array 被添加到的数组
	 * @param iterator 迭代
	 * @return T[] 返回的新数组
	 */
	public static <T> T[] addToArray(T[] array, Iterator<T> iterator) {
		while(iterator.hasNext()){
			array=addToArray(array,iterator.next());
        }
		return array;
	}
	
	/**
	 * 将一个数组添加到另一个数组中，并返回一个新数组。
	 * @param array1 被添加到的数组
	 * @param array2 需要添加的数组
	 * @return T[] 返回的新数组
	 */
	public static byte[] addToArray(byte[] array1, byte[] array2) {
		if (array1==null || array1.length==0) {
			return array2;
		}
		if (array2==null || array2.length==0) {
			return array1;
		}
		byte[] resArray=new byte[array1.length+array2.length];
		System.arraycopy(array1, 0, resArray, 0, array1.length);
		System.arraycopy(array2, 0, resArray, array1.length, array2.length);
		return resArray;
	}
	
	/**
	 * 将一个数组添加到另一个数组中，并返回一个新数组。
	 * @param array1 被添加到的数组
	 * @param array2 需要添加的数组
	 * @return T[] 返回的新数组
	 */
	public static <T> T[] addToArray(T[] array1, T[] array2) {
		if (isEmpty(array1)) {
			return array2;
		}
		if (isEmpty(array2)) {
			return array1;
		}
		T[] resArray=(T[])java.lang.reflect.Array.newInstance(array1[0].getClass(), array1.length+array2.length);
		System.arraycopy(array1, 0, resArray, 0, array1.length);
		System.arraycopy(array2, 0, resArray, array1.length, array2.length);
		return resArray;
	}
	
	/**
	 * 功能：判断数组是不是空。（null或者length==0）
	 * @param array 数组
	 * @return boolean 空返回true，否则返回false。
	 */
	public static <T> boolean isEmpty(T[] array) {
		return (array == null || array.length==0);
	}
	
	
	/**
	 * 功能：集合是否为空。如果传入的值为null或者集合不包含元素都认为为空。
	 * @param collection 集合
	 * @return boolean 为空返回true，否则返回false。
	 */
	public static boolean isEmpty(Collection collection) {
		return (collection == null || collection.isEmpty());
	}

	/**
	 * 功能：Map是否为空。如果传入的值为null或者集合不包含元素都认为为空。
	 * @param map Map
	 * @return boolean 为空返回true，否则返回false。
	 */
	public static boolean isEmpty(Map map) {
		return (map == null || map.isEmpty());
	}
	
}
