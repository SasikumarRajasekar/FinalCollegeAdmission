package com.collegeadmission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.collegeadmission.connection.ConnectionUtil;
import com.collegeadmission.model.Admin;
import com.collegeadmission.model.UserDetails;

public class AdminDao {
	
	public void adminDetails(Admin admin) throws SQLException, ClassNotFoundException {
	
	String adminQuery = "insert into admin_details(Admin_Id,Admin_Name,Admin_Email,Admin_Password) values(?,?,?)";

	Connection con = ConnectionUtil.getDBConnect();
	
	PreparedStatement pstmt = con.prepareStatement(adminQuery);
	
	pstmt.setInt(1, admin.getAdminId());
	pstmt.setString(2, admin.getAdminName());
	pstmt.setString(3, admin.getAdminEmail());
	pstmt.setString(4, admin.getAdminPassword());
	

		
		int result=pstmt.executeUpdate();
		System.out.println(result+ " is updated !!");
		pstmt.close();
		con.close();
    }
	
	public String loginAdmin(String AdminEmail,String AdminPassword)
	{
		String loginQuery="select * from admin_details where Admin_Email'"+AdminEmail+"' and  Admin_Password='"+AdminPassword+"'" ;
		
		Admin admin=null;	
		
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
				System.out.println("adminemail and password not valid");
			}
			
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			
		
	}

	
	}


