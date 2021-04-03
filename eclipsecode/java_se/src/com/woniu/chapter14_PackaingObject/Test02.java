package com.woniu.chapter14_PackaingObject;

public class Test02 {
//	class Person{
		int age;
		String name;
		public Test02() {
			super();
			
		}
		public Test02(String name,int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + age;
//			result = prime * result + ((name == null) ? 0 : name.hashCode());
//			return result;
//		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Test02 other = (Test02) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}
		
//	}
	public static void main(String[] args) {
		Test02 t1 = new Test02("张三", 20);
		Test02 t2 = new Test02("张三", 20);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t1==t2);
		System.out.println(t1.equals(t2));
	}

}
