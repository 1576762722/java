package notepad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class findJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Highlighter highlighter;
	private  HighlightPainter painter_yellow = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
	private  HighlightPainter painter_orange = new DefaultHighlighter.DefaultHighlightPainter(Color.orange);
	int n;
	int position;
	static boolean isopen = false;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			findJDialog dialog = new findJDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	/*
	 * 设置静态方法   判断是否打开
	 */
	public static boolean getisopen()
	{
		return isopen;
	}
	/**
	 * Create the dialog.
	 */
	public findJDialog(JTextArea textArea) {
		setTitle("查找");
		// 设置一直在前面
		isopen = true;
		setAlwaysOnTop(true);
		setBounds(100, 100, 705, 339);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("查找内容");
		label.setBounds(57, 63, 72, 18);
		contentPanel.add(label);
		
		textField = new JTextField();
		textField.setBounds(168, 57, 384, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JCheckBox checkword = 	new JCheckBox("区分大小写");
		checkword.setBounds(64, 168, 133, 27);
		contentPanel.add(checkword);
		
		JRadioButton up = new JRadioButton("向上");
		buttonGroup.add(up);
		up.setBounds(345, 168, 59, 27);
		contentPanel.add(up);
		
		JRadioButton down = new JRadioButton("向下");
		down.setSelected(true);
		buttonGroup.add(down);
		down.setBounds(413, 168, 72, 27);
		contentPanel.add(down);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String s = textArea.getText();
						String str = textField.getText();
						highlighter = textArea.getHighlighter();
						highlighter.removeAllHighlights();
						
						
						/*
						 * 判断是否忽略大小写；
						 * 如果忽略大小写的话，把匹配和被匹配的字符全变成小写
						 * 否在不变
						 */
						if(checkword.isSelected() == false) {
							s = s.toLowerCase();
							str = str.toLowerCase();
						}
						
						
						/*
						 * 获取指针，找到下一个匹配字符，定位到此处并标橙色
						 * 具体做法是：判断是否存在匹配的字符   如果存在 就判断是否向上查找还是向上查找 
						 * 其中我加上了循环查找
						 */
						
						position = textArea.getCaretPosition();
						if(s.indexOf(str) == -1) {
							setAlwaysOnTop(false);
							JOptionPane.showMessageDialog(null, "没有找到匹配的字符", "查找", 0);
							setAlwaysOnTop(true);
							
						}else {
							if(down.isSelected()) {
								position = s.indexOf(str, position);
								if(position == -1)position = s.indexOf(str);
								System.out.println("index" + position);
								textArea.setCaretPosition(position+str.length());
								try {
									highlighter.addHighlight(position, position+str.length(), painter_orange);
								} catch (BadLocationException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else {
								position = s.lastIndexOf(str, position - str.length());
								if(position == -1) {
									position = s.lastIndexOf(str, s.length());
									System.out.println("找不到的" + position);
								}
								System.out.println("last = " + position);
								textArea.setCaretPosition(position);
								try {
									highlighter.addHighlight(position, position+str.length(), painter_orange);
								} catch (BadLocationException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						
						
						/*
						 * 把其他匹配的字符标成黄色
						 */
						n = s.indexOf(str);
						while(n != -1) {
							try {
								if(n != position)
								{
									highlighter.addHighlight(n, n+str.length(), painter_yellow);
								}
							} catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							n = s.indexOf(str, n+str.length());
						}
							
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						isopen = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
		}
		
		/*
		 * 检测是否关闭查找窗口，如果是把isopen标志 改为false
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				isopen = false;
			}
		});
	}
	
	
}
