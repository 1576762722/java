package java_base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i =1; i <= 10; i++)
		{
			final int task = i;
			pool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j = 1; j <= 10; j++)
					{
						System.out.println("ִ�е�" + task + "������ĵ�" + j + "��ѭ��");
					}
				}
			});
		}
		pool.shutdown();
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("ÿ�����뱬ըһ��");
			}
		}, 10, 2, TimeUnit.SECONDS);
	}

}
