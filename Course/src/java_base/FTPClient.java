package java_base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FTPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1", 8888);
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream("D:\\2.txt");
		byte[] ba = new byte[1024];
		int len = 0;
		while((len = fis.read(ba)) != -1) {
			os.write(ba);
		}
		socket.shutdownInput();
//		Scanner sc = new Scanner(socket.getInputStream());
//		String msg = sc.nextLine();
//		System.out.println(msg);
		socket.close();
	}

}
