package Linkcode.bank.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myconnection {
	private final static String driver="oracle.jdbc.OracleDriver";
	private final static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private final static String userName="System";
	private final static String password="9146459019";
	static Connection con;
	public static Connection myconnection(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection: "+con);
		return con;
	}
}