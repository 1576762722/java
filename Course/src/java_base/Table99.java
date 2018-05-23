package java_base;

/**
 * @author ming
 *输出九九乘法表
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
 * 在末尾添加制表符 就相当于tab 能自动对其  而不知添加tab对应的空格
 * 使用printf 效果更好  特别是 使用 %d * %d = %2d
 */
