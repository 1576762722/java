package java_base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

public class LoginTest {

	private JFrame frame;
	private JTextField Account;
	private JTextField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTest window = new LoginTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		springLayout.putConstraint(SpringLayout.NORTH, label, 102, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 111, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 38, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.SOUTH, label_1, -77, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_1, 0, SpringLayout.EAST, label);
		frame.getContentPane().add(label_1);
		
		Account = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Account, 0, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, Account, 22, SpringLayout.EAST, label);
		frame.getContentPane().add(Account);
		Account.setColumns(10);
		
		Password = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Password, 0, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.EAST, Password, 0, SpringLayout.EAST, Account);
		Password.setColumns(10);
		frame.getContentPane().add(Password);
		
		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = Account.getText();		
				String password = Password.getText();
				if(account.equals("ming") && password.equals("ming"))
				{
					System.out.println("µÇÂ½³É¹¦");
				}
				else
				{
					System.out.println("µÇÂ½Ê§°Ü");
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button, 19, SpringLayout.SOUTH, Password);
		springLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, Account);
		frame.getContentPane().add(button);
	}
}
