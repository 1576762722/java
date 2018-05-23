package java_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparsedStatementTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:MySQL://120.79.227.149:3306/RHS";
		Connection conn = DriverManager.getConnection(url, "ming", "ming");
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery("select curtain_statu from app_user");
		while(result.next())
		{
			System.out.println(result.getInt(1));
		}
		stmt.close();
		conn.close();
	}

}
