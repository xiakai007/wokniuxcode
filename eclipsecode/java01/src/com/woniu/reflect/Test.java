package com.woniu.reflect;

import java.lang.reflect.Field;

public class Test {
	public static void myClass(String className) throws ClassNotFoundException{
		Class clazz=Class.forName(className);
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields){
			System.out.println(field.getName());
		}
	}
	public static void myField(String className,String fieldName,String fieldValue) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException{
		Class clazz=Class.forName(className);
		Object obj=clazz.newInstance();
		Field field=clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(obj, fieldValue);
		Object objValue=field.get(obj);
		System.out.println(objValue);
	}
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		//myClass("com.woniu.reflect.Goods");
		myField("com.woniu.reflect.Goods","goods_name","xiaomi100");
	}
}
