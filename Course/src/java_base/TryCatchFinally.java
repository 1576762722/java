package java_base;

public class TryCatchFinally {
	
	public static void proc(int mode) {
		// TODO Auto-generated method stub
		try {
			if(mode == 0) {
				System.out.println("nothing");
			}
			else {
				int j = 4/0;
				System.out.println("no exec");
			}
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("ArithmeticException");
		}catch(Exception e) {
			System.out.println("Exception");
		}finally {
			System.out.println("finally");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		proc(0);
		proc(1);
	}
}

/*
*  java �쳣���� try catch finally
*  ��Ҫ�����Լ���֪����ʲôʱ���ʹ���쳣
*
*/