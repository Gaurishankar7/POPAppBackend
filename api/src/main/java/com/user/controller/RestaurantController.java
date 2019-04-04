package com.user.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.user.dao.RestaurantDAO;
import com.user.model.RestaurantBean;

@Path("/restaurant")
public class RestaurantController {

	RestaurantBean restaurant = new RestaurantBean();
	RestaurantDAO reslist = new RestaurantDAO();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RestaurantBean> restaurantlist()
			throws SQLException, ClassNotFoundException, JsonGenerationException, JsonMappingException, IOException {

		List<RestaurantBean> getList = reslist.listRestaurant();
		
		return getList;
		
	}
	
	@GET
	@Path("/selectbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> getRestaurantData(@PathParam("id") int id) throws SQLException, JsonProcessingException
	    {
	    	
			return reslist.selectRestaurant(id);
	    }

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RestaurantBean addRestaurant(RestaurantBean restaurantBean) throws SQLException
	{
		System.out.println("Restaurant Inserted");
		
		return reslist.insertRestaurant(restaurantBean);
		
	}
	
	   @PUT
	   @Path("/update")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public RestaurantBean editRestaurant(RestaurantBean restaurantBean) throws SQLException {
		   return reslist.updateRestaurant(restaurantBean);
	       
	    }
	 
	    // CRUD -- DELETE operation
	    @DELETE
	    @Path("/delete/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public RestaurantBean removeRestaurant(@PathParam("id") int id) throws SQLException {
	    	return reslist.deleteRestaurant(id);
	        
	    }
	}
