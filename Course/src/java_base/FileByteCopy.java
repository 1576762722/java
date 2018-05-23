package java_base;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileByteCopy {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("src\\java_base\\FileByteCopy.java");
		FileOutputStream fos = new FileOutputStream("d://FileByteCopy.java");
		
		System.out.println("文件大小: " + fis.available());
		
		byte[] ba = new byte[1024];
		while(fis.read(ba) != -1)
		{
			fos.write(ba, 0, ba.length-1);
		}
		
		fis.close();
		fos.close(); 
	}

}
/*
 * 文件字符流 FileRead  文件字节流 FileInputStream   
 */
