package ServerPicturess;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;





/**
 * @author ming
 * 
 */
public class ClientPicture1 {

	
	private JFrame frmClient;
	private JTextField textField = new JTextField();
	JButton button_1 = new JButton("发送");
	JButton button1 = new JButton("");
	static JButton button2 = new JButton("");
	private static File file;
	private JFileChooser fc = new JFileChooser("C:\\Users\\ming\\Desktop");
	static ServerSocket ss;
	static boolean isopen = true;
	byte buffer[] = new byte[1024];
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ClientPicture1 window = new ClientPicture1();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window.frmClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//创建文件夹，把接收到的文件保存在这里
		File dir = new File("D:\\upload");
		if(!dir.exists())
		{
					dir.mkdir();
		}
				
		System.out.println("客户端程序启动...");
		while(true) {
			window.receive("127.0.0.1", 8888);
		}
	}

	/**
	 * Create the application.
	 */
	public ClientPicture1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.setTitle("Client");
		frmClient.setBounds(100, 100, 642, 428);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("路径：");
		lblNewLabel.setBounds(43, 47, 72, 18);
		frmClient.getContentPane().add(lblNewLabel);
		
		JLabel Label1 = new JLabel("客户端选择的要发送的图片");
		Label1.setBounds(70, 85, 226, 27);
		frmClient.getContentPane().add(Label1);
		
		JLabel Label2 = new JLabel("接收到服务器端发送的图片");
		Label2.setBounds(380, 85, 226, 27);
		frmClient.getContentPane().add(Label2);
		
		
		textField.setEditable(false);
		textField.setBounds(102, 44, 226, 24);
		frmClient.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("选择图片");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equals("选择图片")) {
					int returanVal = fc.showOpenDialog(null);
					if(returanVal == JFileChooser.APPROVE_OPTION) {
						file = fc.getSelectedFile();
						textField.setText(file.toString());
						Icon icon = new ImageIcon(file.toString());
						button1.setIcon(icon);
					}
				}
			}
		});
		button.setBounds(358, 43, 113, 27);
		frmClient.getContentPane().add(button);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				send("127.0.0.1", 8080, file);
			}
			
		});
		
		
		button_1.setBounds(483, 43, 113, 27);
		frmClient.getContentPane().add(button_1);
		
		
		button1.setBounds(43, 122, 226, 223);
		frmClient.getContentPane().add(button1);
		
		
		button2.setBounds(358, 122, 216, 223);
		frmClient.getContentPane().add(button2);
	}
	

	
	/**
	 * @param str_ip 字符串类型的ip
	 * @param port  端口 
	 * @param file1   要发送的文件
	 */
	public void send(String str_ip, int port, File file1)
	{
		try { 
			//字符串转化成ip地址
			InetAddress ip = InetAddress.getByName(str_ip);
			//获取文件
            File file = new File(file1.toString());  
            try {  
                // 将文件名发送过去  
                String str_filename = file.getName();  
                String str_tip = "有文件，请处理：" + str_filename; 
                /*
                 * 先把数据转化成字节
                 * Datagrampacker 第一个参数是数据 第二个参数是数据长度 第三个数据是ip 第四个数据是端口
                 */
                byte[] fileNameBuf = str_tip.getBytes();           
                DatagramSocket socket = new DatagramSocket();  
                DatagramPacket packet = new DatagramPacket(fileNameBuf, fileNameBuf.length, ip, port);  
                socket.send(packet);  
                socket.close(); 
                
                
                FileInputStream fis = new FileInputStream(file);// 从文件中取出写入内存  
                
                // 将文件长度发送过去  
                int fileLen = fis.available();  
                String str_len = "" + fileLen;  
                byte[] fileLenBuf = str_len.getBytes();  
                socket = new DatagramSocket();  
                packet = new DatagramPacket(fileLenBuf,  fileLenBuf.length, ip, port + 1);  
                socket.send(packet);  
                socket.close();  
                // 发送文件主体  
                byte[] buf = new byte[1024];  
                int numofBlock = fileLen / buf.length;// 循环次数（将该文件分成了多少块）  
                int lastSize = fileLen % buf.length;// 最后一点点零头的字节数  
                socket = new DatagramSocket();  
                for (int i = 0; i < numofBlock; i++) {  
                    fis.read(buf, 0, buf.length);// 写入内存  
                    packet = new DatagramPacket(buf, buf.length, ip, port + 1);  
                    socket.send(packet);  
                    Thread.sleep(1); // 简单的防止丢包现象  
                }  
                // 发送最后一点点零头  
                fis.read(buf, 0, lastSize);  
                packet = new DatagramPacket(buf, buf.length, ip, port + 1);  
                socket.send(packet);  
                Thread.sleep(1); // 简单的防止丢包现象  
                //  
                fis.close();  
                socket.close();  
                //  
               System.out.println("文件传输完毕！");  
                //  
            } catch (Exception ev) {  
                System.out.println(ev);  
            }  
        } catch (Exception ex) { 
        	ex.printStackTrace();
        }  
    }
	
	
	/**
	 * @param str_ip 是字符串类型的ip
	 * @param port 端口   
	 */
	public void receive(String str_ip, int port)
	{
		try {  
            InetAddress ip = InetAddress.getByName(str_ip);  
            DatagramSocket socket = new DatagramSocket(port);  
            DatagramSocket socket1 = new DatagramSocket(port + 1);  
            while (socket!=null) {  
                try {  
                    //  
                    byte filetipBuf[] = new byte[256];// 防止文件名字过长
                    DatagramPacket packet_tip = new DatagramPacket(filetipBuf,  
                            0, filetipBuf.length);  
                    socket.receive(packet_tip);  
                    String str_filetip = new String(packet_tip.getData(), 0,  
                            packet_tip.getLength());  
                    String filename = str_filetip.substring(8);
                    System.out.println("filename :" + filename);
                    
                    // 接收文件长度（字节数）  
                    byte[] fileLenBuf = new byte[12];// 可以传输1T的文件  
                    DatagramPacket packet_len = new DatagramPacket(fileLenBuf,fileLenBuf.length);  
                    socket1.receive(packet_len);  
                    String str_fileLen = new String(fileLenBuf, 0,  
                            packet_len.getLength());  
                    int fileLen = Integer.parseInt(str_fileLen);  
                    System.out.println("文件大小： " + fileLen + "字节, " + (fileLen / 1024)  
                            + "kb, " + (fileLen / 1024 / 1024) + "Mb\n"); 
                    
                    
                    //DatagramPacket packet_file = new DatagramPacket(buffer, 0, buffer.length);  
                    DatagramPacket packet_file;  
                    int numofBlock = fileLen / buffer.length;// 循环次数（将该文件分成了多少块） 
                    int lastSize = fileLen % buffer.length;// 最后一点点零头的字节数  
                    File file = new File("D:\\upload\\" + filename);  
                    FileOutputStream fos = new FileOutputStream(file);// 从内存取出存入文件  
                    for (int i = 0; i < numofBlock; i++) {  
                        packet_file = new DatagramPacket(buffer, 0, buffer.length);
                        socket1.receive(packet_file);// 通过套接字接收数据  
                        fos.write(buffer, 0, 1024);// 写入文件  
                    }
                    // 接收最后一点点零头  
                    packet_file = new DatagramPacket(buffer, 0, lastSize);  
                    socket1.receive(packet_file);// 通过套接字接收数据  
                    fos.write(buffer, 0, lastSize);// 写入文件  
                    fos.close();
                    System.out.println("接收完毕");
                    
                    Icon icon = new ImageIcon(file.toString());
        			button2.setIcon(icon);
                    // 反馈包  
                } catch (Exception e) {  
                    e.printStackTrace();
                }  
            }  
        } catch (Exception e) {  
           e.printStackTrace();
        }  
    }  

}
