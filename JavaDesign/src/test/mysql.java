package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//String url = "jdbc:MySQL://120.79.227.149:3306/Fruit";
		String url = "jdbc:MySQL://127.0.0.1/Fruit?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
		Connection conn = DriverManager.getConnection(url, "xian", "xian");
		Statement stmt = conn.createStatement();
		ResultSet result;
		
//		PreparedStatement psmt = conn.prepareStatement("insert into account values(?, ?, ?);");
//		
//		psmt.setString(1, "阳江");
//		psmt.setString(2, "梨子");
//		psmt.setInt(3, 200);
//		psmt.addBatch();
//		int[] i = psmt.executeBatch();
		stmt.executeUpdate("update account set area='佛山' where area='肇庆'");
		stmt.executeUpdate("delete from account where area='阳江'");
		result = stmt.executeQuery("select * from account");
		while(result.next())
		{
			System.out.printf("%s,%s,%d\n",result.getString(1),result.getString(2),result.getInt(3));
		}
		stmt.close();
		conn.close();
	}

}
