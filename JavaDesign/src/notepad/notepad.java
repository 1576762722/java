package notepad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.undo.UndoManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog.ModalityType;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class notepad implements ActionListener, DocumentListener{

	private JFrame frame = new JFrame();
	private JScrollPane scrollPane = new JScrollPane();
	private JTextArea textArea = new JTextArea();
	private JMenu filemenu = new JMenu("文件");
	private JMenuItem f_new = new JMenuItem("新建");
	private JMenuItem f_open = new JMenuItem("打开");
	private JMenuItem f_save = new JMenuItem("保存");
	private JMenuItem f_saveas = new JMenuItem("另存为");
	private JMenuItem f_exit = new JMenuItem("退出");
	private JMenu editmenu = new JMenu("编辑");
	private JMenuItem e_undo = new JMenuItem("撤销");
	private JMenuItem e_redo = new JMenuItem("重做");
	private JMenuItem e_copy = new JMenuItem("复制");
	private JMenuItem e_cut = new JMenuItem("剪切");
	private JMenuItem e_paste = new JMenuItem("粘贴");
	private JMenuItem e_selectall = new JMenuItem("全选");
	private JMenuItem e_find = new JMenuItem("查找");
	private JMenuItem e_replace = new JMenuItem("替换");
	private JMenuItem e_jump = new JMenuItem("转到");
	private JMenu format = new JMenu("格式");
	private JMenuItem f_font = new JMenuItem("字体...");
	private JMenuItem f_color = new JMenuItem("颜色...");
	private JMenu view = new JMenu("查看");
	private JMenu help = new JMenu("帮助");
	private JMenuItem h_help = new JMenuItem("帮助主题");
	private JMenuItem h_about = new JMenuItem("关于我的记事本");
	private JFileChooser fc = new JFileChooser("C:\\Users\\ming\\Desktop");
	private File file;
	private boolean saveflag = true;
	private UndoManager undoManager = new UndoManager(); 
	private Clipboard clipboard;
	private findJDialog fj;
	private replaceJDialog rj;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notepad window = new notepad();
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
	public notepad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setBounds(100, 100, 946, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);                //居中
		
		scrollPane.setBounds(0, 0, 928, 544);
		frame.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
		menuBar.add(filemenu);
		
		
		filemenu.add(f_new);
		
		
		filemenu.add(f_open);
		
		
		filemenu.add(f_save);
		
		
		filemenu.add(f_saveas);
		
		filemenu.insertSeparator(4);               //分隔线
		
		filemenu.add(f_exit);
		
		
		menuBar.add(editmenu);
		
		
		editmenu.add(e_undo);
		
		
		editmenu.add(e_redo);
		
		
		editmenu.add(e_copy);
		
		
		editmenu.add(e_cut);
		
		
		editmenu.add(e_paste);
		
		
		editmenu.add(e_selectall);
		
		
		editmenu.add(e_find);
		
		
		editmenu.add(e_replace);
		
		
		editmenu.add(e_jump);
		
		
		menuBar.add(format);
		
		JCheckBoxMenuItem f_wordwrap = new JCheckBoxMenuItem("自动换行");
		format.add(f_wordwrap);
		
		
		format.add(f_font);
		
		
		format.add(f_color);
		
		
		menuBar.add(view);
		
		
		menuBar.add(help);
		
		
		help.add(h_help);
		
		
		help.add(h_about);
		
		f_save.setEnabled(false);
		f_saveas.setEnabled(false);
		
		clipboard = frame.getToolkit().getSystemClipboard();
		
		h_about.addActionListener(this);
		f_open.addActionListener(this);
		f_save.addActionListener(this);
		f_new.addActionListener(this);
		f_saveas.addActionListener(this);
		f_exit.addActionListener(this);
		textArea.getDocument().addDocumentListener(this);
		textArea.getDocument().addUndoableEditListener(undoManager);
		e_undo.addActionListener(this);
		e_redo.addActionListener(this);
		e_copy.addActionListener(this);
		e_paste.addActionListener(this);
		e_cut.addActionListener(this);
		e_selectall.addActionListener(this);
		e_find.addActionListener(this);
		e_replace.addActionListener(this);
		e_jump.addActionListener(this);
		e_undo.setAccelerator(KeyStroke.getKeyStroke('Z',InputEvent.CTRL_MASK));
		e_redo.setAccelerator(KeyStroke.getKeyStroke('Y',InputEvent.CTRL_MASK));
		e_copy.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_MASK));
		e_cut.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_MASK));
		e_paste.setAccelerator(KeyStroke.getKeyStroke('V',InputEvent.CTRL_MASK));
		e_selectall.setAccelerator(KeyStroke.getKeyStroke('A',InputEvent.CTRL_MASK));
		e_find.setAccelerator(KeyStroke.getKeyStroke('F',InputEvent.CTRL_MASK));
		e_replace.setAccelerator(KeyStroke.getKeyStroke('H',InputEvent.CTRL_MASK));
		e_jump.setAccelerator(KeyStroke.getKeyStroke('J',InputEvent.CTRL_MASK));
		f_new.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		f_open.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK));
		f_save.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK));
		f_saveas.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK, true));
		f_exit.setAccelerator(KeyStroke.getKeyStroke('D', InputEvent.CTRL_MASK));
		textArea.setText("");
		file = null;
		textArea.setVisible(true);
		f_save.setEnabled(true);
		f_saveas.setEnabled(true);
		textArea.grabFocus(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if("新建".equals(cmd)) {
			textArea.setText("");
			file = null;
			textArea.setVisible(true);
			f_save.setEnabled(true);
			f_saveas.setEnabled(true);
			textArea.grabFocus(); 
		}
		
		if("关于我的记事本".equals(cmd)) {
			JOptionPane.showMessageDialog(null, "菜单测试", "关于", 0);
		}
		if("打开".equals(cmd)){
			int returanVal = fc.showOpenDialog(null);
			if(returanVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				try {
					textArea.setVisible(true);
					textArea.setText("");
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					String s;
					try {
						while((s = br.readLine()) != null) {
							textArea.append(s);
							textArea.append("\n");
						}
						br.close();
						fr.close();
						f_save.setEnabled(true);
						f_saveas.setEnabled(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "文件读取出错", "错误", 0);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "文件打开出错", "错误", 0);
				} 
			}
			
			    //获取光标
		}
		
		if("保存".equals(cmd)) {
			
			if(file == null)
			{
				int flag = fc.showSaveDialog(null);
			    if (flag == JFileChooser.APPROVE_OPTION) {
			    	file = fc.getSelectedFile();
			    }
			    System.out.println("ctrl sdfsf");
			}
			try {
				String s = textArea.getText();
				FileWriter fw = new FileWriter(file);
				try {
					fw.write(s);
					fw.flush();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "文件写入出错", "错误", 0);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "文件保存出错", "错误", 0);
			} 
			saveflag = true;
		}
		
		if("另存为".equals(cmd)) {
			file = null;
			if(file == null)
			{
				int flag = fc.showSaveDialog(null);
			    if (flag == JFileChooser.APPROVE_OPTION) {
			    	file = fc.getSelectedFile();
			    }
			}
			try {
				String s = textArea.getText();
				FileWriter fw = new FileWriter(file);
				try {
					fw.write(s);
					fw.flush();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "文件写入出错", "错误", 0);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "文件保存出错", "错误", 0);
			} 
			saveflag = true;
		}
		
		if("退出".equals(cmd)) {
			if(saveflag == false)
			{
				int n = JOptionPane.showConfirmDialog(null, "你要保存吗");
				if(n == 0) {
					try {
						String s = textArea.getText();
						FileWriter fw = new FileWriter(file);
						try {
							fw.write(s);
							fw.flush();
							fw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "文件写入出错", "错误", 0);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "文件保存出错", "错误", 0);
						}
					
				}
			}
			System.exit(0);
		}
		
		if("撤销".equals(cmd)) {
			if (undoManager.canUndo()) {  
                undoManager.undo();  
            }  
		}
		
		if("重做".equals(cmd)) {
			 if (undoManager.canRedo()) {  
	                undoManager.redo();  
	            }  
		}
		
		if("剪切".equals(cmd)) {
			String tempText = textArea.getSelectedText();
        	StringSelection editText = 
        	new StringSelection(tempText);
        	clipboard.setContents(editText,null);
        	int start= textArea.getSelectionStart();
        	int end  = textArea.getSelectionEnd(); 
        	textArea.replaceRange("",start,end) ;
		}
		
		if("复制".equals(cmd)) {
			String tempText = textArea.getSelectedText();
       	 	StringSelection editText = new StringSelection(tempText);
       	 	clipboard.setContents(editText,null);
		}
		
		if("粘贴".equals(cmd)) {
			Transferable contents = clipboard.getContents(this);
            DataFlavor  flavor= DataFlavor.stringFlavor;
            if( contents.isDataFlavorSupported(flavor)){
            	try
            	{  
            		String str;
            		str = (String)contents.getTransferData(flavor);
            		textArea.append(str);
            	}catch(Exception ex)
            	{
            		ex.printStackTrace();
            	}
            }
		}
		
		if("全选".equals(cmd)) {
			textArea.selectAll();
		}
		
		if("查找".equals(cmd)) {
			
			/*
			 * 判断查找窗口是否打开
			 * 如果已经打开了就没有必要再创建一个类了
			 */
			if(fj.getisopen() == false)
			{
				fj = new findJDialog(textArea);
				fj.setVisible(true);
				fj.setLocationRelativeTo(null);
			}
			
		}
		
		if("替换".equals(cmd)) {
			
			/*
			 * 判断查找窗口是否打开
			 * 如果已经打开了就没有必要再创建一个类了
			 */
			if(rj.getisopen() == false)
			{
				rj = new replaceJDialog();
				rj.setVisible(true);
				rj.setLocationRelativeTo(null);
			}
			
		}
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if(saveflag)
		{
			saveflag = false;
		}
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if(saveflag)
		{
			saveflag = false;
		}
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if(saveflag)
		{
			saveflag = false;
		}
	}
	
	
	
	

}
