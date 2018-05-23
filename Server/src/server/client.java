package server;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class client {

	private JFrame frame;
	private JTextField textField;
	private File file;
	private JFileChooser fc = new JFileChooser("C:\\Users\\ming\\Desktop");
	private ImageIcon icon = new ImageIcon();
	private Image image;
	Socket socket;
	JButton btnNewButton_1 = new JButton("");

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		client window = new client();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Socket socket = new Socket("127.0.0.1", 8888);
		
//		while(true)
//		{
//			window.readfile();
//		}
	}
	
	

	/**
	 * Create the application.
	 */
	public client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("客户端端程序");
		frame.setBounds(100, 100, 674, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("路径：");
		label.setBounds(53, 80, 45, 18);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(112, 77, 238, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("选择图片");
		
		
		
		button.setBounds(364, 76, 113, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("发送");
		
		button_1.setBounds(497, 76, 113, 27);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("客户端选择的发送的图片");
		label_1.setBounds(53, 149, 207, 18);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("接受到服务端发送的图片");
		label_2.setBounds(364, 149, 207, 18);
		frame.getContentPane().add(label_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(53, 194, 252, 217);
		frame.getContentPane().add(btnNewButton);
		
		
		btnNewButton_1.setBounds(364, 194, 246, 217);
		frame.getContentPane().add(btnNewButton_1);
		
		/*
		 * 监听选择图片
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returanVal = fc.showOpenDialog(null);
				if(returanVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					textField.setText(file.toString());
					image = Toolkit.getDefaultToolkit().getImage(file.toString());
					icon.setImage(image);
					btnNewButton.setIcon(icon);
				}
			}
		});
		
		/*
		 * 发送图片
		 */
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					send(file.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public void send(String file) throws IOException
	{
		
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(file.replaceAll("\\","\\\\"));
		byte[] ba = new byte[1024];
		int len = 0;
		while((len = fis.read(ba)) != -1) {
			os.write(ba);
		}
		socket.shutdownInput();
//		socket.close();
	}
	public void readfile() {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String name = "D:\\upload\\" + sdf.format(new Date()) + ".png";
			FileOutputStream fos = new FileOutputStream(name);
			InputStream is = socket.getInputStream();
			int len = 0;
			byte[] ba = new byte[1024];
			while((len = is.read(ba)) != -1) {
				fos.write(ba, 0, len);
			}
			fos.close();
			image = Toolkit.getDefaultToolkit().getImage(name);
			icon.setImage(image);
			btnNewButton_1.setIcon(icon);
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}