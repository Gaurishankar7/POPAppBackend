package com.user.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.user.dao.OrderDAO;
import com.user.model.OrderBean;
import com.user.model.OrderSummaryBean;


@Path("/order")
public class OrderController {

	OrderBean order = new OrderBean();
	OrderDAO orderDao = new OrderDAO();

//	@GET
//	@Path("/list")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<OrderBean> restaurantlist()
//			throws SQLException, ClassNotFoundException, JsonGenerationException, JsonMappingException, IOException {
//
//		List<OrderBean> getList = orderdao.listOrder();
//		
//		return getList;
//	
//	}
	@POST
	@Path("/addOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> addOrder(OrderBean orderBean) throws SQLException {

		System.out.println("Order Placed...!!!");

		return orderDao.insertOrders(orderBean);
	}
	
		@PUT
		@Path("/updateOrderRating/{orderId}/{orderRating}")
	    @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
	    public String updateRating( @PathParam("orderId") String orderId, @PathParam("orderRating") int orderRating) throws SQLException{
		   return orderDao.UpdateOrderRating(orderId,orderRating);
	       
	    }

		@PUT
		@Path("/updateOrderStatus/{orderId}/{orderStatus}")
	    @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
	    public List<OrderSummaryBean>updateStatus( @PathParam("orderId") String orderId, @PathParam("orderStatus") String orderStatus) throws SQLException{
		   return orderDao.UpdateOrderStatus(orderId,orderStatus);
	       
	    }
}