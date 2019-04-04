package com.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.j2objc.annotations.RetainedLocalRef;
import com.service.model.MenuItemsQuantityBean;
import com.service.model.OrdersSummaryOfRestaurantBean;

import jdbcConnection.ConnectionJdbc;
import jdbcConnection.JDBCHelper;
import jdbcConnection.SQLUtility;

public class OrdersOfRestaurantDAO {

	Connection con = null;
	OrdersSummaryOfRestaurantBean restaurantOrders;;
	MenuItemsQuantityBean menu;
	ResultSet res = null;
	PreparedStatement pstmt = null;
	int count =0;
	String orderIdKey;
	
	
	public List<MenuItemsQuantityBean> getOrdersDetails(List<String> orderIds) throws SQLException{
		List<MenuItemsQuantityBean> list1 = new ArrayList<>();
		String select = "select  o.order_id, l.user_name,m.menu_item_name,od.quantity,( select chef_name from chef_details c where c.chef_id = o.chef_id ) as chef_name,o.order_start_time,o.order_status from menu_items m INNER JOIN order_detail od on m.menu_id=od.menu_id INNER Join orders o on o.order_id=od.order_id inner join login_details l on l.user_id=o.user_id where o.order_id=?";
		
		try {
		
		
			con = ConnectionJdbc.getConnection();
		
			int size = orderIds.size();
			for(int i=0; i<size;i++)
			{
				pstmt = SQLUtility.getPreparedStatement(select, con);
				pstmt.setString(1,orderIds.get(i));
			
		
			res = SQLUtility.executePreparedQuery(pstmt, con);
			
			while(res.next())
			{
				menu = new MenuItemsQuantityBean();
//				list1.add(res.getString(1));
//				list1.add(res.getString(2));
				menu.setMenuItemName(res.getString(3));
				menu.setQuantity(res.getString(4));
//				list1.add(res.getString(3));
//				list1.add(res.getString(4));
//				list1.add(res.getString(5));
//				list1.add(res.getString(6));
//				list1.add(res.getString(7));
				list1.add(menu);
				
			}
			
			
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			

			ConnectionJdbc.closeConnection(con);
		}
		return list1;
		
		
	}
}