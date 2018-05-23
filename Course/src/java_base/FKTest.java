package java_base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class FKTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		// TODO Auto-generated method stub
		ForkJoinPool fjp = new ForkJoinPool();
		Future<Long> result = fjp.submit(new NTTask(1, 100000000));
		System.out.println(result.get());
	}
}

class NTTask extends RecursiveTask<Long>{
	public static final int THREADHOLD = 10000;	
	private int begin;
	private int end;
	public NTTask(int begin, int end) {
		// TODO Auto-generated constructor stub
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		// TODO Auto-generated method stub
		long sum = 0;
		if((end - begin) <= 1000) {
			for(int i = begin; i <= end; i++)
			{
				sum = sum + i;
			}
		}else {
			int mid = begin + (end - begin)/2;
			NTTask left = new NTTask(begin, mid);
			left.fork();
			NTTask right = new NTTask(mid, end);
			right.fork();
			long l = left.join();
			long r = right.join();
			return l + r;
		}
		return sum;
	}
}
