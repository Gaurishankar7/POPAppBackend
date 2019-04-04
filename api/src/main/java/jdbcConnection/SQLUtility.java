package jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * 
 * Utility class for generic SQL query execution.
 *
 */
public class SQLUtility {
	
	 static Logger logger = Logger.getLogger(SQLUtility.class);

	private static ResultSet rs = null;
	private static PreparedStatement pstmt = null;
	private static int count =0;
	/**
	 * This utility method provides the functionality to execute statement multiple
	 * parameters.
	 * 
	 * @param query
	 * @param params
	 * @param con
	 * @param
	 * @return result set
	 */



public static PreparedStatement getPreparedStatement(String query, Connection con) {
	try {
		pstmt = con.prepareStatement(query);
		System.out.println("in pstmt get prepared statement");

	} catch (SQLException sq) {
		System.out.println("in catch prepared staement method");
		sq.printStackTrace();
	}
	return pstmt;

}

public static int  executeUpdatePreparedQuery(PreparedStatement pstmt, Connection con)
{
	
	try {
		System.out.println("in try of excuet update preapared statement");
		 count =  pstmt.executeUpdate();
		System.out.println(count+"excuete upadte.....");

		}
	 catch (SQLException sq) {
		 System.out.println("in catch of excueteUpdatePreparedQuery......insert....update");
	
		sq.printStackTrace();
	}
	return count;
}
public static ResultSet executePreparedQuery(PreparedStatement pstmt, Connection con)
{
	try {
		 System.out.println("in try of excuete PreparedQuery......select");
		rs = pstmt.executeQuery();
		System.out.println(rs+"resultset");

		}
	 catch (SQLException sq) {
		 System.out.println("in catch of excuetePreparedQuery......select");
		System.out.println("in excuete query");
		sq.printStackTrace();
	}
	return rs;
}
}