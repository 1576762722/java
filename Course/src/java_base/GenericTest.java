package java_base;

import java.util.Date;
import java.util.Hashtable;

public class GenericTest <K, V>{

	Hashtable<K, V> ht = new Hashtable<K, V>();
	
	private void put(K k, V v) {
		// TODO Auto-generated method stub
		ht.put(k, v);
	}
	
	private V get(K k) {
		// TODO Auto-generated method stub
		return ht.get(k);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericTest<Integer, String> gt = new GenericTest<Integer, String>();
		gt.put(9,  "�����ǵػ�");
		System.out.println(gt.get(9));
		
		GenericTest<String, Date> gt1 = new GenericTest<String, Date>();
		gt1.put("������", new Date());
		System.out.println(gt1.get("������"));
	}

}


/*
*������ʵ���ǼӶ�һ����������� <>
*/