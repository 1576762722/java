package java_base;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1", 8080);
		InputStream is = socket.getInputStream();
		Scanner sc = new Scanner(is);
		String s = sc.nextLine();
		System.out.println("服务器端说:" + s);
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("首长好！");
		ps.flush();
		ps.close();
		
	}

}
