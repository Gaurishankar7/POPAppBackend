package com.user.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.user.dao.OrderSummaryDAO;
import com.user.model.OrderSummaryBean;

@Path("/ordersummary")
public class OrderSummaryController {

	OrderSummaryBean orderSummaryBean = new OrderSummaryBean();
	OrderSummaryDAO orderSummaryDao = new OrderSummaryDAO();

	@GET
	@Path("/getorderSummary/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderSummaryBean> getOrderSummary(@PathParam("userId") int userId)
			throws SQLException, JsonProcessingException {
		System.out.println("ordersummary controller");

		List<OrderSummaryBean> getList = orderSummaryDao.getOrderId(userId);

		return getList;
	}
}