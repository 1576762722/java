package java_base;

class MyException extends Exception{
	private int idnumber;
	
	public MyException(String message, int id)
	{
		super(message);
		this.idnumber = id;
	}
	public int getIdnumber() {
		return idnumber;
	}
}
public class ThrowTest {
	
	private void regist(int num) throws MyException {
		// TODO Auto-generated method stub
		if(num < 0) {
			throw new MyException("�˹��׳��쳣", 3);
		}
		System.out.println("�Ǽ�������" + num);
	}
	
	private void manager() {
		// TODO Auto-generated method stub
		try {
			regist(2);
		} catch (MyException e) {
			// TODO: handle exception
			System.out.println("�Ǽǳ���"+e.getIdnumber());
		}finally {
			System.out.println("over");
		}
	}
	
	public static void main(String[] args) {
		ThrowTest t = new ThrowTest();
		t.manager();
	}
}

/*
* ��һ��ʵ���� ����쳣
* ��һ�����Զ����׳��쳣  �ڷ������� thows �쳣��   �ڷ������� thow  �쳣��
* �������һ���� �����e����
* �Զ����쳣��  �и�String message ��Ҫ������
*/