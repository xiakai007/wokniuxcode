package com.woniu.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NoBugTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Class clazz=NoBug.class;
		Method[] methods=clazz.getDeclaredMethods();
		Object obj=clazz.newInstance();
		int count=0;
		for(Method method:methods){
			if(method.isAnnotationPresent(NoBugCheck.class)){
				try {
					method.invoke(obj, 2,0);
				} catch (Exception e) {
					e.printStackTrace();
					count++;
				} 
			}
		}
		System.out.println("代码中有"+count+"处错误");
	}

}
