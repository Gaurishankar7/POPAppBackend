package com.user.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.CardException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.user.model.StripePaymentBean;

public class StripePaymentDAO {
	Charge charge;
	public String stripeResponseId;

	static Logger logger = Logger.getLogger(StripePaymentDAO.class);

	public StripePaymentDAO() {

		Stripe.apiKey = "sk_test_pyrB788emNrc3dEIvqYBkufo";
	}

	public String CardPayment(StripePaymentBean request) {
		Gson g = new Gson();
		String return_json = "";

		try {

			Stripe.apiKey = "sk_test_pyrB788emNrc3dEIvqYBkufo";
			logger.info("Using secret key: " + Stripe.apiKey);

			String token = request.getToken();
			logger.info("Using token: " + token);
			System.out.println("Using token: " + token);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("amount", request.getAmount());
			params.put("currency", "usd");
			params.put("description", "Example charge for gauri dada");
			params.put("source", token);

			charge = Charge.create(params);

			logger.info(charge.getStatus() + "status***************");

			logger.info(charge.getId());

			stripeResponseId = charge.getId();

			return_json = g.toJson(charge);
			return return_json;
		} catch (CardException e) {

			e.printStackTrace();
			e.getMessage();
			charge.setStatus("failed");

			logger.info(e);

			return return_json;

		} catch (StripeException e) {

			e.printStackTrace();
			e.getMessage();
			charge.setStatus("failed");

			logger.info(e);

			return return_json;
		}

	}

}
