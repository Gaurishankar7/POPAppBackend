package com.service.controller;

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
import com.fasterxml.jackson.databind.JsonMappingException;
import com.service.dao.ChefDAO;
import com.service.model.ChefBean;
import com.service.model.ChefOperationsMessageBean;
import com.service.model.UpdateOrderBean;

@Path("/chef")
public class ChefController {

	ChefBean chef = new ChefBean();
	ChefDAO chefDao = new ChefDAO();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ChefBean> cheflist()
			throws SQLException, ClassNotFoundException, JsonGenerationException, JsonMappingException, IOException {

		List<ChefBean> getList = chefDao.listChef();

		return getList;
	}

	@GET
	@Path("/selectchefbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ChefBean> getChefData(@PathParam("id") int id) throws SQLException {

		return chefDao.selectChef(id);
	}

	@POST
	@Path("/addchef")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.MULTIPART_FORM_DATA,MediaType.APPLICATION_JSON})
	public List<ChefOperationsMessageBean> addChef(ChefBean chefBean) throws SQLException {
		System.out.println("Chef Inserted...");

		return chefDao.insertChef(chefBean);

	}
	
	@PUT
	@Path("/updatechef")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ChefOperationsMessageBean> updateChef(ChefBean chefBean) throws SQLException {
		System.out.println("Chef Inserted...");

		return chefDao.updateChef(chefBean);

	}

	@DELETE
	@Path("/deletechef/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ChefOperationsMessageBean> removeChef(@PathParam("id") int id) throws SQLException {
		return chefDao.deleteChef(id);

	}

	@PUT
	@Path("/updatechefid")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public List<ChefOperationsMessageBean> updateChef(UpdateOrderBean updateChefInorder) throws SQLException{
	   return chefDao.UpdateChefId(updateChefInorder);
       
    }

}