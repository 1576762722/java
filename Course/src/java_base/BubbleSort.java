package java_base;

/**
 * @author ming
 *ð�ݷ�
 *���� ((1+ list.length)*(length/2*))��
 *	�ж� list[i] > list[i+1]  ��ô����λ��(�յ���װ)
 */
public class BubbleSort {

	public static void bubble(int a[])
	{
		int temp;
		for(int i=0; i < a.length; i++)
			for(int j = 0; j < a.length - i - 1; j++)
				if(a[j] > a[j+1])
				{
					temp = a[j] ;
					a[j] = a[j+1];
					a[j+1] =temp;
				}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ia[] = {55, 6, 4, 32, 12, -9, 73, 122, 26, 1};
		
		
		System.out.println("ԭʼ˳��:");
		for(int i:ia) {
			System.out.println(i+"\t");
		}
		
		
		bubble(ia);
		
		
		System.out.println("�����˳��:");
		for(int i:ia) {
			System.out.println(i+"\t");
		}
		
		
	}
}
