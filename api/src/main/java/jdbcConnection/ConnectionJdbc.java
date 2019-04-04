package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJdbc {
	
	final static String CLASS_NAME = "com.mysql.jdbc.Driver";
	private static String DriverUrl = "jdbc:mysql://localhost:3306/pop_app_database";

	private static String userID = "root";

	private static String dbPassword = "";

	private static Connection con = null;

	private ConnectionJdbc() {
	}

	public static Connection getConnection() {
		System.out.println("In getConnection");
		System.out.println(con);
			try {
			System.out.println("In getConnection in try");
			if (con == null || con.isClosed()) {
				System.out.println("In getConnection con == null");
				try {
					System.out.println("In getConnection try");
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(DriverUrl, userID, dbPassword);
					System.out.print("Database is connected !");
					System.out.println("IPv4 Address............: 192.168.1.108...lan,  192.168.1.19...wifi , new IP- 192.168.1.164...");
				} catch (ClassNotFoundException e) {
					System.out.println("In getConnection inner catch");
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			System.out.println("In getConnection outer catch");
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void closeConnection(Connection con) throws SQLException {
		System.out.println("In closeConnection");
		try{
			System.out.println("In closeConnection in try");
			if (con != null) {
				System.out.println("In closeConnection con is not null");
				con.close();
				System.out.println(con);
			}
		}
		catch(Exception ex)
		{
			System.out.println("In closeConnection in catch");
			ex.printStackTrace();
		}
	}
}
