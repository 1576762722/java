package java_base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> ca = new ArrayList<String>();
		ca.add("邯郸学院");
		ca.add("信息工程学院");
		ca.add("张延军");
		
		Iterator<String> it = ca.iterator();
		String s = null;
		while(it.hasNext())
		{
			s = it.next();
			System.out.println(s);
		}
		
		for(String s1:ca) {
			System.out.println(s1);
		}
		
		System.out.println(ca.toString());
		System.out.println(ca);
	}

}

/*
 *  创建list  Collection<String> ca = new ArrayList<String>();
 *  循环 for(String s1:ca)syso.print(s1)
 */