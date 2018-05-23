package addressbook;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class UI implements ActionListener, MouseListener, ListSelectionListener, FocusListener{

	private JFrame frame;
	private JTextField name;
	private JTextField note;
	private JTextField birth;
	private JTextField email;
	private JTextField phone;
	JButton newbutton = new JButton("新建");
	JButton updatebutton = new JButton("修改");
	JButton savebutton = new JButton("保存");
	JButton deletebutton = new JButton("删除");
	JButton exitbutton = new JButton("退出");
	JLabel namelabel = new JLabel("姓名不能为空，不能重复，必须唯一");
	JLabel datelabel = new JLabel("日期格式：xxxx-xx-xx");
	JLabel emaillabel = new JLabel("邮件格式：xxxx@xxxx.xxx");
	
	Hashtable<String, Person> ht;
	Vector<String> listData = new Vector<String>();
//	private JList jList;
	private JList jList = new JList<String>(listData);
	boolean updateflag = false;
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args){
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.ht = new Hashtable<String, Person>();
					
					try {
						FileInputStream fi = new FileInputStream("D:\\address.ini");
						ObjectInputStream si = new ObjectInputStream(fi);
						window.ht = (Hashtable)si.readObject();
						window.listData = (Vector)si.readObject();
						fi.close();
						si.close();
					} catch (Exception e) {
						// TODO: handle exception
						File f = new File("D:\\address.ini");
						f.createNewFile();
					}
					
					window.jList.setListData(window.listData);
					window.jList.setSelectedIndex(0);
					
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the application.
	 * @param jList 
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param jList 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("通讯录");
		frame.setBounds(100, 100, 941, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 923, 217);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("个人信息");
		label.setBounds(93, 13, 72, 18);
		panel.add(label);
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setBounds(93, 44, 72, 18);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("出生日期");
		label_2.setBounds(93, 81, 72, 18);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("电子邮件");
		label_3.setBounds(93, 149, 72, 18);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("备注");
		label_4.setBounds(93, 186, 72, 18);
		panel.add(label_4);
		
		name = new JTextField();
		name.setBounds(179, 41, 140, 24);
		panel.add(name);
		name.setColumns(10);
		
		note = new JTextField();
		note.setColumns(10);
		note.setBounds(179, 183, 140, 24);
		panel.add(note);
		
		birth = new JTextField();
		birth.setColumns(10);
		birth.setBounds(179, 78, 140, 24);
		panel.add(birth);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(179, 146, 140, 24);
		panel.add(email);
		
		JLabel label_5 = new JLabel("手机");
		label_5.setBounds(93, 118, 72, 18);
		panel.add(label_5);
		
		phone = new JTextField();
		phone.setBounds(179, 109, 140, 24);
		panel.add(phone);
		phone.setColumns(10);
		
		
		namelabel.setBounds(378, 44, 251, 18);
		namelabel.setVisible(false);
		panel.add(namelabel);
		
		
		datelabel.setBounds(378, 81, 175, 18);
		datelabel.setVisible(false);
		panel.add(datelabel);
		
		
		emaillabel.setBounds(378, 149, 218, 18);
		emaillabel.setVisible(false);
		panel.add(emaillabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 244, 673, 223);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(jList);
		
		
		
		newbutton.setBounds(718, 241, 113, 27);
		
		
		
		savebutton.setBounds(718, 344, 113, 27);
		savebutton.setEnabled(false);
		frame.getContentPane().add(savebutton);
		
		
		
		deletebutton.setBounds(718, 396, 113, 27);
		frame.getContentPane().add(deletebutton);
		
		
		
		exitbutton.setBounds(718, 442, 113, 27);
		frame.getContentPane().add(exitbutton);
		frame.getContentPane().add(newbutton);
		

		
		updatebutton.setBounds(718, 295, 113, 27);
		frame.getContentPane().add(updatebutton);
		
		mode0();
		
		newbutton.addActionListener(this);
		updatebutton.addActionListener(this);
		savebutton.addActionListener(this);
		jList.addMouseListener(this); 
		deletebutton.addActionListener(this);
		exitbutton.addActionListener(this);
		name.addFocusListener(this);
		birth.addFocusListener(this);
		email.addFocusListener(this);
}
	
	private void mode0()
	{
		newbutton.setEnabled(true);
		deletebutton.setEnabled(true);
		updatebutton.setEnabled(true);
		savebutton.setEnabled(false);
		exitbutton.setEnabled(false);
		
		name.setEditable(false);
		birth.setEditable(false);
		phone.setEditable(false);
		email.setEditable(false);
		note.setEditable(false);
		
	}
	
	private void mode1()
	{
		newbutton.setEnabled(false);
		deletebutton.setEnabled(false);
		updatebutton.setEnabled(false);
		savebutton.setEnabled(true);
		exitbutton.setEnabled(true);
		
		name.setEditable(true);
		birth.setEditable(true);
		phone.setEditable(true);
		email.setEditable(true);
		note.setEditable(true);
		name.setText(null);
		birth.setText(null);
		phone.setText(null);
		email.setText(null);
		note.setText(null);
	}
	
	private void mode2()
	{
		newbutton.setEnabled(false);
		deletebutton.setEnabled(false);
		updatebutton.setEnabled(false);
		savebutton.setEnabled(true);
		exitbutton.setEnabled(true);
		
		name.setEditable(false);
		birth.setEditable(true);
		phone.setEditable(true);
		email.setEditable(true);
		note.setEditable(true);
		name.setText(null);
		birth.setText(null);
		phone.setText(null);
		email.setText(null);
		note.setText(null);
	}
	
	private boolean verify()
	{
		
		return true;
	}
	
	
	
	public void setInfo(Person p)
	{
		name.setText(p.getName());
		birth.setText(p.getBirthday());
		phone.setText(p.getPhone());
		email.setText(p.getEmail());
		note.setText(p.getNote());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == newbutton) {
			mode1();

		}
		
		if(e.getSource() == savebutton) {
			
			Person person = new Person(name.getText(),birth.getText(), phone.getText(), email.getText(), note.getText());
			if(verify(person))
			{
				if(updateflag == false)
				{
					listData.insertElementAt(person.getName(), 0);
					jList.setSelectedIndex(0);
				}
				
				jList.setListData(listData);
				ht.put(person.getName(), person);
				save();
				mode0();
				
				if(updateflag)
				{
					updateflag = false;
				}
			}
			
		}
		
		if(e.getSource() == updatebutton) {
			try {
				mode2();
				String str = (String)jList.getSelectedValue();
				setInfo(ht.get(str));
				updateflag = true;
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "请选择姓名", "错误", 0);
				mode0();
			}
			
		}
		
		if(e.getSource() == deletebutton) {
			try {
				String str = (String)jList.getSelectedValue();
				listData.remove(str);
				ht.remove(ht.get(str));
				jList.setListData(listData);
				save();
				clearAll();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "请选择姓名", "错误", 0);
			}
			
		}
		
		if(e.getSource() == exitbutton) {
			
			mode0();
			String str = (String)jList.getSelectedValue();	
			setInfo(ht.get(str));
		}
		
		
	}
	
	private void save() {
		FileOutputStream fo;
		try {
			fo = new FileOutputStream("D:\\address.ini");
			ObjectOutputStream so = new ObjectOutputStream(fo);
			so.writeObject(ht);
			so.writeObject(listData);
			so.flush();
			so.close();
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void load() {
		
		try {
			FileInputStream fi = new FileInputStream("D:\\address.ini");
			ObjectInputStream si = new ObjectInputStream(fi);
			ht = (Hashtable)si.readObject();
			listData = (Vector)si.readObject();
			fi.close();
			si.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount() == 1)
		{
			String str = (String)jList.getSelectedValue();	
			setInfo(ht.get(str));
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void clearAll()
	{
		name.setText("");
		birth.setText("");
		phone.setText("");
		email.setText("");
		note.setText("");
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == name) {
			namelabel.setVisible(true);
		}
		
		if(e.getSource() == birth) {
			datelabel.setVisible(true);
		}
		
		if(e.getSource() == email) {
			emaillabel.setVisible(true);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == name) {
			namelabel.setVisible(false);
		}
		
		if(e.getSource() == birth) {
			datelabel.setVisible(false);
		}
		
		if(e.getSource() == email) {
			emaillabel.setVisible(false);
		}
	}
	
	private boolean verify(Person person) {
		if(ht.get(person.getName()) != null && updateflag == false)
		{
			JOptionPane.showMessageDialog(null, "用户名重复", "错误", 0);
			return false;
		}else if(person.getBirthday().matches("^[0-9][0-9][0-9][0-9][-][0-9][0-9][-][0-9][0-9]$") == false)
		{
			JOptionPane.showMessageDialog(null, "日期", "错误", 0);
			return false;
		}else if(person.getPhone().matches("^1[3|4|5|7|8][0-9]\\d{8}$") == false) {
			JOptionPane.showMessageDialog(null, "电话号码", "错误", 0);
			return false;
		}else if(person.getEmail().matches("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$") == false) {
			JOptionPane.showMessageDialog(null, "邮件", "错误", 0);
			return false;
		}else {
			return true;
		}
	}
}
