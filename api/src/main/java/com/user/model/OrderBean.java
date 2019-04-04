package com.user.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBean {

	String orderId;
	int userId;
	int restaurantId;
	int[] menuId;
	int[] quantity;
	String totalPrice;
	String paymentStatus;
	String orderStatus;
	String PaymentStatus;
	int price;
	int order_rating;
	String orderStartTime;
	private String stripeId;

	public OrderBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private OrderBean(String orderId, int userId, int restaurantId, int[] menuId, int[] quantity, String totalPrice,
			String paymentStatus, String orderStatus, String paymentStatus2, int price, int order_rating,
			String orderStartTime) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
		this.orderStatus = orderStatus;
		PaymentStatus = paymentStatus2;
		this.price = price;
		this.order_rating = order_rating;
		this.orderStartTime = orderStartTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int[] getMenuId() {
		return menuId;
	}

	public void setMenuId(int[] menuId) {
		this.menuId = menuId;
	}

	public int[] getQuantity() {
		return quantity;
	}

	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrder_rating() {
		return order_rating;
	}

	public void setOrder_rating(int order_rating) {
		this.order_rating = order_rating;
	}

	public String getOrderStartTime() {
		return orderStartTime;
	}

	public void setOrderStartTime(String orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

	/**
	 * @return the stripeId
	 */
	public String getStripeId() {
		return stripeId;
	}

	/**
	 * @param stripeId the stripeId to set
	 */
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}

	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", menuId="
				+ Arrays.toString(menuId) + ", quantity=" + Arrays.toString(quantity) + ", totalPrice=" + totalPrice
				+ ", paymentStatus=" + paymentStatus + ", orderStatus=" + orderStatus + ", PaymentStatus="
				+ PaymentStatus + ", price=" + price + ", order_rating=" + order_rating + ", orderStartTime="
				+ orderStartTime + "]";
	}

}
