package java_base;


/**
 * @author ming
 * 输出100~999之间的所有水仙花数
 * 例如：153 = 1^3 + 5^3 + 3^3  所以153是水仙花数
 */

public class Flower {

	/**
	 * @param args
	 * 历遍100~999         i
	 * 	       获取个 ， 十， 百位      n1, n2, n3
	 *      进行判断                       i == math.pow(n1,3) +  math.pow(n2,3) + math.pow(n3,3)
	 *          输出 i
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
