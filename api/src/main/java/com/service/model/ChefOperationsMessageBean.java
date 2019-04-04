package com.service.model;


import java.io.InputStream;

public class ChefOperationsMessageBean {
	
	String message;
	int chefId;
	
	public ChefOperationsMessageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the chefId
	 */
	public int getChefId() {
		return chefId;
	}
	/**
	 * @param chefId the chefId to set
	 */
	public void setChefId(int chefId) {
		this.chefId = chefId;
	}

}
