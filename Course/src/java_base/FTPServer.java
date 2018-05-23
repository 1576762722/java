package java_base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FTPServer {

	static {
		File f = new File("D:\\upload");
		if(!f.exists())
		{
			f.mkdir();
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("服务器端程序启动...");
		ServerSocket ss = new ServerSocket(8888);
		while(true) {
			Socket socket = ss.accept();
			new ReadFileThread(socket).start();
		}
	}

}

class ReadFileThread extends Thread{
	Socket socket;
	
	public ReadFileThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String name = "D:\\upload\\" + sdf.format(new Date()) + ".txt";
			FileOutputStream fos = new FileOutputStream(name);
			InputStream is = socket.getInputStream();
			int len = 0;
			byte[] ba = new byte[1024];
			while((len = is.read(ba)) != -1) {
				fos.write(ba, 0, len);
			}
			
//			PrintStream ps = new PrintStream(socket.getOutputStream());
//			ps.println("上传成功!");
//			ps.flush();
//			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
