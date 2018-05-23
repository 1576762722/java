package java_base;

import java.util.Arrays;

/**
 * @author ming
 *演示Java一维数组的基本技巧
 */
public class ArrayTest {
	public static void main(String[] args) {
		int[] ia = null;
		ia = new int[3];
		int[] ib = new int[3];
		ia[0] = 1;
		ia[1] = 2;
		ia[2] = 3;
		System.out.println(ia.length);
		double[] da = {3.14, 2.738, 3.45};
		for(double i:da)
		{
			System.out.println(i);
		}
		for(int i = 0; i< da.length; i++)
		{
			System.out.println(da[i]);
		}
		System.out.println(Arrays.toString(da));
	}
}

/*
 * Arrays.toString() 把数组化成字符
 */