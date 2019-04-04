package com.login.model;

public class LoginBean {

	private int userId;
	private String userEmailId;
	private String deviceToken;
	private String userName;
	private String userRole;
	private String loginStatus;

	public LoginBean() {
		super();
	}

	public LoginBean(int userId, String userEmailId, String deviceToken, String userName, String userRole,
			String loginStatus) {
		super();
		this.userId = userId;
		this.userEmailId = userEmailId;
		this.deviceToken = deviceToken;
		this.userName = userName;
		this.userRole = userRole;
		this.loginStatus = loginStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the loginStatus
	 */
	public String getLoginStatus() {
		return loginStatus;
	}

	/**
	 * @param loginStatus the loginStatus to set
	 */
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginBean [userId=" + userId + ", userEmailId=" + userEmailId + ", deviceToken=" + deviceToken
				+ ", userName=" + userName + ", userRole=" + userRole + ", loginStatus=" + loginStatus + "]";
	}

}