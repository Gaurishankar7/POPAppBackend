package com.user.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.user.dao.StripePaymentDAO;
import com.user.model.StripePaymentBean;

@Path("/stripe")
public class StripePaymentController {

	StripePaymentDAO stripePayment = new StripePaymentDAO();

	@POST
	@Path("/charge")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String chargeCard(StripePaymentBean request) throws Exception {
		System.out.println("in stripe controller");
		String returnJson =  stripePayment.CardPayment(request);
		return returnJson;

	}
	
}