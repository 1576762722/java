package java_base;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FileOutputStream fos = new FileOutputStream("d:\\test.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeByte((byte)123);
		dos.writeShort((short)123);
		dos.writeInt(1234567890);
		dos.writeLong(998877665544332211L);
		dos.writeFloat(2.7182f);
		dos.writeDouble(3.141592654);
		dos.writeChar('J');
		dos.writeBoolean(true);
		dos.writeUTF("邯郸");
		
		
		FileInputStream fis = new FileInputStream("d:\\test.txt");
		DataInputStream dis = new DataInputStream(fis);
		System.out.println(dis.readByte());
		System.out.println(dis.readShort());
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
		System.out.println(dis.readFloat());
		System.out.println(dis.readDouble());
		System.out.println(dis.readChar());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readUTF());
		
	}

}

/*
 *  把字节流转化到数据流
 *  写的数据和读的数据类型要一一对应
 */
