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
		FeesDetails.feesId = feesId;
	}
	public static int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		FeesDetails.courseId = courseId;
	}
	public static int getAdmissionFees() {
		return admissionFees;
	}
	public void setAdmissionFees(int admissionFees) {
		FeesDetails.admissionFees = admissionFees;
	}
	public static int getTuitionFees() {
		return tuitionFees;
	}
	public void setTuitionFees(int tuitionFees) {
		FeesDetails.tuitionFees = tuitionFees;
	}
	public static int getExamFees() {
		return examFees;
	}
	public void setExamFees(int examFees) {
		FeesDetails.examFees = examFees;
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
		return admissionFees == other.admissionFees && courseId == other.courseId && examFees == FeesDetails.examFees
				&& feesId == other.feesId && tuitionFees == FeesDetails.tuitionFees;
	}
	public FeesDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeesDetails(int feesId, int courseId, int admissionFees, int tuitionFees, int examFees) {
		super();
		FeesDetails.feesId = feesId;
		FeesDetails.courseId = courseId;
		FeesDetails.admissionFees = admissionFees;
		FeesDetails.tuitionFees = tuitionFees;
		FeesDetails.examFees = examFees;
	}
	public FeesDetails(int feesId1) {
		// TODO Auto-generated constructor stub
		FeesDetails.feesId = feesId1;
	}
	public static int getFeesId1() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
