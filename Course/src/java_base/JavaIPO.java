package java_base;

import java.util.Scanner;

public class JavaIPO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("����������һ��������һ��С����һ���ַ������м��ÿո�ֿ�:");
		int n = sc.nextInt();
		double d = sc.nextDouble();
		String str = sc.nextLine();
		System.out.println("[n = " + n + ", d = " + d + ", str = " + str + "]");
		System.out.printf("[n = %d, d = %f, str = %s]", n, d, str); 
	}

}

/*
 * �����Ҹ��ܵ�дJava����ô���ɵģ���Ϊ��alt + / ��ݼ�
 * ���ʵ����֪���� println �� printf ������
 * �� println û��ת��  ����ֱ�����
 * ��printf   ��Ҫת��
 */

