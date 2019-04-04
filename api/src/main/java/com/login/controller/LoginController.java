package com.login.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.login.dao.LoginDAO;
import com.login.model.LoginBean;

@Path("/login")
public class LoginController {

	LoginBean loginbean = new LoginBean();
	LoginDAO login = new LoginDAO();

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public Map<String,String> loginCred(LoginBean logBean) throws SQLException {

		System.out.println("Login Creadentials Save...");

		return login.loginCredentials(logBean);

	}

	@GET
	@Path("/fetchlogin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LoginBean> fetchLoginCred()
			throws SQLException, ClassNotFoundException, JsonGenerationException, JsonMappingException, IOException {

		List<LoginBean> getList = login.fetchLoginCred();

		return getList;
	}
	
	
}
