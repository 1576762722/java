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
			throw new MyException("人工抛出异常", 3);
		}
		System.out.println("登记人数：" + num);
	}
	
	private void manager() {
		// TODO Auto-generated method stub
		try {
			regist(2);
		} catch (MyException e) {
			// TODO: handle exception
			System.out.println("登记出错"+e.getIdnumber());
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
* 上一次实验室 检测异常
* 这一次是自定义抛出异常  在方法隔壁 thows 异常类   在方法里面 thow  异常类
* 捕获的是一个类 存放在e里面
* 自定义异常类  有个String message 需要传进来
*/