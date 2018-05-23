package java_base;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class ServerSocketTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(8080);
		while(true) {
			Socket socket = ss.accept();
			
			String sip = socket.getLocalAddress().toString();
			int sport = socket.getLocalPort();
			
			SocketAddress cip = socket.getRemoteSocketAddress();
			int cport  = socket.getPort();
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println("同志们好!");
			Scanner sc = new Scanner(socket.getInputStream());
			System.out.println("客户端" + cip + ":" + cport + "说" + sc.nextLine());
		}
	}

}
