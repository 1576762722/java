package java_base;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RandomAccessFile raf = new RandomAccessFile("d:\\test.txt", "rw");
		raf.writeDouble(3.14);
		System.out.println(raf.getFilePointer());
		raf.writeBoolean(false);
		System.out.println(raf.getFilePointer());
		raf.writeChar('A');
		System.out.println(raf.getFilePointer());
		raf.seek(8);
		System.out.println(raf.readBoolean());
	}

}

/*
 * RandomAccessFile ����ֱ�ӽ��ж�д  �ʺϼ�¼���ݣ��Ͷ�ȡ����  �����ֽ�ģʽд�� ���Դ��ļ��ǿ�����дʲô��
 * Ҳ������double 8�ֽ� char ˫�ֽ� Boolean ���ֽ�
 */
