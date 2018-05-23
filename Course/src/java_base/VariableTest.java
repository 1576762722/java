package java_base;

public class VariableTest {

	static final double PI = 3.14159;
	int score = 100;
	double facorial(int n) {
		double fac = 1;
		for(int i = 1; i <= n; i++)
		{
			fac = fac * i;
		}
		return fac;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(VariableTest.PI);
		VariableTest vd = new VariableTest();
		System.out.println(vd.score);
		System.out.println(vd.facorial(10));
		System.out.println(java.lang.Math.abs(-100));
		System.out.println(Math.abs(-100));
		
	}

}
