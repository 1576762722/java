package java_base;

import javax.swing.JOptionPane;

/**
 * @author ming
 *�������ֶԻ���
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
 * �Ի������뷵�ص����ַ���  ��Ҫʹ�� integer.parseint() ת��
 */
