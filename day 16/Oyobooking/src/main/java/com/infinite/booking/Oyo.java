package com.infinite.booking;

import java.util.Date;

public class Oyo {
	private int bookId;
	private int roomId;
	private String custName;
	private String city;
	private Date bookDate;
	private Date chkInDate;
	private Date chkOutDate;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public Date getChkInDate() {
		return chkInDate;
	}
	public void setChkInDate(Date chkInDate) {
		this.chkInDate = chkInDate;
	}
	public Date getChkOutDate() {
		return chkOutDate;
	}
	public void setChkOutDate(Date chkOutDate) {
		this.chkOutDate = chkOutDate;
	}

}
