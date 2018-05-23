package java_base;

class MyCommon extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++)
		{
			System.out.println("前台线程第" + i + "次执行!");
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyDaemon implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < Integer.MAX_VALUE; i++)
		{
			System.out.println("后台线程第" + i + "次执行!");
			try {
				Thread.currentThread().sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class DeamonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new MyCommon();
		Thread t2 = new Thread(new MyDaemon());
		
		t2.setDaemon(true);
		t2.start();
		t1.start();
	}

}

/*
 * 
 * 在启动之前设置 setDaemon(true) 后台运行
 */
