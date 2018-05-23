package java_base;

import java.util.EnumSet;

enum WeekDay
{
	Mon("Monday", "����һ"),
	Tue("Tuesday", "���ڶ�"),
	Wed("Wednesday", "������"),
	Thu("Thursday", "������"),
	Fri("Frisday", "������"),
	Sat("Satursday", "������"),
	Sun("Sunday", "������");
	
	private final String en;
	private final String cn;
	
	private WeekDay(String en, String cn) {
		// TODO Auto-generated constructor stub
		this.en = en;
		this.cn = cn;
	}
	
	public String getCn() {
		return cn;
	}
	
	public String getEn() {
		return en;
	}
	
}
public class WeekDayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeekDay s1 = WeekDay.Fri;
		
		System.out.println(WeekDay.Tue.getCn());
		System.out.println(s1 + ":" + s1.getCn());
		
		for(WeekDay s:WeekDay.values())
		{
			System.out.println(s1 + ":" + s1.getCn());
		}
		
		for(WeekDay s: EnumSet.range(WeekDay.Tue, WeekDay.Sat))
		{
			System.out.println(s1 + "-" + s1.getEn());
		}
	}

}
