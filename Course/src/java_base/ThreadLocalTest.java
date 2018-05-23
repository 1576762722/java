package java_base;

class Cal extends Thread{
	public ThreadLocal<Integer> sum = new ThreadLocal<Integer>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		sum.set(0);
		for(int i = 1; i <= 100; i++)
		{
			sum.set(sum.get() + i);
		}
		System.out.println(getName() + ":" + sum.get() );
	}
	
}
public class ThreadLocalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cal().start();
		new Cal().start();
		new Cal().start();
	}

}


/*
 *   ThreadLocal  作用是把对象变量设置为线程独享，相当于线程拥有自己的资源空间 
 */
