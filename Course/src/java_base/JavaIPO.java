package java_base;

import java.util.Scanner;

public class JavaIPO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请依次输入一个整数、一个小数和一个字符串，中间用空格分开:");
		int n = sc.nextInt();
		double d = sc.nextDouble();
		String str = sc.nextLine();
		System.out.println("[n = " + n + ", d = " + d + ", str = " + str + "]");
		System.out.printf("[n = %d, d = %f, str = %s]", n, d, str); 
	}

}

/*
 * 今天我感受到写Java是这么轻松的，因为有alt + / 快捷键
 * 这个实验我知道了 println 与 printf 的区别
 * 在 println 没有转义  可以直接输出
 * 在printf   需要转义
 */

