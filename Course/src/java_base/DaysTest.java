package java_base;

import java.util.Scanner;

/**
 * @author ming
 * 利用switch 根据年份和月份输出该月的天数
 * 1，3，5，7，8，10，12 月 31天
 * 4，6，9，11 月10天
 * 闰年2月有29天  平年有28天
 * 闰年：能被4整出不能被100整除 或者 能被400整除
 */
public class DaysTest {

	/**
	 * @param args
	 * 先设置year  month
	 * switch month
	 * 	1，3，5，7，8，10，12    31天
	 * 	4，6，9，11              30天
	 * 	2                       判断是否闰年((year%4 == 0 && year%100 != 0)||year%400 == 0) 29天
	 * 																		else 28天
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int month = sc.nextInt();
		int days = 0;
		switch(month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if((year%4 == 0 && year%100 != 0)||year%400 == 0) {
				days = 29;
			}
			else days = 28;
			break;
		}
		System.out.println(days);
	}

}
