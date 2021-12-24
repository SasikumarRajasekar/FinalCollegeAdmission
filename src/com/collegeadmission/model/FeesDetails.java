package com.collegeadmission.model;

import java.util.Objects;

public class FeesDetails {
	
	private static int feesId;
	private static int courseId;
	private static int admissionFees;
	private static int tuitionFees;
	private static int examFees;
	public static int getFeesId() {
		return feesId;
	}
	public void setFeesId(int feesId) {
		this.feesId = feesId;
	}
	public static int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public static int getAdmissionFees() {
		return admissionFees;
	}
	public void setAdmissionFees(int admissionFees) {
		this.admissionFees = admissionFees;
	}
	public static int getTuitionFees() {
		return tuitionFees;
	}
	public void setTuitionFees(int tuitionFees) {
		this.tuitionFees = tuitionFees;
	}
	public static int getExamFees() {
		return examFees;
	}
	public void setExamFees(int examFees) {
		this.examFees = examFees;
	}
	@Override
	public int hashCode() {
		return Objects.hash(admissionFees, courseId, examFees, feesId, tuitionFees);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeesDetails other = (FeesDetails) obj;
		return admissionFees == other.admissionFees && courseId == other.courseId && examFees == other.examFees
				&& feesId == other.feesId && tuitionFees == other.tuitionFees;
	}
	public FeesDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeesDetails(int feesId, int courseId, int admissionFees, int tuitionFees, int examFees) {
		super();
		this.feesId = feesId;
		this.courseId = courseId;
		this.admissionFees = admissionFees;
		this.tuitionFees = tuitionFees;
		this.examFees = examFees;
	}
	
	

}
