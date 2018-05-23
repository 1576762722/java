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
* BuffereReader �Ķ�ȡ��ʽ�ǲ�һ����  ͨ������ֵ��������ͨ��ָ��
* д�����Ҫflush
* readLine() ����Ի��У�����д��ʱ����Ҫbw.newLine();
* 
* �ļ��� ����ʹ�� �ַ��� �ֽ���   �����Լ��ϴ���������BufferedReader..
*/