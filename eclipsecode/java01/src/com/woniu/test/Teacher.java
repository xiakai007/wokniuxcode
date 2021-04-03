package com.woniu.test;

public class Teacher<A,B> {
    private A name;
    private B id;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(A name, B id) {
		super();
		this.name = name;
		this.id = id;
	}
	public A getName() {
		return name;
	}
	public void setName(A name) {
		this.name = name;
	}
	public B getId() {
		return id;
	}
	public void setId(B id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", id=" + id + "]";
	}
    public <T> void test(T t){
    	System.out.println(t);
    }
}
