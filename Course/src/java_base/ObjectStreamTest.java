package java_base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student1 implements Serializable{
	private static final long serialVersionUID = 1L;
	transient int id;
	static int age;
	private String name;
	String dept;
	
	public Student1(int id, String name, int age, String dept) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student1[id= " + id+ ", name = " + name + ", dept = " + dept + ", age = " + age + "]";
	}
}

public class ObjectStreamTest {

	private void savaObj() {
		// TODO Auto-generated method stub
		Student1 stu = new Student1(981036, "李明", 16, "CSD");
		try {
			FileOutputStream fos = new FileOutputStream("o.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(stu);
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	
	private void readObj()throws Exception {
		// TODO Auto-generated method stub
		Student1 stu;
		FileInputStream fis = new FileInputStream("o.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		stu = (Student1)ois.readObject();
		System.out.println(stu);
		
	}
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		ObjectStreamTest ost = new ObjectStreamTest();
		ost.savaObj();
		ost.readObj();
	}
}

/*
 * 存在read文件都会出现异常需要异常声明
 */
