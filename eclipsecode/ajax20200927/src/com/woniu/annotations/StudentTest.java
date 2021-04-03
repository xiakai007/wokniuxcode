package com.woniu.annotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
public class StudentTest {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		Class clazz=Student.class;
		/*提取类上的注解*/
		Annotation[] annotations=clazz.getAnnotations();
		for(Annotation annotation:annotations){
			System.out.println(annotation);
		}
		/*提取类上的注解Sleep的id和name*/
		if(clazz.isAnnotationPresent(Sleep.class)){
			Sleep sleepAno=(Sleep)clazz.getAnnotation(Sleep.class);
			System.out.println(sleepAno.id());
			System.out.println(sleepAno.name());
		}
		/*提取属性上的注解*/
		Field field=clazz.getDeclaredField("stuId");
		if(field.isAnnotationPresent(Sleep.class)){
			Sleep sleep=field.getAnnotation(Sleep.class);
			System.out.println(sleep.id());
			System.out.println(sleep.name());
		}
		/*提取方法上的注解*/
		Method method=clazz.getDeclaredMethod("setStuId", Integer.class);
		if(method.isAnnotationPresent(Test.class)){
			Test test=method.getAnnotation(Test.class);
			System.out.println(test.value());
		}
		/*提取参数上的注解*/
		Method method2=clazz.getDeclaredMethod("setStuName", String.class);
		Parameter[] parameters=method2.getParameters();
		for(Parameter parameter:parameters){
			if(parameter.isAnnotationPresent(Test.class)){
				Test test=parameter.getAnnotation(Test.class);
				System.out.println(test.value());
			}
		}
	}

}
