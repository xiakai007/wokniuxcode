package homework;

public class HW04_Employee {
	String name = "张三";
	int jbn = 12;
	String gender = "男";
	int age = 32;
	float salary = 5000.5F;
	public void selfIntro() {
		System.out.println("大家好！我叫张三，哈是的噶垃圾袋拉嘎打了个呼啦看过");
	}
	public void status(float x) {
		if(x>=5000 && x<10000) {
			System.out.println("张三是蓝领");
		}else if(x>=10000 && x<20000) {
			System.out.println("张三是白领");
		}else if(x>=20000) {
			System.out.println("张三是金领");
		}
	}

}
