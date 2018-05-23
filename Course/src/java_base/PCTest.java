package java_base;

class MyStack{
	static final int MAX = 5;
	private int[] buffer = new int[MAX];
	private int put_i = 0;
	private int get_i = 0;
	private int size = 0;
	
	public synchronized void push(int i) {
		// TODO Auto-generated method stub
		while(size == MAX) {
			System.out.println("缓存区满,不能放入,请等待...");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		buffer[put_i] = i;
		System.out.println("放入产品:" + buffer[put_i] + "到第" + put_i + "格");
		size ++;
		if(put_i == MAX-1)
		{
			put_i = 1;
		}else {
			put_i ++;
		}
		
		notify();

	}
	
	public synchronized int pop() {
		while(size == 0)
		{
			System.out.println("缓冲区空，不能取，请等待...");
			try {
				
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		size --;
		System.out.printf("%80s\n", "取出产品" + buffer[get_i]);
		if(get_i == MAX -1)
		{
			get_i = 1;
		}else {
			get_i ++;
		}
		
		return buffer[get_i];
		// TODO Auto-generated method stub

	}
}

class Producer extends Thread{
	private MyStack buffer;
	public Producer(MyStack buffer) {
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i = 0;; i++)
			{
				sleep((long) Math.random() * 1000 + 500);
				buffer.push(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer extends Thread{
	private MyStack buffer;
	
	public Consumer(MyStack buffer) {
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			
			while(true) {
				i = buffer.pop();
				sleep((long)Math.random() * 1000 + 500);
			}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class PCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack buffer = new MyStack();
		new Consumer(buffer).start();
		new Consumer(buffer).start();
		new Consumer(buffer).start();
		new Producer(buffer).start();
	}

}
