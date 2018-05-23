package java_base;

public class MainThreadTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		for(int i =0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().toString());
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getPriority());
			Thread.currentThread().sleep(2000);
		}
	}

}
