package java_base;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("bb");
		ll.add("cc");
		ll.addFirst("aa");
		ll.addLast("dd");
		ll.add(2,"insert");
		System.out.println(ll);
		
		ll.addFirst("ll");
		ll.addLast("aa");
		ll.push("00");
		System.out.println("-----ll.pop()----"+ll.poll());
		System.out.println("-----ll.peek()----"+ll.peek());
		
		System.out.println(ll.size());
		System.out.println("ll[3] = " + ll.get(3));
		System.out.println(ll);
		ll.remove(0);
		System.out.println(ll);
		
		
		
	}

}
