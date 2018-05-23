package java_base;

class MyCommon extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++)
		{
			System.out.println("ǰ̨�̵߳�" + i + "��ִ��!");
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
			System.out.println("��̨�̵߳�" + i + "��ִ��!");
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
 * ������֮ǰ���� setDaemon(true) ��̨����
 */
