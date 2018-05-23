package java_base;

import java.util.Random;

public class RandomSeedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd1 = new Random();
		for(int i = 0; i <= 5; i++)
		{
			System.out.print(rd1.nextInt(100) + "\t");
		}
		System.out.println();
		for(int i = 0; i <= 5; i++)
		{
			System.out.print(rd1.nextInt(100) + "\t");
		}
		System.out.println();
		
		Random rd2 = new Random(10);
		for(int i = 0; i <= 5; i++)
		{
			System.out.print(rd2.nextInt(100) + "\t");
		}
		System.out.println();
		
		Random rd3 = new Random(10);
		for(int i = 0; i <= 5; i++)
		{
			System.out.print(rd3.nextInt(100) + "\t");
		}
		System.out.println();
	}

}

/*
 *random()  默认是时间种子  其中rd2.nextInt(100) 	随机数在0-100范围 
 */

