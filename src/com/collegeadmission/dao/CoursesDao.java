package com.collegeadmission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.collegeadmission.connection.ConnectionUtil;
import com.collegeadmission.model.CourseDetails;
import com.collegeadmission.model.UserDetails;

public class CoursesDao {
	
	public void coursesDetails(CourseDetails courseDetails) throws ClassNotFoundException, SQLException {
		
		String courseQuery = "insert into courses_details(Course_Id,Course_Type,Course_Name) values(?,?,?)";
		
		Connection con = ConnectionUtil.getDBConnect();
		
		PreparedStatement pstmt = con.prepareStatement(courseQuery);
		
		pstmt.setInt(1,CourseDetails.getCourseId());
		pstmt.setString(2,CourseDetails.getCourseType());
		pstmt.setString(3,CourseDetails.getCourseName());
			
			int result=pstmt.executeUpdate();
			System.out.println("Course Selected Successfully");
			pstmt.close();
			con.close();
	    }
	
	public void updateCourses (CourseDetails coursedetails) throws ClassNotFoundException, SQLException {
    	
    	String update="update course_details set course_type=?, course_name=? where course_id='"+CourseDetails.getCourseId()+"'";
    	
    	Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement ps=con.prepareStatement(update);
		
		ps.setString(1,CourseDetails.getCourseType());
		ps.setString(2,CourseDetails.getCourseName());
		
		int result=ps.executeUpdate();
		System.out.println(result+ " is updated !!");
		ps.close();
		con.close();
    }

	
	public static void deleteCourses (CourseDetails coursedetails) throws ClassNotFoundException, SQLException {
		
		String del="delete from courses_details where course_id=?";
		
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement ps=con.prepareStatement(del);
		
		ps.setInt(1,CourseDetails.getCourseId());
		int res=ps.executeUpdate();
		System.out.println(res + "is deleted");
		ps.close();
		con.close();		
	}

	public List<CourseDetails> showAllUsers() throws ClassNotFoundException, SQLException
    {
    	List<CourseDetails> courseList = new ArrayList<CourseDetails>();
    	String showcoursesquery="select * from courses_details";
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
			ps = con.prepareStatement(showcoursesquery);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CourseDetails coursedetails =new CourseDetails(rs.getInt(1),rs.getString(2),rs.getString(3));
				courseList.add(coursedetails);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return courseList;
    }

		
	}

