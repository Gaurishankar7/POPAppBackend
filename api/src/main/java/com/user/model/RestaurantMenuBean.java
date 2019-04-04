package com.user.model;

public class RestaurantMenuBean {
	
	private int menuId;
	private int resturantId;
	private int categoryId;
	private String menuItemName;
	private String price;
	private String menuImage;
	private String availabityStatus;
	
	public RestaurantMenuBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantMenuBean(int menuId, int resturantId, int categoryId, String menuItemName, String price,
			String menuImage, String availabityStatus) {
		super();
		this.menuId = menuId;
		this.resturantId = resturantId;
		this.categoryId = categoryId;
		this.menuItemName = menuItemName;
		this.price = price;
		this.menuImage = menuImage;
		this.availabityStatus = availabityStatus;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMenuImage() {
		return menuImage;
	}

	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}

	public String getAvailabityStatus() {
		return availabityStatus;
	}

	public void setAvailabityStatus(String availabityStatus) {
		this.availabityStatus = availabityStatus;
	}

	@Override
	public String toString() {
		return "RestaurantMenuBean [menuId=" + menuId + ", resturantId=" + resturantId + ", categoryId=" + categoryId
				+ ", menuItemName=" + menuItemName + ", price=" + price + ", menuImage=" + menuImage
				+ ", availabityStatus=" + availabityStatus + "]";
	}

	
	
}