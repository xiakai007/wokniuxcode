package com.woniu.bean.pojo;

import java.util.List;

public class Category {
	private Integer id;
	private String name;
	private String status;
	private String navable;
	public Category() {
		super();
	}
	public Category(Integer id, String name, String status, String navable) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.navable = navable;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNavable() {
		return navable;
	}
	public void setNavable(String navable) {
		this.navable = navable;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", status=" + status + ", navable=" + navable + "]";
	}
    

}
