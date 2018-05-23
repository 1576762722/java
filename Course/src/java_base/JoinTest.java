package java_base;

class T extends Thread{
	Thread t;
	
	public T(String name, Thread t) {
		// TODO Auto-generated constructor stub
		setName(name);
		this.t = t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			if(t != null)
			{
				t.join();
			}
			System.out.println(getName() + "start");
			Thread.sleep(1000);
			System.out.println(getName() + "end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
public class JoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T p3 = new T("C", null);
		T p2 = new T("B", p3);
		T p1 = new T("A", p2);
		p1.start();
		p2.start();
		p3.start();
		
			
	}

}
