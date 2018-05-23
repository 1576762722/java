package java_base;

class Alpha extends Thread{
	public void run(){
		char ch = ' ';
		try {
			for(int i = 0; i < 100; i++)
			{
				ch = (char)('A' + (int)(Math.random() * 26));
				System.out.printf("%20c\n", ch);
				sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Digit implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		char ch = ' ';
		try {
			for(int i = 0; i < 50; i++)
			{
				ch = (char)('0' + (int)(Math.random() * 10));
				System.out.printf("%-20c\n", ch);
				Thread.sleep(6000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ThreadRunnableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alpha t1 = new Alpha();
		t1.start();
		Digit d = new Digit();
		Thread t2 = new Thread(d);
		t2.start();
	}

}
/*
 * ʹ�ü̳еĽ����� ����֮�����ʹ��
 * ʹ��ʵ�ֽӿڵĽ�����  ����֮����Ҫ�����߳�ʵ��  ����ʹ��
 */
