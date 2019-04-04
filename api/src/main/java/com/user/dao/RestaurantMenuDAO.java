package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.RestaurantMenuBean;

import jdbcConnection.ConnectionJdbc;
import jdbcConnection.JDBCHelper;
import jdbcConnection.SQLUtility;

public class RestaurantMenuDAO {

	Connection con = null;
	ResultSet res = null;
	PreparedStatement pstmt;
	RestaurantMenuBean restaurantMenuBean;

	public List<RestaurantMenuBean> listRestaurant() throws SQLException {

		String selectQuery = JDBCHelper.selectRestaurantMenu;
		ArrayList<RestaurantMenuBean> list = new ArrayList<RestaurantMenuBean>();
		try {
			con = ConnectionJdbc.getConnection();
			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			ResultSet res = SQLUtility.executePreparedQuery(pstmt, con);

			while (res.next()) {
				restaurantMenuBean = new RestaurantMenuBean();
				restaurantMenuBean.setMenuId(res.getInt(1));
				restaurantMenuBean.setResturantId(res.getInt(2));
				restaurantMenuBean.setCategoryId(res.getInt(3));
				restaurantMenuBean.setMenuItemName(res.getString(4));
				restaurantMenuBean.setPrice("$"+res.getInt(5));
				restaurantMenuBean.setMenuImage(res.getString(6));
				list.add(restaurantMenuBean);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally
		{
			ConnectionJdbc.closeConnection(con);
		}
		return list;
	}

	public List<RestaurantMenuBean> selectRestaurantMenu(int id, int categoryId) throws SQLException {

		ArrayList<RestaurantMenuBean> list = new ArrayList<RestaurantMenuBean>();
		try {
			con = ConnectionJdbc.getConnection();
			String selectQuery = JDBCHelper.selectRestaurantMenuById ;

			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);

			pstmt.setInt(1,id);
			pstmt.setInt(2, categoryId);
		
			res = SQLUtility.executePreparedQuery(pstmt, con);
			while (res.next()) {
				restaurantMenuBean = new RestaurantMenuBean();
				restaurantMenuBean.setMenuId(res.getInt(1));
				restaurantMenuBean.setResturantId(res.getInt(2));
				restaurantMenuBean.setCategoryId(res.getInt(3));
				restaurantMenuBean.setMenuItemName(res.getString(4));
				restaurantMenuBean.setPrice("$"+res.getInt(5));
				restaurantMenuBean.setMenuImage(res.getString(6));
				list.add(restaurantMenuBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		finally
		{
			ConnectionJdbc.closeConnection(con);
		}
		return list;

	}
	public String updateMenuStatus (int menuId,String status) throws SQLException

	{
		try {
			System.out.println("in try");
			con = ConnectionJdbc.getConnection();
			System.out.println("Entered in DAO...");

			String updateQuery = JDBCHelper.updateMenuItemStatus ;

			System.out.println(updateQuery);

			

			pstmt = SQLUtility.getPreparedStatement(updateQuery, con);

			
			pstmt.setString(1, status);
			pstmt.setInt(2,menuId);
			
			SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	return "MenuItemStatus  changes" + status;
	}
	
	public RestaurantMenuBean insert(RestaurantMenuBean resMenu) throws SQLException {

		try {
			
			con = ConnectionJdbc.getConnection();
			String insertQuery = JDBCHelper.insertMenuItems;

			pstmt = SQLUtility.getPreparedStatement(insertQuery, con);

			pstmt.setInt(1,resMenu.getResturantId());
			pstmt.setInt(2, resMenu.getCategoryId());
			
			pstmt.setString(3, resMenu.getMenuItemName());
			pstmt.setString(4, resMenu.getPrice());
			
			pstmt.setString(5, resMenu.getMenuImage());
			
			pstmt.setString(6, "available");
			
			
			SQLUtility.executeUpdatePreparedQuery(pstmt, con);
					

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			

		}
		finally
		{
			ConnectionJdbc.closeConnection(con);
		}
		return resMenu;
	}
	public RestaurantMenuBean deleteMenu(int menuId) throws SQLException {

		try {
			con = ConnectionJdbc.getConnection();
			restaurantMenuBean = new RestaurantMenuBean();
			String deleteQuery = JDBCHelper.deleteMenuItem ;

			
			pstmt = SQLUtility.getPreparedStatement(deleteQuery, con);

			pstmt.setInt(1,menuId);
			
			SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			
		} catch (Exception e) {
						e.printStackTrace();
			
		}
		finally
		{
			ConnectionJdbc.closeConnection(con);
		}
		return restaurantMenuBean;
	}

}
