package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.user.model.OrderBean;
import com.user.model.OrderSummaryBean;

import jdbcConnection.ConnectionJdbc;
import jdbcConnection.JDBCHelper;
import jdbcConnection.SQLUtility;

public class OrderDAO {

	Connection con;
	PreparedStatement pstmt = null;
	OrderBean order;
	ResultSet res;
	int price=0;
	String orderId;
	private String sumPrice;
	String str;

	public OrderBean insertOrderDetail(OrderBean orderBean, String orderId) throws SQLException
	{

		try {
			System.out.println("in try");
			con = ConnectionJdbc.getConnection();
			System.out.println("Entered in DAO...");
			String insertQuery = JDBCHelper.insertInToOderDetail;
			System.out.println(insertQuery);
			int size = orderBean.getMenuId().length;
			System.out.println(size + "length of menuid array");
		
			for (int i = 0; i < size; i++) {
				System.out.println("in loop");
				System.out.println(pstmt);
			PreparedStatement	pstmt = SQLUtility.getPreparedStatement(insertQuery, con);
				System.out.println(pstmt);
				pstmt.setString(1, orderId);
				int dish[] = new int[size];
				dish = orderBean.getMenuId();
				System.out.println(dish[i]);
				pstmt.setInt(2, dish[i]);
				int quantity[] = new int[size];
				quantity = orderBean.getQuantity();
				System.out.println(quantity[i]);
				pstmt.setInt(3, quantity[i]);
				// int price = getPriceForMenuID(dish[i]);
				System.out.println("final statement"+pstmt);
				pstmt.setInt(4, dish[i]);
				System.out.println("final statement"+pstmt);
				pstmt.executeUpdate();

			}

		}

		catch (Exception e) {
			System.out.println("final statement"+pstmt);
			e.printStackTrace();
			System.out.println(e.toString());
		}

		return orderBean;

	}

	
	public Map<String, String> insertOrders(OrderBean orderBean) throws SQLException

	{
		Map<String, String> map = new HashMap<>();
		try {
			System.out.println("in try");
			con = ConnectionJdbc.getConnection();
			System.out.println("Entered in DAO...");

			String insertQuery = JDBCHelper.insertInToOrder;
			System.out.println(insertQuery);

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			System.out.println(timeStamp);
			orderId = timeStamp + orderBean.getUserId()+orderBean.getRestaurantId() ;
			String orderStatus = "New Order";
			pstmt = SQLUtility.getPreparedStatement(insertQuery, con);
			System.out.println(pstmt);
			pstmt.setString(1, orderId);
			pstmt.setInt(2, orderBean.getUserId());
			pstmt.setInt(3, orderBean.getRestaurantId());
			pstmt.setString(4, orderBean.getOrderStartTime());
			pstmt.setString(5, orderBean.getTotalPrice());
			pstmt.setString(6, orderStatus);
			pstmt.setString(7, orderBean.getPaymentStatus());
			pstmt.setString(8,orderBean.getStripeId());
			SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			insertOrderDetail(orderBean, orderId);
			map = selectOrderId(orderId);
			int resId = orderBean.getRestaurantId();
			System.out.println(map);
			System.out.println(resId);
			//updateRestaurantRating(resId);
			

		}

		catch (Exception e) {
			System.out.println("in catch of  insertorders");
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			ConnectionJdbc.closeConnection(con);
		}
		return map;

	}

	public OrderBean getOrderId(String orderId)

	{

		return order;

	}

	public int getPriceForMenuID(int menuId) throws SQLException {

		try {
			
			con = ConnectionJdbc.getConnection();
			String selectQuery = JDBCHelper.selectPriceFromMenuItems ;
		PreparedStatement	pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			pstmt.setInt(1, menuId);
			res = SQLUtility.executePreparedQuery(pstmt, con);
			while (res.next()) {
				price = res.getInt(1);
				System.out.println(price);
			}
		
		} catch (SQLException e) {
			System.out.println("in catch of get price from menu id");
			e.printStackTrace();

		}

		return price;

	}

	public String checkTotalPrice(String orderId, String totalPrice) {
		sumPrice = null;
		int sum = 0;

		try {

			con = ConnectionJdbc.getConnection();
			String selectQuery = JDBCHelper.sumPrice;
			System.out.println(selectQuery);
			pstmt= SQLUtility.getPreparedStatement(selectQuery, con);
			pstmt.setString(1, orderId);
			res = SQLUtility.executePreparedQuery(pstmt, con);
			while (res.next()) {
				sum = res.getInt(1);
				System.out.println(sumPrice);
			}
			if (sumPrice.equals(totalPrice)) {

				sumPrice = sum + "$";
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return "sumPrice";
	}

	

	public String UpdateOrderRating(String orderId, int orderRating) throws SQLException

	{
		try {
			System.out.println("in try");
			con = ConnectionJdbc.getConnection();
			System.out.println("Entered in DAO...");

			String updateQuery = JDBCHelper.updateOrderRating;
			System.out.println(updateQuery);

			pstmt = SQLUtility.getPreparedStatement(updateQuery, con);
			pstmt.setInt(1,orderRating);
			pstmt.setString(2, orderId);
			
			SQLUtility.executeUpdatePreparedQuery(pstmt, con);
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			ConnectionJdbc.closeConnection(con);
		}

		return "orderRatingUpdated" + orderRating;

	}

	public List<OrderSummaryBean>UpdateOrderStatus(String orderId, String orderStatus) throws SQLException

	{
		try {
			System.out.println("in try");
			con = ConnectionJdbc.getConnection();
			System.out.println("Entered in DAO...");

			String updateQuery = JDBCHelper.updateOrderStatus;
			System.out.println(updateQuery);
			pstmt = SQLUtility.getPreparedStatement(updateQuery, con);
			pstmt.setString(1, orderStatus);
			pstmt.setString(2,orderId);
			System.out.println(pstmt.toString());
			int count = SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			System.out.println(count+"value of count ");
			if(count>0)
			{
				FireBaseServiceDao serviceFirebase = new FireBaseServiceDao();
				serviceFirebase.executeUpdateStatus(orderStatus);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
//	} finally {
//			ConnectionJdbc.closeConnection(con);
//		}
		OrderSummaryDAO summary = new OrderSummaryDAO();
		return summary.selectOrderSummary(orderId);

	}

	public void updateRestaurantRating(int resId) {

		try {

			con = ConnectionJdbc.getConnection();
			String updateQuery = JDBCHelper.updateRestaurantRating;
			System.out.println(updateQuery);
			pstmt = SQLUtility.getPreparedStatement(updateQuery, con);
			pstmt.setInt(1, resId);
			
			int count = SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			
			System.out.println(count);
			if(count>0)
			{
				System.out.println("success");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Map<String, String> selectOrderId(String orderId) {
		Map<String, String> map = new HashMap<>();
		try {

			con = ConnectionJdbc.getConnection();
			String selectQuery = JDBCHelper.selectOrderId;
			System.out.println(selectQuery+"select");
			PreparedStatement	pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			pstmt.setString(1, orderId);
			res = SQLUtility.executePreparedQuery(pstmt, con);
			System.out.println(res+"result set ....");
			while (res.next()) {
				String id = res.getString(1);
				String orderStatus = res.getString(2);
				map.put("orderId", id);
				map.put("orderStatus", orderStatus);
				System.out.println(orderId);
			}

		} catch (SQLException e) {
			System.out.println("catch of selectorderID");
			e.printStackTrace();

		}
		return map;

	}

}