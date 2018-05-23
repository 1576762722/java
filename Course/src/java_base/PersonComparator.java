package java_base;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

class Person {
	private String name;
	private Date birthDate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Person(String name, Date birthDate) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + name + "," + sdf.format(birthDate) + "]";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}

public class PersonComparator implements Comparator<Person>{

	Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Person s1 = new Person("张三", sdf.parse("1984-3-1"));
		Person s2 = new Person("李四", sdf.parse("1984-2-1"));
		Person s3 = new Person("王五", sdf.parse("1984-8-1"));
		Person s4 = new Person("郑六", sdf.parse("1985-1-1"));
		Person s5 = new Person("张三", sdf.parse("1982-1-1"));
		
		TreeSet<Person> ts = new TreeSet<Person>(new PersonComparator());
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		ts.add(s5);
		System.out.println(ts);
		}
		
		@Override
		public int compare(Person o1, Person o2)
		{
			if(cmp.compare(o1.getName(), o2.getName()) == 0)
			{
				return o1.getBirthDate().compareTo(o2.getBirthDate());
			}
			else
			{
				return cmp.compare(o1.getName(), o2.getName());
			}
	}

}

/*
 * 日期与字符串转化  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  字符转日期 sdf.parse()  日期转字符 sdf.format()
 * TreeSet<Person> ts = new TreeSet<Person>(new PersonComparator());  拥有自动排序功能   public int compare()
 * */
