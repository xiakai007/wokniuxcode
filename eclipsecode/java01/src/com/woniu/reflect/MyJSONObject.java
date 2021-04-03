package com.woniu.reflect;

import java.lang.reflect.Field;

public class MyJSONObject {
	private Object obj;

	public MyJSONObject() {
	}
	public MyJSONObject(Object obj) {
		super();
		this.obj = obj;
	}
	private String objToJSON() throws InstantiationException, IllegalAccessException{
		Class clazz=obj.getClass();
		Field[] fields=clazz.getDeclaredFields();
		//Object obj=clazz.newInstance();
		String result="";
		boolean flag=true;
		for(Field field:fields){
			String objName=field.getName();
			field.setAccessible(true);
			Object objValue=field.get(obj);
			if(flag){
				result=result+"\""+objName+"\":"+objValue;
				flag=false;
			}else{
				result=result+",\""+objName+"\":"+objValue;
			}
			
		}
		result="["+result+"]";
		return result;
	}
	@Override
	public String toString() {
		try {
			return objToJSON();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
