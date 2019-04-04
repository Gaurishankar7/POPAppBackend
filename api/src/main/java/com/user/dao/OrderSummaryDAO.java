package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.OrderSummaryBean;

import jdbcConnection.ConnectionJdbc;
import jdbcConnection.JDBCHelper;
import jdbcConnection.SQLUtility;

public class OrderSummaryDAO {
	OrderSummaryBean orderSummary;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	String orderId = null;

	// List<OrderSummaryBean> list ;
	public List<OrderSummaryBean> getOrderId(int userId) throws SQLException {

		try {

			con = ConnectionJdbc.getConnection();

			String selectQuery = JDBCHelper.selectCurrentOrderId;
			System.out.println(selectQuery);
			pstmt =  SQLUtility.getPreparedStatement(selectQuery, con);
			pstmt.setInt(1, userId);
			res = SQLUtility.executePreparedQuery(pstmt, con);
			System.out.println(res.toString());
			while (res.next()) {

				orderId = res.getString(1);
				System.out.println(orderId);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return selectOrderSummary(orderId);
	}

	public List<OrderSummaryBean> selectOrderSummary(String orderId) throws SQLException {

		System.out.println("start of list ordersummary dao");
		ArrayList<OrderSummaryBean> list = new ArrayList<OrderSummaryBean>();
		try {
			con = ConnectionJdbc.getConnection();

			String selectQuery = JDBCHelper.selectOrderSummary;
			System.out.println(selectQuery);
		PreparedStatement	pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			pstmt.setString(1, orderId);
			res = SQLUtility.executePreparedQuery(pstmt, con);
			System.out.println(res.toString());
			while (res.next()) {
				System.out.println("in while");
				orderSummary = new OrderSummaryBean();
				orderSummary.setRestaurantName(res.getString(1));
				orderSummary.setRestaurantArea(res.getString(2));
				orderSummary.setRestaurantImage(res.getString(3));
				orderSummary.setRestaurantPhoneNo(res.getString(4));
				orderSummary.setMenuId(res.getInt(5));

				orderSummary.setMenuItemName(res.getString(6));

				orderSummary.setPrice(res.getInt(7));

				orderSummary.setOrderId(res.getString(8));

				orderSummary.setTotalPrice(res.getString(9));

				orderSummary.setOrderStatus(res.getString(10));
				orderSummary.setQuantity(res.getInt(11));

				list.add(orderSummary);
				System.out.println(list);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			ConnectionJdbc.closeConnection(con);
		}

		return list;

	}

}
