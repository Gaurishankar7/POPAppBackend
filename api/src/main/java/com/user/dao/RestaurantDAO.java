package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.user.model.RestaurantBean;
import jdbcConnection.ConnectionJdbc;
import jdbcConnection.JDBCHelper;
import jdbcConnection.SQLUtility;

public class RestaurantDAO {
	
	 static Logger logger = Logger.getLogger(RestaurantDAO.class);

	Connection con = null;
	RestaurantBean restaurant;
	ResultSet res = null;
	PreparedStatement pstmt = null ;
	String restaurantImage ;
	List<RestaurantBean> list1 = null;
	
	
	public List<RestaurantBean>listRestaurant() throws SQLException, JsonProcessingException {
		logger.info("start of method");
		String selectQuery = JDBCHelper.selectRestaurant;
		List<RestaurantBean> list = new ArrayList<RestaurantBean>();
		try {
			logger.info("in try");
			con = ConnectionJdbc.getConnection();
			logger.info("connenction open");
			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			res = SQLUtility.executePreparedQuery(pstmt, con);
			logger.info("afterr resultset");
			while (res.next()) {
				restaurant = new RestaurantBean();
				restaurant.setRestaurantId(res.getInt(1));
				restaurant.setRestaurantName(res.getString(2));
				restaurant.setRestaurantArea(res.getString(3));
				restaurant.setRestaurantImage(res.getString(4));
				restaurant.setRestaurantCuisine(res.getString(5));

				list.add(restaurant);
			}
			logger.info(list);
			//return list;
	
		} catch (SQLException e) {
			logger.info("in catch");
			e.printStackTrace();
	
				}
		finally
		{
			logger.info("in finally");
			ConnectionJdbc.closeConnection(con);
		}
		
		logger.info("end of method");
		
		return list;
	}

	public Map<String,String> selectRestaurant(int id) throws SQLException {
		
		Map<String, String> map = new HashMap<>();
		try {
		
			con = ConnectionJdbc.getConnection();
			String selectQuery = JDBCHelper.selectRestaurantById;
			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);

			pstmt.setInt(1, id);
			res = SQLUtility.executePreparedQuery(pstmt, con);
			while (res.next()) {
				map.put("restaurantName",res.getString(2));
				map.put("restaurantArea",res.getString(3));
				map.put("restaurantImage",res.getString(4));
				map.put("restaurantCuisine",res.getString(5));
				map.put("restaurantPhoneno", res.getString(6));
				map.put("restaurantRating", Integer.toString( res.getInt(7)));
							}
			
			
		} catch (SQLException e) {
			logger.info("in selct catch");
			e.printStackTrace();

		}
		finally
		{
			ConnectionJdbc.closeConnection(con);
		}
		return map;
		
	}

	public RestaurantBean insertRestaurant(RestaurantBean resBean) throws SQLException {
		
		try {
			con = ConnectionJdbc.getConnection();
			String insertQuery = JDBCHelper.insertRestaurant;			
		
			pstmt = SQLUtility.getPreparedStatement(insertQuery, con);
			System.out.println(pstmt);
			//pstmt.setInt(1, resBean.getRestaurantId());
			pstmt.setString(1, resBean.getRestaurantName());
			pstmt.setString(2, resBean.getRestaurantArea());
			pstmt.setString(3, resBean.getRestaurantImage());
			pstmt.setString(4, resBean.getRestaurantCuisine());
			pstmt.setString(5, resBean.getRestaurantPhoneno());
			SQLUtility.executeUpdatePreparedQuery(pstmt, con);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			

		}
		finally
		{
			ConnectionJdbc.closeConnection(con);
		}
		return resBean;
	}

	public RestaurantBean updateRestaurant(RestaurantBean restaurantBean) throws SQLException {

		try {
			con = ConnectionJdbc.getConnection();
			restaurant = new RestaurantBean();
			String updateQuery = JDBCHelper.updateRestaurant ;
			pstmt = SQLUtility.getPreparedStatement(updateQuery, con);
			System.out.println(pstmt);
		
			pstmt.setString(1, restaurantBean.getRestaurantName());
			pstmt.setInt(2, restaurantBean.getRestaurantId());
		
			SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			

		}
		finally
		{
			ConnectionJdbc.closeConnection(con);
		}
		return restaurant;

	}

	public RestaurantBean deleteRestaurant(int id) throws SQLException {

		try {
			con = ConnectionJdbc.getConnection();
			restaurant = new RestaurantBean();
			String deleteQuery = JDBCHelper.deleteRestaurantById;
			pstmt = SQLUtility.getPreparedStatement(deleteQuery, con);
			System.out.println(pstmt);
		
			
			pstmt.setInt(1,id);
		
			SQLUtility.executeUpdatePreparedQuery(pstmt, con);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		finally
		{
			ConnectionJdbc.closeConnection(con);
		}
		return restaurant;
	}
}
