package java_base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferFileCopy {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("src\\java_base\\BufferFileCopy.java");
		FileWriter fw = new FileWriter("d:\\BufferFileCopy.java");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String s;
		while((s = br.readLine()) != null)
		{
			System.out.println(s);
			bw.write(s);
			bw.newLine();
		}
		
		bw.flush();
		fr.close();
		fw.close();
		br.close();
		bw.close();
	}

}


/*
* BuffereReader 的读取方式是不一样的  通过返回值，而不是通过指针
* 写完后需要flush
* readLine() 会忽略换行，所以写的时候需要bw.newLine();
* 
* 文件流 可以使用 字符流 字节流   还可以加上带缓冲利用BufferedReader..
*/