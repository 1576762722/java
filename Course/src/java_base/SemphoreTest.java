package java_base;

import java.util.concurrent.Semaphore;

import javax.swing.border.EmptyBorder;

class Client extends Thread{
	private Semaphore semaphore;
	public Client(String name, Semaphore semaphore) {
		// TODO Auto-generated constructor stub
		setName(name);
		this.semaphore = semaphore;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(getName() + "�˿��Ŷ���...");
		try {
			semaphore.acquire();
			System.out.println(getName() + "���������� ...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(getName() + "�˿��뿪.");
		semaphore.release();
	}
}
public class SemphoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore semaphore = new Semaphore(2);
		Client p1 = new Client("A", semaphore);
		Client p2 = new Client("B", semaphore);
		Client p3 = new Client("C", semaphore);
		p1.start();
		p2.start();
		p3.start();
		
	}

}


/*
*   �������֤ Semaphore semaphore = new Semaphore(2);
*   ���� private Semaphore semaphore;
*   ��run����������� semaphore.acquire();  ���û���õ����֤�Ļ�����൱��wait
*   �黻���֤ semaphore.release();
*/