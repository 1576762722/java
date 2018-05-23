package java_base;

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer bf1 = new StringBuffer();
		System.out.println(bf1.length());
		System.out.println(bf1.capacity());
		
		
		bf1.append("1234");
		System.out.println(bf1.length());
		System.out.println(bf1.capacity());
		System.out.println(bf1);
		
		StringBuffer bf2 = new StringBuffer("0123456789");
		System.out.println(bf2.length());
		System.out.println(bf2.capacity());
		System.out.println(bf2.toString());
		
		
		bf2.reverse();
		System.out.println(bf2.toString());
		
		bf1.append(bf2);
		System.out.println(bf1);
		bf1.insert(5, "abc");
		System.out.println(bf1);
		
		
		bf1.delete(5, 8);
		System.out.println(bf1);
		
		bf1.replace(3, 7, "XYJ");
		System.out.println(bf1);
		System.out.println();
		
	}

}
