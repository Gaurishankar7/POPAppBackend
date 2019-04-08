package com.service.model;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

public class  ChefBean {
	
	 int chefId;
	 int restaurantId;
	 String chefName;
	 String chefMobile;
	 String chefGender;
	String chefImage;

	public ChefBean() {
		super();
	}
	public int getChefId() {
		return chefId;
	}
	public void setChefId(int chefId) {
		this.chefId = chefId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getChefName() {
		return chefName;
	}
	public void setChefName(String chefName) {
		this.chefName = chefName;
	}
	public String  getChefMobile() {
		return chefMobile;
	}
	public void setChefMobile(String chefMobile) {
		this.chefMobile = chefMobile;
	}
	public String getChefGender() {
		return chefGender;
	}
	public void setChefGender(String chefGender) {
		this.chefGender = chefGender;
	}



	/**
	 * @return the chefImage
	 */
	public String getChefImage() {
		return chefImage;
	}



	/**
	 * @param chefImage the chefImage to set
	 */
	public void setChefImage(String chefImage) {
		this.chefImage = chefImage;
	}



	

}