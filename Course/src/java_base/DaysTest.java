package java_base;

import java.util.Scanner;

/**
 * @author ming
 * ����switch ������ݺ��·�������µ�����
 * 1��3��5��7��8��10��12 �� 31��
 * 4��6��9��11 ��10��
 * ����2����29��  ƽ����28��
 * ���꣺�ܱ�4�������ܱ�100���� ���� �ܱ�400����
 */
public class DaysTest {

	/**
	 * @param args
	 * ������year  month
	 * switch month
	 * 	1��3��5��7��8��10��12    31��
	 * 	4��6��9��11              30��
	 * 	2                       �ж��Ƿ�����((year%4 == 0 && year%100 != 0)||year%400 == 0) 29��
	 * 																		else 28��
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
