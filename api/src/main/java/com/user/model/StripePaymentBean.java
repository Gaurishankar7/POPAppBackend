package com.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class StripePaymentBean {

	
	
	private int amount;
	private String token;
	private String description;
	private String currency;
	private String stripeResponseID;
	
	public StripePaymentBean() {
		super();
	}

	public StripePaymentBean(int amount, String token, String description, String currency) {
		super();
		this.amount = amount;
		this.token = token;
		this.description = description;
		this.currency = currency;
	}

	public int getAmount() {
		System.out.println("===============Get amount["+ amount +"] called===================");
		return amount;
	}

	public void setAmount(int amount) {
		System.out.println("===============Set amount["+ amount +"] called===================");
		this.amount = amount;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "ChargeRequest [amount=" + amount + ", token=" + token + ", description=" + description + ", currency="
				+ currency + "]";
	}

	/**
	 * @return the stripeResponseID
	 */
	public String getStripeResponseID() {
		return stripeResponseID;
	}

	/**
	 * @param stripeResponseID the stripeResponseID to set
	 */
	public void setStripeResponseID(String stripeResponseID) {
		this.stripeResponseID = stripeResponseID;
	}
	
}