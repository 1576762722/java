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
		gt.put(9,  "天王盖地虎");
		System.out.println(gt.get(9));
		
		GenericTest<String, Date> gt1 = new GenericTest<String, Date>();
		gt1.put("好日子", new Date());
		System.out.println(gt1.get("好日子"));
	}

}


/*
*泛型其实就是加多一个对类的限制 <>
*/