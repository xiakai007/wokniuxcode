package com.woniu.chapter17_outer_inner_lambda;

public class Car {
	private String color;
	private int type;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Car() {
		super();
	}
	public Car(String color, int type) {
		super();
		this.color = color;
		this.type = type;
	}
	@Override
	public String toString() {
		return "这是一辆"+type+"款"
				+color+"的汽车";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
