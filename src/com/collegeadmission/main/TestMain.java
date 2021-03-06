package com.collegeadmission.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.collegeadmission.dao.AdminDao;
import com.collegeadmission.dao.ApplicationDao;
import com.collegeadmission.dao.CoursesDao;
import com.collegeadmission.dao.FeesDao;
import com.collegeadmission.dao.UserDao;
import com.collegeadmission.model.Admin;
import com.collegeadmission.model.ApplicationDetails;
import com.collegeadmission.model.CourseDetails;
import com.collegeadmission.model.FeesDetails;
import com.collegeadmission.model.UserDetails;

public class TestMain {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException, NumberFormatException {
		
	Scanner scan = new Scanner(System.in);	
	
	System.out.println("\n1.Register\n2.Login\nEnter your choice");
	int choice=Integer.parseInt(scan.nextLine());
	UserDao UserDao=null;
		switch(choice)
	{
	case 1:
	{
		String UserName=null;
		String email = null;
		//long MobileNumber=0;
		String UserPassword = null;
		UserDao user=new UserDao();
		do
		{
		System.out.println("Enter user Name:");
		UserName=scan.nextLine();
		if(UserName.isEmpty())
		{
			System.out.println("name can't be empty");
		}
		else if (!UserName.matches("[A-Za-z]{3,}")) {
			System.out.println("invalid name");
		}
		}while(!UserName.matches("[A-Za-z]{3,}"));
		
		do
		{
		System.out.println("Enter user Email:");
		email=scan.nextLine();
		if(email.isEmpty())
		{
			System.out.println("email can't be empty");
		}
		else if (!email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+")) 
		{
			System.out.println("invalid email id");
		}
		}
		while(!email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+"));
		
		String tempMobile=null;
		do
		{
		System.out.println("Enter mobile number:");
		tempMobile=scan.nextLine();
		if(!tempMobile.matches("[6-9][0-9]{9}")) 
		{
			System.out.println("Invalid Mobile Number");
		}
		if(tempMobile.isEmpty())
		{
			System.out.println("Mobile number cant be empty");
		}
		}while(!tempMobile.matches("[6-9][0-9]{9}"));
		
		do
		{
		System.out.println("Enter user Password:");
		UserPassword=scan.nextLine();
		if(UserPassword.isEmpty())
		{
			System.out.println("password can't be empty");
		}
		else if (!UserPassword.matches("[A-Za-z@#$%!^&*0-9]{8,10}")) 
		{
			System.out.println("invalid password");
		}
		}
		while(!UserPassword.matches("[A-Za-z@#$%!^&*0-9]{8,10}"));
		
		UserDetails userdetails=new UserDetails(UserName, email,Long.parseLong(tempMobile),UserPassword);
		System.out.println("main"+UserName+ email+Long.parseLong(tempMobile)+UserPassword);
		user.userDetails(userdetails);
		break;
		
	}
		
	case 2:
	{
		String Email=null;
		String UserPassword=null;
		String AdminPassword=null;
		UserDao user1=new UserDao();
		System.out.println("Login");
		System.out.println("Enter the registered email");
	    String email = scan.nextLine();
		if(email.endsWith("@admin.com")) {
			System.out.println("Enter the registered password");
		    AdminPassword = scan.nextLine();
		    
		    System.out.println("Login Successful");
		    System.out.println("1.To Update User Details\n2.To Delete User Detis\n3.Show User Details\n4.To Update Application Details\n5.Delete Application Details\n6.Show Application Details\n7.Insert Course Details\n8.Update Course Details\n9.Delete Course Details\n10.Insert fees details\n11.update fees details\n12.delete fees details");
		    System.out.println("Enter your choice");
		    int adminchoice=Integer.parseInt(scan.nextLine());
			switch(adminchoice) 
		    {
			case 1:
			UserDao user11 = new UserDao();
			System.out.println("To Update user details");
			System.out.println("Enter the user name ");
			String userName=scan.nextLine();
			System.out.println("Enter the email id");
			String Email1=scan.nextLine();
			System.out.println("Enter the user mobilenumber ");
			long MobileNumber1=Long.parseLong(scan.nextLine());
			System.out.println("Enter the user password");
			String userPassword1=scan.nextLine();
            System.out.println("enter user id");
            int userid = Integer.parseInt(scan.nextLine());
            scan.nextLine();
			UserDetails userdetails=new UserDetails(userid,userName,Email1,MobileNumber1,userPassword1);
			user11.update(userdetails); 
			System.out.println("User details updated");
			break;
			
            
			case 2:
			
				UserDao user2 = new UserDao();
				System.out.println("To Delete User");
				System.out.println("Enter the id to delete ");
				int UserId=Integer.parseInt(scan.nextLine());
				UserDetails userdetails1=new UserDetails(UserId);
				user2.deleteUser(userdetails1);
				break;
			
			case 3:
				
				System.out.println("To view all users");
				UserDao listUsers = new UserDao();
				
				List<UserDetails> userList = listUsers.showAllUsers();
				for(int i=0;i<userList.size();i++)
				{
				System.out.println(userList.get(i));
				}
				break;
			
			case 4:
				
			    ApplicationDao application = new ApplicationDao();
				System.out.println("To Update Application Details");
				
				System.out.println("Enter the student name ");
				String studName=scan.nextLine();
				
				System.out.println("Enter the father's name");
				String fathername=scan.nextLine();
				
				System.out.println("Enter the date of birth ");
				String dateofBirth=scan.nextLine();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date DateofBirth = sdf.parse(dateofBirth);
				
				System.out.println("Enter the SSLC Mark");
				int sslcmark=Integer.parseInt(scan.nextLine());
				
				System.out.println("Enter the HSC Mark");
				int hscmark=Integer.parseInt(scan.nextLine());
				
				System.out.println("Enter the address");
				String adrss=scan.nextLine();
				
				System.out.println("Enter the city");
				String city1=scan.nextLine();
				
				System.out.println("Enter the pincode");
				int pincode1=Integer.parseInt(scan.nextLine());
				
				System.out.println("Enter the state");
				String state1=scan.nextLine();
				
				System.out.println("Enter the nationality");
				String nationality1=scan.nextLine();
				
				System.out.println("Enter the aadhar number");
     			int aadharNumber1=Integer.parseInt(scan.nextLine());
				
				ApplicationDetails applicationdetails=new ApplicationDetails(studName, fathername, DateofBirth, sslcmark, hscmark, adrss, city1, pincode1, state1, nationality1, aadharNumber1);
				application.updateApplication(applicationdetails); 
				System.out.println("Application details updated");
				break;
			
			case 5:
				ApplicationDao application1 = new ApplicationDao();
				System.out.println("To Delete Application");
				System.out.println("Enter the aadhar number to delete ");
				int AadharNo=Integer.parseInt(scan.nextLine());
				ApplicationDetails applicationdetails1=new ApplicationDetails(AadharNo);
				application1.deleteApplication(applicationdetails1);
				break;
				
			
			case 6:
				
				System.out.println("To view all applications");
			    ApplicationDao listApplications = new ApplicationDao();
				List<ApplicationDetails> applicationList = listApplications.showAllApplications();
				for(int i=0;i<applicationList.size();i++)
				{
				System.out.println(applicationList.get(i));
				}
				break;

			
			case 7:
			
			int CourseId=0;
			String CourseType=null;
			String CourseName=null;

			CoursesDao insertcourses = new CoursesDao();
			System.out.println("Details of Courses");
			System.out.println("Enter the Course Id");
			CourseId=Integer.parseInt(scan.nextLine());
			
			System.out.println("Enter the Course Type");
			CourseType=scan.nextLine();
			System.out.println("Enter the Course Name");
			CourseName=scan.nextLine();

			CourseDetails coursedetails=new CourseDetails(CourseId,CourseType,CourseName);
			insertcourses.coursesDetails(coursedetails);
	        break;
			
			
			case 8:
			
			CoursesDao courses = new CoursesDao();
			System.out.println("To Update Course Details");
				
			System.out.println("Enter the course type");
		    String courseType=scan.nextLine();
			System.out.println("Enter the course name");
			String courseName=scan.nextLine();
			System.out.println("Enter the course id");
			int courseId=Integer.parseInt(scan.nextLine());

			CourseDetails updatecourses=new CourseDetails(courseType,courseName,courseId);
			courses.updateCourses(updatecourses);
			break;
			
			case 9:
				
				CoursesDao deletecourses1 = new CoursesDao();
				System.out.println("To Delete Courses");
				System.out.println("Enter the course id to delete ");
				int courseId1=Integer.parseInt(scan.nextLine());
				CourseDetails courses11=new CourseDetails(courseId1);
				deletecourses1.deleteCourses(courses11);
			
			
			case 10:
				
				int FeesId=0;
				int CourseId1=0;
				int AdmissionFees=0;
				int TuitionFees=0;
				int ExamFees=0;

				FeesDao feesdao = new FeesDao();
				System.out.println("Fees Details");
				System.out.println("Enter the Fees Id");
				FeesId=Integer.parseInt(scan.nextLine());
				System.out.println("Enter the Course Id");
				CourseId1=Integer.parseInt(scan.nextLine());
				System.out.println("Enter the AdmissionFees");
				AdmissionFees=Integer.parseInt(scan.nextLine());
				System.out.println("Enter the TuitionFees");
				TuitionFees=Integer.parseInt(scan.nextLine());
				System.out.println("Enter the ExamFees");
				ExamFees=Integer.parseInt(scan.nextLine());

				FeesDetails feesList=new FeesDetails(FeesId,CourseId1,AdmissionFees,TuitionFees,ExamFees);
				feesdao.feesDetails(feesList);
				break;

		    
			
			case 11:
				
//				FeesDao updatefees = new FeesDao();
//				System.out.println("To Update Course Details");
//					
//				System.out.println("Enter the course type");
//			    String courseType=scan.nextLine();
//				System.out.println("Enter the course name");
//				String courseName=scan.nextLine();
//				System.out.println("Enter the fees id");
//				int feesId=Integer.parseInt(scan.nextLine());
//
//				CourseDetails updatecourses=new CourseDetails(courseType,courseName,courseId);
//				courses.updateCourses(updatecourses);
//				break;
				
				
			case 12:
				
				FeesDao deletefees1 = new FeesDao();
				System.out.println("To Delete Fees List");
				System.out.println("Enter the fees id to delete ");
				int feesId=Integer.parseInt(scan.nextLine());
				FeesDetails feesdetails11=new FeesDetails(feesId);
				deletefees1.deleteFeesDetails(feesdetails11);
				
		    }
		}
		
		else {
		
		System.out.println("Enter the registered password");
		UserPassword=scan.nextLine();
		System.out.println("Login Successful");
		System.out.println("Enter your choice");
		choice=Integer.parseInt(scan.nextLine());
	    
		switch(choice) 
        {
		case 1:
		
		int UserId=0;
		String StudentName=null;
		String FatherName=null;
		int AadharNumber=0;
		int SSLCMark=0;
		int HSCMark=0;
		String Address=null;
		String City=null;
		int Pincode=0;
		String State=null;
		String Nationality=null;
		ApplicationDao applicationDetails = new ApplicationDao();
		System.out.println("Details of Application");
		System.out.println("Enter the User Id");
		UserId=Integer.parseInt(scan.nextLine());
		System.out.println("Enter the Student Name");
		StudentName=scan.nextLine();
		System.out.println("Enter the Father Name");
		FatherName=scan.nextLine();
	    System.out.println("Enter the Date of Birth");
	    String DOB=scan.nextLine();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    Date DateofBirth = sdf.parse(DOB);
	    System.out.println("Enter the Aadhar Number");
		AadharNumber=Integer.parseInt(scan.nextLine());
		System.out.println("Enter the SSLC Mark");
		SSLCMark=Integer.parseInt(scan.nextLine());
		System.out.println("Enter the HSC Mark");
		HSCMark=Integer.parseInt(scan.nextLine());
		System.out.println("Enter the Address");
		Address=scan.nextLine();
		System.out.println("Enter the City");
		City=scan.nextLine();
		System.out.println("Enter the Pincode");
		Pincode=Integer.parseInt(scan.nextLine());
		System.out.println("Enter the State");
		State=scan.nextLine();
		System.out.println("Enter the Nationality");
		Nationality=scan.nextLine();
		ApplicationDetails applicationdetails=new ApplicationDetails(UserId,StudentName,FatherName,DateofBirth,AadharNumber,SSLCMark,HSCMark,Address,City,Pincode,State,Nationality);
		System.out.println(applicationdetails.getDateofBirth());
		
		applicationDetails.insertApplication(applicationdetails);
		System.out.println("Applications details inserted successfully");
		break;
		
		case 2:
			
			
			
		case 3:
			
			System.out.println("To view all courses");
			CoursesDao listCourses = new CoursesDao();
			
			List<CourseDetails> coursesList = listCourses.showAllCourses();
			for(int i=0;i<coursesList.size();i++)
			{
			System.out.println(coursesList.get(i));
			}
			break;
			
			
		case 4:
			
			System.out.println("To view all fees list");
			FeesDao listFeesDetails = new FeesDao();
			
			List<FeesDetails> feesList = listFeesDetails.showAllFeesDetails();
			for(int i=0;i<feesList.size();i++)
			{
			System.out.println(feesList.get(i));
			}
			break;
	
		
	}

		}
	}
	}
	}
}

	
