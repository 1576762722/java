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
* String s1 = "xx" ���ھ�̬������ʽ������Ԫģʽ Ҳ����  String s2 = "zyj"  �൱�� String s2=s1
* String s3 = new String("zyj")  ����Ǵ���һ���µĶ���
*/