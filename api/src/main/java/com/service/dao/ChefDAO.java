package com.service.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.service.model.ChefBean;
import com.service.model.ChefOperationsMessageBean;
import com.service.model.UpdateOrderBean;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.user.dao.RestaurantDAO;

import jdbcConnection.ConnectionJdbc;
import jdbcConnection.JDBCHelper;
import jdbcConnection.SQLUtility;

public class ChefDAO {
	 static Logger logger = Logger.getLogger(RestaurantDAO.class);
	Connection con = null;
	ChefBean chef;
	ChefOperationsMessageBean chefMsg;
	PreparedStatement pstmt = null;
	List<ChefBean> list = null;
	List<ChefOperationsMessageBean> listCheckInsert = new ArrayList<>();
	public List<ChefBean> listChef() throws SQLException {

		String selectQuery = JDBCHelper.selectChef;
		List<ChefBean> list = new ArrayList<ChefBean>();
		try {

			con = ConnectionJdbc.getConnection();
			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			ResultSet res = SQLUtility.executePreparedQuery(pstmt, con);
			System.out.println(res);
			while (res.next()) {

				chef = new ChefBean();
				chef.setChefId(res.getInt(1));
				chef.setRestaurantId(res.getInt(2));
				chef.setChefName(res.getString(3));
				chef.setChefGender(res.getString(4));
				chef.setChefMobile(res.getString(5));
				chef.setChefImage(res.getString(6));
				list.add(chef);
				System.out.println(list.toString());
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			ConnectionJdbc.closeConnection(con);
		}
		return list;
	}

	public List<ChefBean> selectChef(int id) throws SQLException {

		try {
			list = new ArrayList<ChefBean>();
			con = ConnectionJdbc.getConnection();
			String selectQuery = JDBCHelper.selectChefById;
			System.out.println(selectQuery);
			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			pstmt.setInt(1, id);
			ResultSet res = SQLUtility.executePreparedQuery(pstmt, con);
			while (res.next()) {
				System.out.println(selectQuery + "in while....");
				chef = new ChefBean();
				System.out.println(res.getInt(1));
				chef.setChefId(res.getInt(1));
				chef.setRestaurantId(res.getInt(2));
				chef.setChefName(res.getString(3));
				chef.setChefGender(res.getString(4));
				chef.setChefMobile(res.getString(5));
				chef.setChefImage(res.getString(6));

				list.add(chef);
				System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionJdbc.closeConnection(con);
		}
		return list;
	}

	public List<ChefOperationsMessageBean> selectAfterInsert() {
		List<ChefOperationsMessageBean> listAdd = new ArrayList<>();
		try {
			ChefOperationsMessageBean chef = new ChefOperationsMessageBean();
			con = ConnectionJdbc.getConnection();

			String selectQuery = JDBCHelper.checkInsert;

			System.out.println(selectQuery);

			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			ResultSet res = SQLUtility.executePreparedQuery(pstmt, con);
			if (res.next()) {
				chef.setChefId(res.getInt(1));
				chef.setMessage("inserted chef successfully");
				listAdd.add(chef);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return listAdd;
	}

	public List<ChefOperationsMessageBean> selectAfterUpdate(int cehfId) {
		List<ChefOperationsMessageBean> listAdd = new ArrayList<>();
		try {
			ChefOperationsMessageBean chef = new ChefOperationsMessageBean();
			con = ConnectionJdbc.getConnection();

			String selectQuery = JDBCHelper.checkUpdate;

			System.out.println(selectQuery);

			pstmt = SQLUtility.getPreparedStatement(selectQuery, con);
			pstmt.setInt(1, cehfId);
			ResultSet res = SQLUtility.executePreparedQuery(pstmt, con);
			if (res.next()) {
				chef.setChefId(res.getInt(1));
				chef.setMessage("updated chef successfully");
				listAdd.add(chef);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return listAdd;
	}

	public List<ChefOperationsMessageBean> insertChef(InputStream uploadedInputStream,FormDataContentDisposition fileDetails, int restaurantId,String chefName,String chefMobile,String chefGender) throws SQLException {
	
		try {
			
			System.out.println(fileDetails.getFileName());
			String imagePath = chefMobile+"_"+fileDetails.getFileName();
			logger.info(fileDetails.getFileName());
			String tomcatBase = System.getProperty("catalina.base") + "/webapps/ROOT/chefImage/";
			logger.info(System.getProperty("catalina.base"));
			System.out.println(tomcatBase + "   tomcat.......");
			logger.info(tomcatBase + "   tomcat.......");
			String uploadedFileLocation = tomcatBase +imagePath;
			// save it
			writeToFile(uploadedInputStream, uploadedFileLocation);

			String output = "File uploaded to : " + uploadedFileLocation;
			System.out.println(output);
			logger.info(output);
			String chefImage = "/chefImage/" + imagePath;
			con = ConnectionJdbc.getConnection();

			String insertQuery = JDBCHelper.insertChef;

			System.out.println(insertQuery);

			pstmt = SQLUtility.getPreparedStatement(insertQuery, con);
			System.out.println(restaurantId+"resId");
			pstmt.setInt(1, restaurantId);
			pstmt.setString(2, chefName);
			System.out.println(chefName+"chefname");
			pstmt.setString(3, chefGender);
			System.out.println(chefGender + "chefgender");
			pstmt.setString(4, chefMobile);
			System.out.println(chefMobile+"chefMobile");
			pstmt.setString(5, chefImage );
			System.out.println(chefImage+"");

			int count = SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			if (count > 0) {
				listCheckInsert = selectAfterInsert();
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			ConnectionJdbc.closeConnection(con);
		}
		return listCheckInsert;
	}

	// save uploaded file to new location
	public void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {
		try {
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<ChefOperationsMessageBean> updateChef(ChefBean chefBean) throws SQLException {
		List<ChefOperationsMessageBean> listUpdate = new ArrayList<>();
		try {
			ChefOperationsMessageBean chefMsg = new ChefOperationsMessageBean();
			con = ConnectionJdbc.getConnection();

			String insertQuery = JDBCHelper.updateChef;

			System.out.println(insertQuery);

			pstmt = SQLUtility.getPreparedStatement(insertQuery, con);
			pstmt.setInt(1, chefBean.getRestaurantId());
			pstmt.setString(2, chefBean.getChefName());
			pstmt.setString(3, chefBean.getChefGender());
			pstmt.setString(4, chefBean.getChefMobile());
			pstmt.setString(5, chefBean.getChefImage());
			pstmt.setInt(6, chefBean.getChefId());
			@SuppressWarnings("unused")
			int count = SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			if (count > 0) {
				listUpdate = selectAfterUpdate(chefBean.getChefId());

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			ConnectionJdbc.closeConnection(con);
		}
		return listUpdate;
	}

	public List<ChefOperationsMessageBean> deleteChef(int id) throws SQLException {
		// Map<String,String> map = new HashMap<>();
		List<ChefOperationsMessageBean> listDelete = new ArrayList<>();
		try {
			ChefOperationsMessageBean chefMsg = new ChefOperationsMessageBean();
			con = ConnectionJdbc.getConnection();
			String deleteQuery = JDBCHelper.deleteChefById;
			pstmt = SQLUtility.getPreparedStatement(deleteQuery, con);
			pstmt.setInt(1, id);
			@SuppressWarnings("unused")
			int count = SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			if (count > 0) {
				chefMsg.setChefId(id);
				chefMsg.setMessage("chef deleted successfully");
				listDelete.add(chefMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionJdbc.closeConnection(con);

		}
		return listDelete;
	}

	public List<ChefOperationsMessageBean> UpdateChefId(UpdateOrderBean updateChefInOrder) throws SQLException

	{
		List<ChefOperationsMessageBean> listUpdateChef = new ArrayList<>();
		try {

			System.out.println("in try");
			con = ConnectionJdbc.getConnection();
			System.out.println("Entered in DAO...");

			String updateQuery = JDBCHelper.updateChefIdInOrder;
			System.out.println(updateQuery);
			pstmt = SQLUtility.getPreparedStatement(updateQuery, con);
			pstmt.setString(1, updateChefInOrder.getTime());
			pstmt.setInt(2, updateChefInOrder.getChefId());
			pstmt.setString(3, updateChefInOrder.getOrderId());
			int count = SQLUtility.executeUpdatePreparedQuery(pstmt, con);
			if (count > 0) {
				ChefOperationsMessageBean chefMsg = new ChefOperationsMessageBean();
				chefMsg.setChefId(updateChefInOrder.getChefId());
				chefMsg.setMessage("chef updated in orders successfully");
				listUpdateChef.add(chefMsg);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			ConnectionJdbc.closeConnection(con);
		}

		return listUpdateChef;

	}
}