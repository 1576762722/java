package java_base;

public class RunTimeTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Runtime rt = Runtime.getRuntime();
		rt.exec("notepad.exe");
		System.out.println("maxMemory:" + rt.maxMemory() + "B");
		System.out.println("totalMemory:" + rt.totalMemory() + "B");
		System.out.println("freeMemory:" + rt.freeMemory() + "B");
		

	}

}
