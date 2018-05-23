package java_base;

public class LeftRight {
	boolean flag = false;    //false ����   ture ����
	class Left extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i = 0; i < 50; i++)
				synchronized (LeftRight.class) {
					while(flag)
					{
						try {
							LeftRight.class.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.printf("%30s\n", "���һ��");
					flag = true;
					LeftRight.class.notify();
				}
		}
	}
	
	class Right extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i = 0; i < 50; i++)
				synchronized (LeftRight.class) {
					
					while(!flag)
					{
						try {
							LeftRight.class.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.printf("%30s\n", "�ҽ�һ��");
					flag = false;
					LeftRight.class.notify();
				}
		}
	}
	public static void main(String[] args) {
		// TODO Auto -generated method stub
		LeftRight lf = new LeftRight();
		lf.new Left();
		lf.new Right();
	}
}
