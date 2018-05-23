package java_base;

public class PriorityTest implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 5; ++i)
		{
			System.out.println(Thread.currentThread().getName() + "running" + i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main:" + Thread.currentThread().getPriority());
		
		Thread t1 = new Thread(new PriorityTest(), "A");
		Thread t2 = new Thread(new PriorityTest(), "B");
		Thread t3 = new Thread(new PriorityTest(), "C");
		
		System.out.println("h1:" + t1.getPriority());
		
		t1.setPriority(8);
		t2.setPriority(2);
		t3.setPriority(6);
		t1.start();
		t2.start();
		t3.start();
	}

}
