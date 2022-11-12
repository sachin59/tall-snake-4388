package com.masai.dao;

import java.util.List;
 
import com.masai.exceptions.CustomerException;
 
 

public interface CustomerDao {
  
	
	public int LoginAdmin(String uname,String pass);
	public String BusDetails(int busno);
	public String RegisterCustomer(int cid, String cname, String address,String contact) throws CustomerException;

	public String BookTicket(int cid,int tno,int bno,String source,String destination) throws CustomerException;

	public String CancelTicket(int tno) throws CustomerException;
	public String ConfirmTicket(int tno)throws CustomerException;
	public String CustomerDetails(int cno3);
	
	 
	
}
