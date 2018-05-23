package java_base;

/**
 * @author ming
 *冒泡法
 *历遍 ((1+ list.length)*(length/2*))次
 *	判断 list[i] > list[i+1]  那么互换位置(空的先装)
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
		
		
		System.out.println("原始顺序:");
		for(int i:ia) {
			System.out.println(i+"\t");
		}
		
		
		bubble(ia);
		
		
		System.out.println("排序后顺序:");
		for(int i:ia) {
			System.out.println(i+"\t");
		}
		
		
	}
}
