package com.fiberbase;

public class FirebaseStatusBean {
	
	private String orderId;
	private String deviceToken;
	private String orderStatus;
	
	private FirebaseStatusBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	private FirebaseStatusBean(String orderId, String deviceToken, String orderStatus) {
		super();
		this.orderId = orderId;
		this.deviceToken = deviceToken;
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the deviceToken
	 */
	public String getDeviceToken() {
		return deviceToken;
	}

	/**
	 * @param deviceToken the deviceToken to set
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
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
	@Override
	public String toString() {
		return "FirebaseStatusBean [orderId=" + orderId + ", deviceToken=" + deviceToken + ", orderStatus="
				+ orderStatus + "]";
	}


}
