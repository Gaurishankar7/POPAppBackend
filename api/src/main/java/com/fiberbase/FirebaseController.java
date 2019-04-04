package com.fiberbase;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/orderStatus")
public class FirebaseController {
	
	
	
	
	@POST
	@Path("/addStatus")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public FirebaseStatusBean updateStatus(FirebaseStatusBean statusBean)
	{
		
		return statusBean;
		
	}

}
