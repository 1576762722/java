package java_base;

import java.util.HashMap;

class Student{
	private int sno = 0;
	private String name;
	private double score;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sno, String name, double score) {
		// TODO Auto-generated constructor stub
		super();
		this.sno = sno;
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "S[" + sno + ","+ name + "," + score + "]";
	}
	
}
public class HashMapTest {

	public static void main(String[] args) {
		HashMap<Integer, Student> hh = new HashMap<Integer, Student>();
		hh.put(199901, new Student(199901, "java", 98));
		hh.put(199902, new Student(199902, "ZhangSan", 98));
		hh.put(199903, new Student(199903, "LiSi", 98));
		hh.put(199904, new Student(199904, "WnagWu", 98));
		hh.put(199905, new Student(199905, "Zhengliu", 98));
		hh.put(199906, new Student(199906, "XiaoMing", 98));
		
		System.out.println(hh.size());
		System.out.println(hh.get(199906));
		
		for(int key1: hh.keySet())
		{
			System.out.println(key1 + ":" + hh.get(key1));
		}
		
	}
}

/**
 * 字典的定义  hashmap<xx,xx>
 * 字典dict的历遍方式
 * for(int key1: hh.keyset())  思路是将二维转化成一维；
 */
