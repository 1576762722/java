package java_base;

public class MySynchronized {

	private char[] ca = new char[10];
	private int point = 0;
	
	public int getPoint() {
		return point;
	}
	
	public synchronized char  pop() {
		
		if(this.getPoint() > 0) {
			point --;
			return ca[point];
		}else {
			return '0';
		}
	}
	
	private void push(char c) {
		// TODO Auto-generated method stub
		synchronized (this) {
			if(this.getPoint() < 10) {
				ca[point] = c;
				point ++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		MySynchronized stack = new MySynchronized();
		stack.push('a');
		// TODO Auto-generated method stub

	}

}


/*
* һ��ʱ��ֻ��һ���߳�ִ�и÷���     �ڷ��������м��� sync
* һ��ʱ��ֻ��һ���߳�ִ�иô����  �ڴ����������� sysn(this){}
*/