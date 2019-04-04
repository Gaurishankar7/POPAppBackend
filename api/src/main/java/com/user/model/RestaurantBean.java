package com.user.model;

import com.fasterxml.jackson.annotation.JsonRootName;



@JsonRootName(value = "Restaurants")
public class RestaurantBean extends Object{

	private int restaurantId;
	private String restaurantName;
	private String restaurantArea;
	private String restaurantImage;
	private String restaurantCuisine;
	private String restaurantPhoneno;
	private int restaurantRating;
	
	
	public RestaurantBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantBean(int restaurantId, String restaurantName, String restaurantArea, String restaurantImage,
			String restaurantCuisine, String restaurantPhoneno, int restaurantRating) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantArea = restaurantArea;
		this.restaurantImage = restaurantImage;
		this.restaurantCuisine = restaurantCuisine;
		this.restaurantPhoneno = restaurantPhoneno;
		this.restaurantRating = restaurantRating;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantArea() {
		return restaurantArea;
	}
	public void setRestaurantArea(String restaurantArea) {
		this.restaurantArea = restaurantArea;
	}
	public String getRestaurantImage() {
		return restaurantImage;
	}
	public void setRestaurantImage(String restaurantImage) {
		this.restaurantImage = restaurantImage;
	}
	public String getRestaurantCuisine() {
		return restaurantCuisine;
	}
	public void setRestaurantCuisine(String restaurantCuisine) {
		this.restaurantCuisine = restaurantCuisine;
	}
	public String getRestaurantPhoneno() {
		return restaurantPhoneno;
	}
	public void setRestaurantPhoneno(String restaurantPhoneno) {
		this.restaurantPhoneno = restaurantPhoneno;
	}
	public int getRestaurantRating() {
		return restaurantRating;
	}
	public void setRestaurantRating(int restaurantRating) {
		this.restaurantRating = restaurantRating;
	}
	@Override
	public String toString() {
		return "RestaurantBean [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantArea=" + restaurantArea + ", restaurantImage=" + restaurantImage + ", restaurantCuisine="
				+ restaurantCuisine + ", restaurantPhoneno=" + restaurantPhoneno + ", restaurantRating="
				+ restaurantRating + "]";
	}
	

	
}
