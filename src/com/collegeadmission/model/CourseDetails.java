package com.collegeadmission.model;

import java.util.Objects;

public class CourseDetails {
	
	private static int courseId;
	private static String courseType;
	private static String courseName;
	public static  int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public static String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public static String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, courseType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDetails other = (CourseDetails) obj;
		return courseId == other.courseId && Objects.equals(courseName, other.courseName)
				&& Objects.equals(courseType, other.courseType);
	}
	@Override
	public String toString() {
		return "CourseDetails [courseId=" + courseId + ", courseType=" + courseType + ", courseName=" + courseName
				+ "]";
	}
	public CourseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CourseDetails(int courseId, String courseType, String courseName) {
		super();
		this.courseId = courseId;
		this.courseType = courseType;
		this.courseName = courseName;
	}
	public CourseDetails(int courseId2) {
		// TODO Auto-generated constructor stub
		this.courseId = courseId;
	}
	public CourseDetails(String courseType2, String courseName2, int courseId2) {
		// TODO Auto-generated constructor stub
		this.courseType=courseType;
		this.courseName=courseName;
		this.courseId=courseId;
	}
	
	

}
