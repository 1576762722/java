package addressbook;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
	
	private String name;
	private String birthday;
	private String phone;
	private String email;
	private String note;
	
	
	public Person(String name, String birthday, String phone, String email, String note) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.note = note;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:" + name + "phone:" + phone;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getPhone() {
		return phone;
	}
	
	

}
