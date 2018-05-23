package java_base;

import java.util.Calendar;
import java.util.Date;

public class DataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ms2 = System.currentTimeMillis();
		Date date1 = new Date();
		System.out.println(date1);
		System.out.println(date1.toString());
		long ms1 = new Date().getTime();
		
		long ms3 = Calendar.getInstance().getTimeInMillis();
		System.out.println("ms1 = " + ms1 + "ms");
		System.out.println("ms2 = " + ms2 + "ms");

		Date date2 = new Date();
		System.out.println(date2.compareTo(date1));
		System.out.println(date2.equals(date1));
	}
}


/*
*System.currentTimeMillis() - System.currentTimeMillis()  用来获取时间差
*/