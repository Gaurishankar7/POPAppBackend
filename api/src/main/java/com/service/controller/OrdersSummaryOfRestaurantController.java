package com.service.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.service.dao.OrdersOfRestaurantDAO;
import com.service.model.MenuItemsQuantityBean;
import com.service.model.OrdersSummaryOfRestaurantBean;


@Path("/restaurantOrder")
public class OrdersSummaryOfRestaurantController {
	
	OrdersSummaryOfRestaurantBean restaurantOrders;
	OrdersOfRestaurantDAO restaurantOrderDao = new OrdersOfRestaurantDAO();
	
//	@GET
//	@Path("/restaurantOrderSummary/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
////	public List<MenuItemsQuantityBean> getresturantOrderSummary(@PathParam("id") int id ) throws JsonProcessingException, SQLException{
////		System.out.println("in controller");
////		return restaurantOrderDao.listRestaurantOrders(id);
////		
////	}

}