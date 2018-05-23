package java_base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("����");
	}
}
public class TimerTest{


	public static void main(String[] args)throws Exception {
		
//		String datetime = "2018-04-26 14:33:00";
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		
//		Date date = sdf.parse(datetime);
//		
//		System.out.println(date);
		System.out.println("hello");
		Timer timer = new Timer();
//		timer.schedule(new MyTask(), 1000, 2000);
		String datetime = "2018-05-09 17:45:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = sdf.parse(datetime);
		timer.schedule(new MyTask(), date);
		Thread.sleep(50000);
		timer.cancel();
	}
}



/*
*   дһ����ʱ����  ��дrun����  class MyTask extends TimerTask
*   ����һ����ʱ��ʵ��   new Timer
*   ��ʼ���ö�ʱ���� ����һֱִ�г��� timer.cancel()�� timer.schedule(xxxx)
*   
*   
*   �߳���ʱ   Thread.sleep(50000)  ms  ��ʱ50s
*
*/