package com.user.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
import com.fasterxml.jackson.databind.JsonMappingException;
import com.user.dao.RestaurantMenuDAO;
import com.user.model.RestaurantMenuBean;

@Path("/restaurantmenu")
public class RestaurantMenuController {

	RestaurantMenuBean restaurant = new RestaurantMenuBean();
	RestaurantMenuDAO restMenu = new RestaurantMenuDAO();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RestaurantMenuBean> restaurantlist()
			throws SQLException, ClassNotFoundException, JsonGenerationException, JsonMappingException, IOException {

		List<RestaurantMenuBean> getList = restMenu.listRestaurant();

		return getList;

	}

	@GET
	@Path("/selectbyid/{id}/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RestaurantMenuBean> getRestaurantData(@PathParam("id") int id, @PathParam("categoryId") int categoryId)
			throws SQLException {

		return restMenu.selectRestaurantMenu(id, categoryId);
	}

	@PUT
	@Path("/updateMenuItemStatus/{menuId}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateRating(@PathParam("menuId") int menuId, @PathParam("status") String status)
			throws SQLException {
		return restMenu.updateMenuStatus(menuId, status);

	}

	@POST
	@Path("/addMenu")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RestaurantMenuBean addMenu(RestaurantMenuBean resMenuBean) throws SQLException {
		System.out.println("menu inserted");

		return restMenu.insert(resMenuBean);

	}

	// CRUD -- DELETE operation
	@DELETE
	@Path("/delete/{menuId}")
	@Produces(MediaType.APPLICATION_JSON)
	public RestaurantMenuBean deleteMenuItwem(@PathParam("menuId") int menuId) throws SQLException {
		return restMenu.deleteMenu(menuId);

	}
}
