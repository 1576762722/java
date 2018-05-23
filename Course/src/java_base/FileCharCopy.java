package java_base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCharCopy {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("src\\java_base\\FileCharCopy.java");
		FileWriter fw = new FileWriter("d:\\FileCharCopy.java");
		
		char[] ca = new char[1024];
		while(fr.read(ca) != -1)
		{
			fw.write(ca, 0, ca.length-1);
		}
		fw.close();
		fr.close();
	}
}

/**
 * 使用字符流进行复制文件  FileReader  FileWriter
 */	
