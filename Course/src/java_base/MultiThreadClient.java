package java_base;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiThreadClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1", 8000);
		PrintStream ps = new PrintStream(socket.getOutputStream());
		Scanner sc1 = new Scanner(socket.getInputStream());
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("�������ַ���(Exit �˳�)��");
			String s = sc.nextLine();
			ps.println(s);
			ps.flush();
			String s1 = sc1.nextLine();
			System.out.println("�յ�������:" + s1);
			if("exit".equalsIgnoreCase(s))
			{
				break;
			}
		}
	}

}
