package mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class mysql implements ActionListener{

	private JFrame frame;
	private JTextField areatextField;
	private JTextField fruittextField;
	private JTextField numtextField;
	private JTable table;
	PreparedStatement psmt;
	Connection conn;
	Statement stmt;
	ResultSet result;
	Vector data = new Vector();
	Vector<Object> v = new Vector();
	Vector names = new Vector();
	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		// TODO Auto-generated method stub
		mysql window = new mysql();
		//String url = "jdbc:MySQL://120.79.227.149:3306/Fruit";
		String url = "jdbc:MySQL://127.0.0.1/Fruit?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
		window.conn = DriverManager.getConnection(url, "xian", "xian");
		window.stmt = window.conn.createStatement();
				
				

//				stmt.executeUpdate("update account set area='佛山' where area='肇庆'");
//				stmt.executeUpdate("delete from account where area='阳江'");
		window.selectall();
//				stmt.close();
//				conn.close();
			

	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public mysql() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 818, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("地区");
		label.setBounds(29, 34, 72, 18);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("水果");
		label_1.setBounds(139, 34, 72, 18);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("数量");
		label_2.setBounds(264, 34, 72, 18);
		frame.getContentPane().add(label_2);
		
		areatextField = new JTextField();
		areatextField.setBounds(15, 65, 86, 24);
		frame.getContentPane().add(areatextField);
		areatextField.setColumns(10);
		
		fruittextField = new JTextField();
		fruittextField.setBounds(125, 65, 86, 24);
		frame.getContentPane().add(fruittextField);
		fruittextField.setColumns(10);
		
		numtextField = new JTextField();
		numtextField.setBounds(237, 65, 86, 24);
		frame.getContentPane().add(numtextField);
		numtextField.setColumns(10);
		
		JButton add = new JButton("增加");
		add.addActionListener(this);
		add.setBounds(384, 64, 113, 27);
		frame.getContentPane().add(add);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 197, 360, 191);
		frame.getContentPane().add(scrollPane);
		
		Vector names = new Vector();
		names.add("地区");
		names.add("水果");
		names.add("数量");
		table = new JTable(new DefaultTableModel(data, names));
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//			},
//			new String[] {
//				"\u5730\u533A", "\u6C34\u679C", "\u6570\u91CF"
//			}
//		));
		scrollPane.setViewportView(table);
		
		JButton delete = new JButton("删除");
		delete.addActionListener(this);
		delete.setBounds(553, 201, 113, 27);
		frame.getContentPane().add(delete);
		
		JButton update = new JButton("修改");
		update.addActionListener(this);
		update.setBounds(553, 64, 113, 27);
		frame.getContentPane().add(update);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		String cmd = arg0.getActionCommand();
		if(cmd.equals("增加")) {

			String areatext = areatextField.getText();
			String fruittext = fruittextField.getText();
			String numtext = numtextField.getText();
			System.out.println(areatext + fruittext + numtext);
			int num = Integer.parseInt(numtext);
			try {
				PreparedStatement psmt = conn.prepareStatement("insert into account values(?, ?, ?);");
				psmt.setString(1, areatext);
				psmt.setString(2, fruittext);
				psmt.setInt(3, num);
				psmt.addBatch();
				int[] i = psmt.executeBatch();
				
				selectall();
				table.updateUI();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(cmd.equals("删除"))
		{
			int index = table.getSelectedRow();
			String area = data.get(index).toString().substring(1, 3);
			String fruit = data.get(index).toString().substring(5, 7);
			int num = Integer.parseInt(data.get(index).toString().substring(9, 11));
			try {
				PreparedStatement psmt = conn.prepareStatement("delete from account where area = ? and fruit = ? and num = ?");
				psmt.setString(1, area);
				psmt.setString(2, fruit);
				psmt.setInt(3, num);
				psmt.addBatch();
				int[] i = psmt.executeBatch();
				selectall();
				table.updateUI();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(cmd.equals("修改"))
		{
			int index = table.getSelectedRow();
			String area = data.get(index).toString().substring(1, 3);
			String fruit = data.get(index).toString().substring(5, 7);
			int num = Integer.parseInt(data.get(index).toString().substring(9, 11));
			
			areatextField.setText(area);
			areatextField.setEnabled(false);
			fruittextField.setText(fruit);
			numtextField.setText(Integer.toString(num));
		}
	}
	
	public void selectall() throws SQLException
	{
		result = stmt.executeQuery("select * from account");
		data.clear();
		while(result.next())
		{
			//System.out.printf("%s,%s,%d\n",result.getString(1),result.getString(2),result.getInt(3));
			v.clear();
			v.add(result.getObject(1));
			v.add(result.getObject(2));
			v.add(result.getObject(3));
			data.add(v.clone());
		}
	}
}
