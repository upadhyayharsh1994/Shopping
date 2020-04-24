package VO;

import java.io.Serializable;

public class loginVO implements Serializable{
	private int userIdd;
	private String email;
	private String password;
	
	public int getUserIdd() {
		return userIdd;
	}
	public void setUserIdd(int userIdd) {
		this.userIdd = userIdd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
