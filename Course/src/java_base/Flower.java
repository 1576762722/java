package java_base;


/**
 * @author ming
 * ���100~999֮�������ˮ�ɻ���
 * ���磺153 = 1^3 + 5^3 + 3^3  ����153��ˮ�ɻ���
 */

public class Flower {

	/**
	 * @param args
	 * ����100~999         i
	 * 	       ��ȡ�� �� ʮ�� ��λ      n1, n2, n3
	 *      �����ж�                       i == math.pow(n1,3) +  math.pow(n2,3) + math.pow(n3,3)
	 *          ��� i
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 100; i <= 999; i++)
		{
			int n1 = i % 10;
			int n2 = (i/10) % 10;
			int n3 = i / 100;
			if(i == Math.pow(n1, 3) + Math.pow(n2, 3) + Math.pow(n3, 3)) {
				System.out.println(i+"\t");
			}
			
		}
	}

}
