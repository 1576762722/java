package java_base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> ca = new ArrayList<String>();
		ca.add("����ѧԺ");
		ca.add("��Ϣ����ѧԺ");
		ca.add("���Ӿ�");
		
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
 *  ����list  Collection<String> ca = new ArrayList<String>();
 *  ѭ�� for(String s1:ca)syso.print(s1)
 */