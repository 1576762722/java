package java_base;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("4");
		ts.add("z");
		ts.add("2");
		ts.add("3");
		ts.add("4");
		ts.add("a");
		ts.add("ab");
		ts.add("aa");
		ts.add("ab");
		System.out.println(ts);
		for(String i:ts)
		{
			System.out.println(i);
		}
	}

}
