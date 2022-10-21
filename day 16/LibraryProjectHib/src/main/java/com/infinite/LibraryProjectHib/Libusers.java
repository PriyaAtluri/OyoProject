package com.infinite.LibraryProjectHib;

import javax.persistence.Column;
import javax.persistence.Id;

public class Libusers {
	@Id
	@Column(name="userName")
	private String userName;
	
	@Column(name="passWord")
	private String passWord;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
