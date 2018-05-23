package java_base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableThread implements Callable<Integer>{
	private int begin;
	private int end;
	public CallableThread(int begin, int end) {
		// TODO Auto-generated constructor stub
		this.begin = begin;
		this.end = end;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = begin; i<=end; i++)
		{
			sum = sum + i;
		}
		return sum;
	}
}
public class CallabledAndFutureTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> ft1 = es.submit(new CallableThread(1, 100));
		Future<Integer> ft2 = es.submit(new CallableThread(101, 200));
		System.out.println("1~200 整数的和:" + (ft1.get() + ft2.get()));
		es.shutdown();
	}

}
