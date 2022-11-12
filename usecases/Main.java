package com.masai.usecases;
 
import java.util.Scanner;

 
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
 
import com.masai.exceptions.CustomerException;
 

		public class Main {
			
				public static void main(String[] args) throws CustomerException {
				
					 System.out.println("Please choose from the following options");
					 System.out.println("1. Login as admin");
					 System.out.println("2. Login as customer");
					
					 Scanner sc= new Scanner(System.in);
				
					 int x= sc.nextInt();
				 
				    	
			    
						
						
						switch (x) {
					 	
				        case 1:
				     
				 
				        	System.out.println("Enter Username:");
				    		String uname = sc.next();
				    		
				    		System.out.println("Enter Password:");
				    		String pass = sc.next();
				    		
				    		CustomerDao dao = new CustomerDaoImpl();
				    		
				    		
				    			int o= dao.LoginAdmin(uname, pass);
				    		if(o==1)
				    		{
				    	 		System.out.println("Welcome Admin");
				    	 		
				    	 		System.out.println("===============================");
				    	 		 System.out.println("Please choose from the following options");
								 System.out.println("1. Show Bus Details ");
								 System.out.println("2. Confirm Customer's Ticket ");
								 System.out.println("3. Provide Customer's Details ");
								 
								int k= sc.nextInt();
							    
					            switch (k) {
					     
					            
					            case 1:
					                System.out.println("Choice is 1");
					                System.out.println("Enter Bus Number:");
									int busno= sc.nextInt();
									
					        		
									CustomerDao dao11= new CustomerDaoImpl();
					        		
					     			 dao11.BusDetails(busno);
					        	 
					        	
					                break;
					      
					            case 2:
					                System.out.println("Choice is 2");
					              
									System.out.println("Enter Ticket Number which you want to confirm:");
									int tno= sc.nextInt();
									
									 
									
									CustomerDao dao12=new CustomerDaoImpl();
									
									String result= dao12.ConfirmTicket(tno);
									
									System.out.println(result);
					                break;
					                
					                
					             	                
					            case 3:
					                System.out.println("Choice is 3");
					                
									
									System.out.println("Enter Customer Id for Customer Details:");
									int cno3= sc.nextInt();
									
									
									CustomerDao dao13=new CustomerDaoImpl();
									
									  dao13.CustomerDetails(cno3);
									
									
					                
					                break;
					               
					            }
				    	 		
				    	 		
				    	 		
				    		}
				    		else
				    		{
				    			System.out.println("Invalid Username or Password");
				    			break;
				    			 
				    		}
				        	
				        	
				        	
				        	
				        	break;
				        	
				        	
				       
				        case 2:
				        	
				    	 
				     
				            
				        	 System.out.println("Please choose from the following options");
							 System.out.println("1. Register new Customer");
							 System.out.println("2. Book Bus Ticket");
							 System.out.println("3. Delete Bus Ticket");
							 
							int z= sc.nextInt();
						    
				            switch (z) {
				     
				            
				            case 1:
				                System.out.println("Choice is 1");
				                System.out.println("Enter Customer ID:");
								int cid= sc.nextInt();
								
								 
								System.out.println("Enter Customer Name:");
								String cname= sc.next();
							
	
								System.out.println("Enter Customer Address:");
								String address= sc.next();
								 
								System.out.println("Enter Customer Contact Number:");
								String contact= sc.next();
				        		
				        		
								CustomerDao dao1= new CustomerDaoImpl();
				        		
				     			String s= dao1.RegisterCustomer(cid,cname,address,contact);
				        		
				       			System.out.println(s);
				        	
				                break;
				      
				            case 2:
				                System.out.println("Choice is 2");
				                 
				            	System.out.println("Enter Customer ID:");
								int cid2= sc.nextInt();
								
								System.out.println("Enter Ticket Number:");
								int tno= sc.nextInt();
								
								System.out.println("Enter Bus Number:");
								int bno= sc.nextInt();
								
								System.out.println("Enter Source:");
								String source= sc.next();
								
								System.out.println("Enter Destination:");
								String dest= sc.next();
								
								
								CustomerDao dao2=new CustomerDaoImpl();
								
								String result= dao2.BookTicket(cid2,tno,bno,source,dest);
								
								System.out.println(result);
				                break;
				                
				                
				             	                
				            case 3:
				                System.out.println("Choice is 3");
				                
								
								System.out.println("Enter Ticket Number:");
								int tno3= sc.nextInt();
								
								
								CustomerDao dao3=new CustomerDaoImpl();
								
								String result3= dao3.CancelTicket(tno3);
								
								System.out.println(result3);
				                
				                break;
				               
				            }
				            break;
				       
				            
				        	
				        default:
				            System.out.println("Please select from option 1, 2 or 3");
				            break;
				        }
				}
				}
					
