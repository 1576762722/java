package java_base;

public class NewStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "zyj";
		String s2 = "zyj";
		System.out.println(s1 == s2);
		String s3 = new String("zyj");
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s2));
		
	}
	
}

/*
* String s1 = "xx" 属于静态创建方式采用享元模式 也就是  String s2 = "zyj"  相当于 String s2=s1
* String s3 = new String("zyj")  这个是创建一个新的对象
*/