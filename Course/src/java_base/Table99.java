package java_base;

/**
 * @author ming
 *����žų˷���
 */
public class Table99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i =1; i<=9; i++)
		{
			for(int j =1; j<=9; j++)
			{
//				System.out.print(i + "*" + j + "=" + i*j + "\t");
				System.out.printf("%d * %d = %2d\t", i,j,i*j);
			}
			System.out.println();
		}
	}

}

/*
 * 
 * ��ĩβ����Ʊ�� ���൱��tab ���Զ�����  ����֪���tab��Ӧ�Ŀո�
 * ʹ��printf Ч������  �ر��� ʹ�� %d * %d = %2d
 */
