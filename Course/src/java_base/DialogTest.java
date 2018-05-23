package java_base;

import javax.swing.JOptionPane;

/**
 * @author ming
 *感受三种对话框
 */
public class DialogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "hello");
		int n = JOptionPane.showConfirmDialog(null, "Are you sure?");
		if(n ==0 )
		{
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		String str = JOptionPane.showInputDialog("int");
	}
}
/*
 * 对话框输入返回的是字符串  需要使用 integer.parseint() 转换
 */
