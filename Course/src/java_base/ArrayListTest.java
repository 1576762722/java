package java_base;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("78");
		a1.add("3.14");
		a1.add("China");
		a1.add("America");
		System.out.println(a1.get(1));
		a1.remove(3);
		System.out.println(a1.size());
		for(String i:a1)
		{
			System.out.println(i);
		}
		System.out.println(a1);
		
		for(int i = 0; i < a1.size(); i++)
		{
			System.out.println(a1.get(i));
		}
	}
}
/*
 *foreach ����ͦ���õ�  ֻ��list���е�Ԫ����Ҫʹ�÷��������л�ȡ a1.get(index)
 */