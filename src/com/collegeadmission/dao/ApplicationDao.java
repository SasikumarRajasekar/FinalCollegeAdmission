package com.collegeadmission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.collegeadmission.connection.ConnectionUtil;
import com.collegeadmission.model.ApplicationDetails;


public class ApplicationDao {
	
	public static void insertApplication(ApplicationDetails applicationdetails) throws ClassNotFoundException, SQLException {
		
		String formQuery = "insert into application_details(User_Id,Student_Name,Father_Name,Date_of_Birth,Aadhar_Number,SSLC_Mark,HSC_Mark,Address,City,Pincode,State,Nationality) values(?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection con = ConnectionUtil.getDBConnect();
		
		PreparedStatement pstmt = con.prepareStatement(formQuery);
		
		pstmt.setInt(1,applicationdetails.getUserId());
		pstmt.setString(2,applicationdetails.getStudentName());
		pstmt.setString(3,applicationdetails.getFatherName());
		System.out.println(applicationdetails.getDateofBirth());
		pstmt.setDate(4, new java.sql.Date(applicationdetails.getDateofBirth().getTime()));
		pstmt.setInt(5,ApplicationDetails.getAadharNumber());
		pstmt.setInt(6,applicationdetails.getSslcMark());
		pstmt.setInt(7,applicationdetails.getHscMark());
		pstmt.setString(8,applicationdetails.getAddress());
		pstmt.setString(9,applicationdetails.getCity());
		pstmt.setInt(10,applicationdetails.getPincode());
		pstmt.setString(11,applicationdetails.getState());
		pstmt.setString(12,applicationdetails.getNationality());
		

			
			int result=pstmt.executeUpdate();
			System.out.println("Registered Successfully");
			pstmt.close();
			con.close();

	}
	
	
	public static void updateApplication (ApplicationDetails applicationdetail) throws ClassNotFoundException, SQLException {
    	
    	String updateApplication="update application_details set student_name=?, father_name=?, date_of_birth=?, sslc_mark=?, hsc_mark=?, address=?, city=?, pincode=?, state=?, nationality=? where aadhar_number=?";
    	
    	Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt=con.prepareStatement(updateApplication);
		
		pstmt.setString(1,applicationdetail.getStudentName());
		pstmt.setString(2,applicationdetail.getFatherName());
		pstmt.setDate(3, new java.sql.Date(applicationdetail.getDateofBirth().getTime()));
		pstmt.setInt(4,applicationdetail.getSslcMark());
		pstmt.setInt(5,applicationdetail.getHscMark());
		pstmt.setString(6,applicationdetail.getAddress());
		pstmt.setString(7,applicationdetail.getCity());
		pstmt.setInt(8,applicationdetail.getPincode());
		pstmt.setString(9,applicationdetail.getState());
		pstmt.setString(10,applicationdetail.getNationality());
		pstmt.setInt(11, ApplicationDetails.getAadharNumber());
		
		int result=pstmt.executeUpdate();
		System.out.println(result+ " is updated !!");
		pstmt.close();
		con.close();
    }
	
	public static void deleteApplication (ApplicationDetails applicationdetails) throws ClassNotFoundException, SQLException {
		
		String del="delete from application_details where aadhar_number = ?";
		
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement ps=con.prepareStatement(del);
		
		ps.setInt(1,applicationdetails.getAadharNumber());
		int res=ps.executeUpdate();
		if(res > 0) {
		System.out.println(res + "is deleted");
		}else {
			System.out.println("no row deleted");
		}
		ps.close();
		con.close();		
	}
	
	public List<ApplicationDetails> showAllApplications() throws ClassNotFoundException, SQLException
    {
    	List<ApplicationDetails> applicationList = new ArrayList<ApplicationDetails>();
    	String showapplicationsquery="select * from application_details";
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
			ps = con.prepareStatement(showapplicationsquery);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ApplicationDetails applicationdetails =new ApplicationDetails(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12));
				applicationList.add(applicationdetails);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return applicationList;


    }
}
