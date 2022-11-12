package com.masai.bean;

public class Customer {

	
	private int cid;
	private String cname;
	private String address;
	private String contact;
	
	
	public Customer() {
		 
	}
	
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + ", contact=" + contact + "]";
	}
	
	
	public Customer(int cid, String cname, String address, String contact) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.address = address;
		this.contact = contact;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
