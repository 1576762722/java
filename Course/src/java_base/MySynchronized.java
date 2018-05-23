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
* 一个时间只能一个线程执行该方法     在方法声明中加上 sync
* 一个时间只能一个线程执行该代码块  在代码块中外加上 sysn(this){}
*/