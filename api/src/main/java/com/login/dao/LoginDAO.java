package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.login.model.LoginBean;

import jdbcConnection.ConnectionJdbc;
import jdbcConnection.JDBCHelper;
import jdbcConnection.SQLUtility;

public class LoginDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	LoginBean login;

	public Map<String, String> loginCredentials(LoginBean logBean) throws SQLException {
		
		try {

			con = ConnectionJdbc.getConnection();
			String insertQuery = JDBCHelper.insertLoginCredentials;
			pstmt = SQLUtility.getPreparedStatement(insertQuery, con);
			pstmt.setString(1,logBean.getUserEmailId());
			pstmt.setString(2, logBean.getDeviceToken());
			pstmt.setString(3,logBean.getUserName());
			pstmt.setString(4, logBean.getUserRole());
			pstmt.setString(5, logBean.getLoginStatus());
			SQLUtility.executeUpdatePreparedQuery(pstmt, con);
		
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			ConnectionJdbc.closeConnection(con);
		}
		return selectUserId(logBean.getUserEmailId(), logBean.getDeviceToken());
	}

	public Map<String, String> selectUserId(String userEmailId, String deviceToken) {
		Map<String, String> map = new HashMap<>();
		try {

			con = ConnectionJdbc.getConnection();
			String selectQuery = JDBCHelper.selectUserId ;
			System.out.println(selectQuery);
			PreparedStatement pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			pstmt.setString(1,userEmailId);
			pstmt.setString(2, deviceToken);
			ResultSet res = SQLUtility.executePreparedQuery(pstmt, con);
			System.out.println(res);
			while (res.next()) {
				String userId = res.getString(1);
				String loginStatus = res.getString(2);
				map.put("userId", userId);
				map.put("loginStatus", loginStatus);
				System.out.println(userId);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return map;

	}

	public List<LoginBean> fetchLoginCred() throws SQLException, JsonProcessingException {

		String selectQuery = JDBCHelper.fetchLoginCredentials;
		List<LoginBean> list = new ArrayList<LoginBean>();
		try {
			con = ConnectionJdbc.getConnection();
			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			ResultSet res = SQLUtility.executePreparedQuery(pstmt, con);
			while (res.next()) {
				login = new LoginBean();
				login.setUserId(res.getInt(1));
				login.setUserEmailId(res.getString(2));
				login.setDeviceToken(res.getString(3));
				login.setUserName(res.getString(4));
				login.setUserRole(res.getString(5));

				list.add(login);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionJdbc.closeConnection(con);
		}
		return list;
	}

}
