package java_base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception{
		Properties props = new Properties();
		props.setProperty("dept", "计算机学院");
		props.setProperty("username", "hdczyj");
		props.setProperty("password", "123456");
		
		FileOutputStream fos = new FileOutputStream("a.ini");
		props.store(fos, "注释行");
		System.out.println(props);
		fos.close();
		
		Properties props2 = new Properties();
		props2.setProperty("gender", "male");
		props2.setProperty("dept", "Handan College");
		
		FileInputStream fis = new FileInputStream("a.ini");
		props2.load(fis);
		System.out.println(props.get("dept"));
		FileOutputStream fos1 = new FileOutputStream("a.ini");
//		System.out.println("\u6559\u52A1\u5904");
//		System.out.println("\u6559\u52A1\u5904");
		props2.store(fos1, "\u6559\u52A1\u5904");
		System.out.println(props2);
	}
}

/*
 *  key 是唯一的，value 会被取代
 */