package java_base;

import java.util.concurrent.locks.ReentrantLock;

public class MyLockStack {

	private char[] ca = new char[10];
	private int point = 0;
	private final ReentrantLock lock = new ReentrantLock();
	public int getPoint() {
		return point;
	}
	
	public char pop() {
		lock.lock();
		char ch = '0';
		try {
			if(this.getPoint() > 0) {
				point --;
				ch = ca[point];
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
			return ch;
		}
	}
	
	public void push(char c) {
		lock.lock();
		try {
			if(this.getPoint() < ca.length) {
				ca[point] = c;
				point ++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLockStack stack = new MyLockStack();
		stack.push('A');
		stack.push('B');
		stack.push('C');
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}

}