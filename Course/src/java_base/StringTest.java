package java_base;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";
		String s2 = "abc";
		char[] ca = {'a', 'b', 'c'};
		String s3 = new String(ca);
		String s = "0123456789";
		String s7 = "美国、中国、加拿大、英国、德国";
		char[] cal = s7.toCharArray();
		
		
		System.out.println("s.charAt(5) = " + s.charAt(5));
		System.out.println("abcdefabcdaaa".indexOf('c'));
		System.out.println("Let's make things better".replace('e', 'o'));
		System.out.println("01234567890123456".matches("\\d{17}"));
		System.out.println("012345ab123456".matches("\\d{17}"));
		
		String[] sa = s7.split("[、| , |。]");
		System.out.println(Arrays.toString(sa));
		
		for(String str:sa)
		{
			System.out.println(str);
		}
		
		
		System.out.println("smiles".substring(1, 5));
		
		
	}

}
