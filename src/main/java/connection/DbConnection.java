package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	
public static Connection getDbConnection() throws SQLException,ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=null;		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodordersystem","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	

}
