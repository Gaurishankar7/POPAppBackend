package com.user.model;

public class OrderSummaryBean {
	

	private String restaurantName;
	private String restaurantArea;
	private String restaurantImage;
	private String restaurantPhoneNo;
	private int menuId;
	private String menuItemName;
	private int price;
	private String orderId;
	private String totalPrice;
	private String orderStatus;
	private int quantity;

	public OrderSummaryBean() {
		super();
		// TODO Auto-generated constructor st
	}

	public OrderSummaryBean(int menuId, String menuItemName, int price, String orderId, String totalPrice,
			String orderStatus, int quantity) {
		super();
		this.menuId = menuId;
		this.menuItemName = menuItemName;
		this.price = price;
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
	}

	/**
	 * @return the restaurantName
	 */
	public String getRestaurantName() {
		return restaurantName;
	}

	/**
	 * @param restaurantName the restaurantName to set
	 */
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	/**
	 * @return the restaurantArea
	 */
	public String getRestaurantArea() {
		return restaurantArea;
	}

	/**
	 * @param restaurantArea the restaurantArea to set
	 */
	public void setRestaurantArea(String restaurantArea) {
		this.restaurantArea = restaurantArea;
	}

	/**
	 * @return the restaurantImage
	 */
	public String getRestaurantImage() {
		return restaurantImage;
	}

	/**
	 * @param restaurantImage the restaurantImage to set
	 */
	public void setRestaurantImage(String restaurantImage) {
		this.restaurantImage = restaurantImage;
	}

	/**
	 * @return the restaurantPhoneNo
	 */
	public String getRestaurantPhoneNo() {
		return restaurantPhoneNo;
	}

	/**
	 * @param restaurantPhoneNo the restaurantPhoneNo to set
	 */
	public void setRestaurantPhoneNo(String restaurantPhoneNo) {
		this.restaurantPhoneNo = restaurantPhoneNo;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderSummaryBean [menuId=" + menuId + ", menuItemName=" + menuItemName + ", price=" + price
				+ ", orderId=" + orderId + ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + ", quantity="
				+ quantity + "]";
	}

}
