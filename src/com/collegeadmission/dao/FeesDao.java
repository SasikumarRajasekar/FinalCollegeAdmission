package com.collegeadmission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.collegeadmission.connection.ConnectionUtil;
import com.collegeadmission.model.CourseDetails;
import com.collegeadmission.model.FeesDetails;
import com.collegeadmission.model.UserDetails;

public class FeesDao {
	
	public void feesDetails(FeesDetails feesList) throws ClassNotFoundException, SQLException {
		
        String feesQuery = "insert into fees_list(Fees_Id,Course_Id,Admission_Fees,Tuition_Fees,Exam_Fees) values(?,?,?,?,?)";
		
		Connection con = ConnectionUtil.getDBConnect();
		
		PreparedStatement pstmt = con.prepareStatement(feesQuery);
		
		pstmt.setInt(1,FeesDetails.getFeesId());
		pstmt.setInt(2,FeesDetails.getCourseId());
		pstmt.setInt(3,FeesDetails.getAdmissionFees());
		pstmt.setInt(4,FeesDetails.getTuitionFees());
		pstmt.setInt(5,FeesDetails.getExamFees());
		
		int result=pstmt.executeUpdate();
		System.out.println("Course Selected Successfully");
		pstmt.close();
		con.close();
		
	}
	
	public void updateFeesDetails (FeesDetails feesdetails) throws ClassNotFoundException, SQLException {
    	
    	String update="update fees_details set course_id=?, admission_fees=?, tuition_fees=?, exam_fees where fees_id='"+FeesDetails.getFeesId()+"'";
    	
    	Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement ps=con.prepareStatement(update);
		
		ps.setInt(1,FeesDetails.getCourseId());
		ps.setInt(2,FeesDetails.getAdmissionFees());
		ps.setInt(3,FeesDetails.getTuitionFees());
		ps.setInt(4,FeesDetails.getExamFees());
		
		int result=ps.executeUpdate();
		System.out.println(result+ " is updated !!");
		ps.close();
		con.close();
    }

	
	public void deleteFeesDetails (FeesDetails feesdetails) throws ClassNotFoundException, SQLException {
		
		String del="delete from fees_details where fees_id=?";
		
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement ps=con.prepareStatement(del);
		
		ps.setInt(1,FeesDetails.getFeesId());
		int res=ps.executeUpdate();
		System.out.println(res + "is deleted");
		ps.close();
		con.close();		
	}
	
	public List<FeesDetails> showAllFeesDetails() throws ClassNotFoundException, SQLException
    {
    	List<FeesDetails> feesList = new ArrayList<FeesDetails>();
    	String showfeesquery="select * from fees_list";
    	Connection con = null;
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
			ps = con.prepareStatement(showfeesquery);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FeesDetails feesdetails =new FeesDetails(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
				feesList.add(feesdetails);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return feesList;
    }



}
