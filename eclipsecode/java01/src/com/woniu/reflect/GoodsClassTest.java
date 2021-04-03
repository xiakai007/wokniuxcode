package com.woniu.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GoodsClassTest {
	private Object obj;
	public static void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Object obj=clazz.newInstance();
		System.out.println(obj);
	}
	public static void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Field[] fields=clazz.getFields();
		for(Field field:fields){
			System.out.println("公有属性名称:"+field.getName());
		}
	}
	public static void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields){
			System.out.println("定义的属性名称:"+field.getName());
		}
	}
	public static void test4() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Method[] methods=clazz.getMethods();
		for(Method method:methods){
			System.out.println("公有的方法名称:"+method.getName());
		}
	}
	public static void test5() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Method[] methods=clazz.getDeclaredMethods();
		for(Method method:methods){
			System.out.println("定义的方法名称:"+method.getName());
		}
	}
	public static void test6(String fieldName,String fieldValue) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Object obj=clazz.newInstance();
		Field field=clazz.getField(fieldName);
		field.set(obj, fieldValue);
		System.out.println(fieldName+"赋值成功");
		Object objValue=field.get(obj);
		System.out.println(fieldName+"的值为："+objValue);
	}
	public static void test8(String fieldName,String fieldValue) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Object obj=clazz.newInstance();
		Field field=clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(obj, fieldValue);
		System.out.println(fieldName+"赋值成功");
		Object objValue=field.get(obj);
		System.out.println(fieldName+"的值为："+objValue);
	}
	public static void test11(String MethodName,String parameter) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Goods goods=(Goods)clazz.newInstance();
		Method method=clazz.getDeclaredMethod(MethodName, String.class);
		method.invoke(goods, parameter);
	}
	public static void test12() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Constructor[] constructors=clazz.getConstructors();
		for(Constructor constructor:constructors){
			System.out.println(constructor);
		}
	}
	public static void test13(Integer goods_id,String goods_name) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
		Class clazz=Class.forName("com.woniu.reflect.Goods");
		Constructor constructor=clazz.getConstructor(Integer.class,String.class);
		Object obj=constructor.newInstance(goods_id,goods_name);
		System.out.println(obj);
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		System.out.println("----------------------1----------------------");
		GoodsClassTest.test1();
		System.out.println("----------------------2----------------------");
		GoodsClassTest.test2();
		System.out.println("----------------------3----------------------");
		GoodsClassTest.test3();
		System.out.println("----------------------4----------------------");
		GoodsClassTest.test4();
		System.out.println("----------------------5----------------------");
		GoodsClassTest.test5();
		System.out.println("----------------------6----------------------");
		GoodsClassTest.test6("公有属性totalMana","qweasdf");
		System.out.println("----------------------8----------------------");
		GoodsClassTest.test8("私有属性goods_name","主线程vbn");
		System.out.println("----------------------11----------------------");
		GoodsClassTest.test11("publicShow","asd");
		System.out.println("----------------------12----------------------");
		GoodsClassTest.test12();
		System.out.println("----------------------13----------------------");
		GoodsClassTest.test13(1111,"tomqweasdf");
	}

}
