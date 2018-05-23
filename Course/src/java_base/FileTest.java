package java_base;

import java.io.File;

public class FileTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File f = new File("src\\java_base\\FileTest.java");
		System.out.println("f.exists() = " + f.exists());
		System.out.println("f.isDirectory() = " + f.isDirectory() );
		System.err.println("f.length() = " + f.length());
		System.out.println("f.getName() = " + f.getName(  ));
		System.out.println("f.getParent() = " + f.getParent());
		System.out.println("f.getPath() = " + f.getPath());
		
//		File f1 = new File("d:\\hb\\hd\\hdc");
//		f1.mkdirs();
//		
//		File f2 = new File("d:\\onefile");
//		f2.mkdir();
		
		File f4 = new File("d:c\\a.txt");
		File f3 = new File("d:\\b.txt");
		File f5 = new File("d:\\new.txt");
		
		
		f5.createNewFile();
		f3.renameTo(f4);
		
	}

}


/*
* File 是文件指针
* 能进行创建文件，创建目录，重命名等操作
*/