package com.collegeadmission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.collegeadmission.connection.*;
import com.collegeadmission.model.UserDetails;


	public class UserDao {
		
		public void userDetails(UserDetails userdetails) throws ClassNotFoundException, SQLException {
			System.out.println("dao");
			String userQuery = "insert into user_details(User_Name,Email,Mobile_Number,User_Password) values(?,?,?,?)";

			Connection con = ConnectionUtil.getDBConnect();
			
			PreparedStatement pstmt = con.prepareStatement(userQuery);
			
			pstmt.setString(1,userdetails.getUserName());
			pstmt.setString(2,userdetails.getEmail());
			pstmt.setLong(3,userdetails.getMobileNumber());
			pstmt.setString(4,userdetails.getUserPassword());
			
			System.out.println(userdetails.getUserName()+userdetails.getEmail()+userdetails.getMobileNumber()+userdetails.getUserPassword());
				
				int result=pstmt.executeUpdate();
				System.out.println("Registered Successfully");
				pstmt.close();
				con.close();
		    }
		
		
		public void update (UserDetails userdetails) throws ClassNotFoundException, SQLException {
	    	
	    	String update="update user_details set User_Name=?,Email=?,Mobile_Number=?,User_Password=? where user_id=?";
	    	
	    	Connection con=ConnectionUtil.getDBConnect();
			PreparedStatement ps=con.prepareStatement(update);			
			ps.setString(1,userdetails.getUserName());
			ps.setString(2, userdetails.getEmail());
			ps.setLong(3,userdetails.getMobileNumber());
			ps.setString(4, userdetails.getUserPassword());
			ps.setInt(5, userdetails.getUserId());
			
			int result=ps.executeUpdate();
			if(result > 0) {
			System.out.println(result+ " is updated !!");
			}
			else {
				System.out.println("not updated");
			}
			ps.close();
			con.close();
	    }
		
		public void deleteUser (UserDetails userdetails) throws ClassNotFoundException, SQLException {
			
			String del="delete from user_details where user_id=?";
			
			Connection con=ConnectionUtil.getDBConnect();
			PreparedStatement ps=con.prepareStatement(del);
			
			ps.setInt(1,userdetails.getUserId());
			int res=ps.executeUpdate();
			System.out.println(res + "is deleted");
			ps.close();
			con.close();		
		}
		
				
		public List<UserDetails> showAllUsers() throws ClassNotFoundException, SQLException
	    {
	    	List<UserDetails> userList = new ArrayList<UserDetails>();
	    	String showusersquery="select * from user_details";
	    	Connection con = ConnectionUtil.getDBConnect();
	    	PreparedStatement ps;
	    	try {
				con = ConnectionUtil.getDBConnect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	try {
				ps = con.prepareStatement(showusersquery);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(2));
					UserDetails userdetails =new UserDetails(rs.getInt(1),rs.getString(2),rs.getString(3),(long)rs.getLong(4),rs.getString(5));
					userList.add(userdetails);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return userList;
	    }


		


	
		public String loginUser(String UserName,String UserPassword)
		{
			String loginQuery="select * from user_details where User_Name='"+UserName+"' and  User_Password='"+UserPassword+"'" ;
			
			UserDetails user=null;	
			
			try {
				Connection con=ConnectionUtil.getDBConnect();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(loginQuery);
				
				if(rs.next())
				{
				
				return rs.getString(2);
				}
				else
				{
					System.out.println("username and password not valid");
				}
				
			} 
			
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
				
			
		}
	}

		
		



	