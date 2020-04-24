package VO;

import java.io.Serializable;

public class registrationVO implements Serializable {
	private int userId;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private loginVO userIdd;
	
	public loginVO getUserIdd() {
		return userIdd;
	}
	public void setUserIdd(loginVO userIdd) {
		this.userIdd = userIdd;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	
	
}
