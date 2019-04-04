package com.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jdbcConnection.ConnectionJdbc;
import jdbcConnection.JDBCHelper;
import jdbcConnection.SQLUtility;

public class ServiceUserDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs= null ;

	public Map<String, String> checkServiceUser(String userName, String password, String deviceToken) {
		Map<String, String> map = new HashMap<>();

		try {

			con = ConnectionJdbc.getConnection();
			String selectQuery = JDBCHelper.selectUserAndPaassword;
			System.out.println(selectQuery);

			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);                                     

			pstmt.setString(1, userName);
			pstmt.setString(2, password);

			rs = SQLUtility.executePreparedQuery(pstmt, con);

			if (rs.next()) {
				map.put("userId", Integer.toString(rs.getInt(1)));
				map.put("restaurantId", Integer.toString(rs.getInt(2)));
				pstmt = null;
				String updateQuery = JDBCHelper.updateServiceUserDeviceToken;
				System.out.println(updateQuery);
				
				pstmt = SQLUtility.getPreparedStatement(updateQuery, con);
				pstmt.setString(1, deviceToken);
				pstmt.setInt(2,rs.getInt(1));
				SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			} else {
				map.put("loginFail", "user not exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return map;

	}

}
