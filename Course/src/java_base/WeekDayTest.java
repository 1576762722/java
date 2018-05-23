package java_base;

import java.util.EnumSet;

enum WeekDay
{
	Mon("Monday", "星期一"),
	Tue("Tuesday", "星期二"),
	Wed("Wednesday", "星期三"),
	Thu("Thursday", "星期四"),
	Fri("Frisday", "星期五"),
	Sat("Satursday", "星期六"),
	Sun("Sunday", "星期日");
	
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
