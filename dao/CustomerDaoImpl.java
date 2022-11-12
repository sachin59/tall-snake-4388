package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public String BookTicket(int cid, int tno, int bno, String source, String destination) 
	{
		String message = "Enter Correct Details";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into bookticket(CustomerId,TicketNo,BusNo,Source,Destination) values(?,?,?,?,?)");
					
			ps.setInt(1, cid);
			ps.setInt(2, tno);
			ps.setInt(3,bno);
			ps.setString(4, source);
			ps.setString(5, destination);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Ticket Registered Sucessfully !";
			
				
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	
	}

	
	@Override
	public String RegisterCustomer(int cid, String cname, String address,String contact) 
	{
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into registercustomer(CustomerId,CustomerName,Address,Contact) values(?,?,?,?)");
					
			ps.setInt(1, cid);
			ps.setString(2, cname);
			ps.setString(3, address);
			ps.setString(4, contact);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Customer Registered Sucessfully !";
			
				
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	
	}

	@Override
	public String CancelTicket(int tno) {
	String message = "Wrong Customer ID or Ticket Number";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("delete from bookticket where TicketNo=?");
					
			
			
			ps.setInt(1, tno);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Ticket Deleted Sucessfully !";
			
				
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
		
	}


	@Override
	public int LoginAdmin(String uname, String pass) {
		if(uname.trim()=="admin" && pass.trim()=="admin")
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	@Override
	public String BusDetails(int busno) {
	String message = "Wrong Bus Number";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("select * from BusDetails where BusNo=?");
					
			
			
			ps.setInt(1, busno);
			
			ResultSet rs= ps.executeQuery();
			
			  while (rs.next()) {
			        
			        int bno = rs.getInt("BusNo");
			        String bn = rs.getString("BusName");
			        String source = rs.getString("Source");
			        String dest = rs.getString("Destination");
			        String bt = rs.getString("BusType");
			        String arrival = rs.getString("Arrival");
			        String dep = rs.getString("Departure");
			        
			        System.out.println("BusNo = " +bno + ", BusName = " + bn + ", Source = " + source +
			                           ", Destination = " + dest + ", BusType = " + bt+ ", Arrival = " + arrival+
			                           ", Departure = "+ dep);
			      }
			
			 
			 
			
				
		} catch (SQLException e) {
			message = e.getMessage();
			return message;
		}

		return null;
		
	}
	
	
	
	@Override
	public String ConfirmTicket(int tno) {
	String message = "Wrong Ticket Number";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("UPDATE bookticket SET Status = 'Confirmed' where TicketNo=?");
					
			
			
			ps.setInt(1, tno);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Ticket Confirmed Sucessfully !";
			
				
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
		
	}

	@Override
	public String CustomerDetails(int cno) {
	String message = "Wrong Customer Number";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("select * from RegisterCustomer where CustomerId=?");
					
			
			
			ps.setInt(1, cno);
			
			ResultSet rs= ps.executeQuery();
			
			  while (rs.next()) {
			        
			        int cno1 = rs.getInt("CustomerId");
			        String cn2 = rs.getString("CustomerName");
			        String ad = rs.getString("Address");
			        String ct = rs.getString("Contact");
			        
			        System.out.println("Customer Id = " + cno1 + ", CustomerName = " + cn2 + ", Address = " + ad +
			                           ", Contact = " + ct);
			      }
			
			 
			 
			
				
		} catch (SQLException e) {
			message = e.getMessage();
			return message;
		}

		return null;
		
	}
	

}