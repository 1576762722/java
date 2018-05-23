package java_base;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultiThreadServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket s = new ServerSocket(8000);
			System.out.println("�����Ѿ�����");
			while(true) {
				Socket socket = s.accept();
				String addr = socket.getInetAddress() + ":" + socket.getPort();
				System.out.println("�ͻ�" + addr + "����!");
				new ServerReaderThread(socket, addr).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

class ServerReaderThread extends Thread{
	Socket socket;
	String addr;
	public ServerReaderThread(Socket socket, String addr2) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.addr = addr2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(socket.getInputStream());
			PrintStream ps = new PrintStream(socket.getOutputStream());
			while(true) {
				String str = sc.nextLine();
				System.out.println(addr + "˵��" + str);
				ps.println(str);
				ps.flush();
				if("exit".equalsIgnoreCase(str)) {
					break;
				}
			}
		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
	}
}
