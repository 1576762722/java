package java_base;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Pattern.matches("a * b", "aaaaab"));
		System.out.println("01234567890123456".matches("\\d{17}"));
		Pattern p = Pattern.compile("ab\\. *c");
		Matcher m = p.matcher("ab..cxyzab...cxxx");
		while(m.find())
		{
			System.out.println(m.group()+ ":" + m.start() + "," + m.end());
		}
		
		Scanner sc = new Scanner("1 fish 2 fish red fish blue fish");
		sc.useDelimiter("\\s*fish\\s*");
		while(sc.hasNext())
		{
		}
	}

}
