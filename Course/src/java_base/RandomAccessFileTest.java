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
 * RandomAccessFile 可以直接进行读写  适合记录数据，和读取数据  是以字节模式写入 所以打开文件是看不懂写什么的
 * 也明白了double 8字节 char 双字节 Boolean 单字节
 */
