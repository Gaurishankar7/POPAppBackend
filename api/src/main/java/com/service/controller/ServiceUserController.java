package com.service.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.dao.ServiceUserDAO;


@Path("/ServiceUser")
public class ServiceUserController {
	
	ServiceUserDAO serviceuser = new ServiceUserDAO();
	
	@GET
	@Path("/checkuser/{userName}/{password}/{deviceToken}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> addOrder(@PathParam("userName")String userName, @PathParam("password")String password,@PathParam("deviceToken") String deviceToken) throws SQLException {

		System.out.println("controller");

		return serviceuser.checkServiceUser(userName, password,deviceToken);
	}
	

}
