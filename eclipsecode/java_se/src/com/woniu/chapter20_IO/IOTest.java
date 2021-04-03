package com.woniu.chapter20_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IOTest {
	@Test
	public void test13() {
		//反序列化，输入对象，读
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.mp5"))){
			List<Person> listP= (List<Person>) ois.readObject();
			System.out.println(listP);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test12() {
		//序列化，输出对象，写
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.mp5"))){
			List<Person> listP = new ArrayList<>();
			listP.add(new Person("tom",20));
			listP.add(new Person("jack",22));
			listP.add(new Person("john",16));
			System.out.println(listP);
			oos.writeObject(listP);
			oos.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test11() {
		//字节缓冲流边读边写
		File f1 = new File("02.txt");//png格式转换为jpg格式
		File f2 = new File("04.jpg");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2))){
			byte[] buf = new byte[1024];
			int len;
			while((len = bis.read(buf))!=-1) {
				bos.write(buf, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test10() {
		//字符缓冲流边读边写
		File f1 = new File("hello.txt");
		File f2 = new File("03.txt");
		try(BufferedReader br = new BufferedReader(new FileReader(f1));
				BufferedWriter bw = new BufferedWriter(new FileWriter(f2))){
//			//方式一
//			String data = null;
//			while((data = br.readLine())!=null) {
//				bw.write(data);
//				bw.newLine();
//			}
			//方式二
			char[] cbuf = new char[1024];
			int len;
			while((len = br.read(cbuf))!=-1) {
				bw.write(cbuf, 0, len);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void test9() {
		//使用字节流读，输入
		File f = new File("hello.txt");
		//创建字节流
		try(FileInputStream fis = new FileInputStream(f)){
//			int data = fis.read();//中文乱码，汉字2个字节
//			while((data = fis.read())!=-1) {
//				System.out.print((char)data);
//			}
			byte[]buf =new byte[1024];
			int len;
			while((len=fis.read(buf))!=-1) {
				System.out.print(new String(buf,0,len));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test8() {
		//边读边写
		File f1 = new File("hello.txt");
		File f2 = new File("hello3.txt");
		try(FileReader fr = new FileReader(f1);
				FileWriter fw = new FileWriter(f2)){
			char []cbuf = new char[3];
			int len;
			while((len = fr.read(cbuf))!=-1) {
				fw.write(cbuf, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void test7() {
		//使用字符输出流写
		File f = new File("hello2.txt");
		//创建流，抓异常
		try(FileWriter fw = new FileWriter(f,true)){//true表示在原有字符基础上追加新的字符
			fw.write("蜗牛学院：\n");
			fw.write("欢迎学习");
			fw.write("你好，蜗牛学院");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void f() {
		//1.获取文件路径-创建File对象,输入流
		File f = new File("hello.txt");
		//2.创建流
		try(FileReader fr = new FileReader(f)){
			//读取的数据保存到形参char数组cbuf中
			char []cbuf = new char[1024];
			int len;
			while((len = fr.read(cbuf))!=-1) {
//				System.out.println(new String(cbuf));
				System.out.println(new String(cbuf,0,len));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void test5() {
		// 1.获取文件路径 --- 创建File对象,输入流
		File f = new File("hello.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 2、创建流
		try(FileReader fr = new FileReader(f)){
			// 3、读取数据 --- read()
//			int c = fr.read();
//			while(c!=-1) {
//				System.out.print((char)c);
//				c = fr.read();
//			}
			int data;
			while((data = fr.read())!=-1) {
				System.out.print((char)data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test4() {
		File f1 = new File("D:\\File1\\File1-1\\hello.java");
		try {
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test3() {
		File f1 = new File("D:\\File1\\File1-1\\File1-1-1");
		f1.mkdirs();
		File f2 = new File("D:\\File1\\File1-1\\File1-1-1\\hello.java");
		try {
			f2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//getName()寰楀埌鏈�鍐呭眰鐨勬枃浠跺す鍚嶆垨鏂囦欢鍚�
		String f1Name = f1.getName();
		System.out.println(f1Name);
		//delete()鍙兘鍒犻櫎鏂囦欢銆佺┖鏂囦欢澶广��
		//delete()鍙兘鍒犻櫎鏂囦欢銆�
		boolean flag1 = f2.delete();
		System.out.println(flag1);
		//delete()鍙兘鍒犻櫎绌烘枃浠跺す銆�
		boolean flag2 = f1.delete();
		System.out.println(flag2);
		
		File f3 = new File("D:\\File1\\File1-1\\hello.java");
		try {
			f3.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//delete()涓嶈兘鍒犻櫎绌烘枃浠跺す銆�
		boolean flag3 = new File("D:\\File1\\File1-1").delete();
		System.out.println(flag3);
		boolean flag4 = new File("D:\\File1\\File1-1\\hello.java").delete();
		System.out.println(flag4);
	}
	@Test
	public void test2() {
		File f1 = new File("D:\\360瀹夊叏娴忚鍣ㄤ笅杞�");
//		//閬嶅巻褰撳墠鐩綍涓嬬殑鎵�鏈夋枃浠跺拰鏂囦欢澶�,杩斿洖鍊间负String绫诲瀷
//		String []list = f1.list();
//		for (int i = 0; i < list.length; i++) {
//			String fileName = list[i];
//			System.out.println(fileName);
//		}
		//閬嶅巻褰撳墠鐩綍涓嬬殑鎵�鏈夋枃浠跺拰鏂囦欢澶�,杩斿洖鍊间负File瀵硅薄绫诲瀷
		File[] listFiles = f1.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			File file = listFiles[i];
			//isDirectory()鍒ゆ柇鏄惁鏄枃浠跺す锛岃繑鍥炲�间负boolean绫诲瀷
//			String res = file.isDirectory()?"鏂囦欢澶�":"鏂囦欢";
			//isFile()鍒ゆ柇鏄惁鏄枃浠讹紝杩斿洖鍊间负boolean绫诲瀷
			String res = file.isFile()?"鏂囦欢":"鏂囦欢澶�";
			System.out.println(file+":"+res);
		}
		
	}
	@Test
	public void test1() {
		//鍒涘缓鏂囦欢,浠ュ綋鍓嶆枃浠舵墍鍦ㄥ伐绋嬩负鐩稿璺緞璧风偣
		File f1 = new File("Hello.txt");
		try {
			//鍒涘缓璇ユ枃浠�
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(f1);
		f1 = new File("D:\\software\\eclipse\\workspace_01\\java_se\\Hello.txt");
		//鍒ゆ柇鏂囦欢鏄惁瀛樺湪
		System.out.println(f1.exists());
		//鍒犻櫎鏂囦欢
		f1.delete();
		System.out.println(f1.exists());
	}

}
class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4862900026658627305L;
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}