package com.collegeadmission.model;

import java.util.Date;
import java.util.Objects;

public class ApplicationDetails {
	
    private int userId;
    private String studentName;
    private String fatherName;
    private Date DateofBirth;
    private int aadharNumber;
    private int sslcMark;
    private int hscMark;
    private String address;
    private String city;
    private int pincode;
    private String state;
    private String nationality;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Date getDateofBirth() {
		return DateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		DateofBirth = dateofBirth;
	}
	public int getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(int aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public int getSslcMark() {
		return sslcMark;
	}
	public void setSslcMark(int sslcMark) {
		this.sslcMark = sslcMark;
	}
	public int getHscMark() {
		return hscMark;
	}
	public void setHscMark(int hscMark) {
		this.hscMark = hscMark;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@Override
	public int hashCode() {
		return Objects.hash(DateofBirth, aadharNumber, address, city, fatherName, hscMark, nationality, pincode,
				sslcMark, state, studentName, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationDetails other = (ApplicationDetails) obj;
		return Objects.equals(DateofBirth, other.DateofBirth) && aadharNumber == other.aadharNumber
				&& Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(fatherName, other.fatherName) && hscMark == other.hscMark
				&& Objects.equals(nationality, other.nationality) && pincode == other.pincode
				&& sslcMark == other.sslcMark && Objects.equals(state, other.state)
				&& Objects.equals(studentName, other.studentName) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "ApplicationDetails [userId=" + userId + ", studentName=" + studentName + ", fatherName=" + fatherName
				+ ", DateofBirth=" + DateofBirth + ", aadharNumber=" + aadharNumber + ", sslcMark=" + sslcMark
				+ ", hscMark=" + hscMark + ", address=" + address + ", city=" + city + ", pincode=" + pincode
				+ ", state=" + state + ", nationality=" + nationality + "]";
	}
	
	
	public ApplicationDetails(int userId, String studentName, String fatherName, Date dateofBirth, int aadharNumber,
			int sslcMark, int hscMark, String address, String city, int pincode, String state, String nationality) {
		super();
		this.userId = userId;
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.DateofBirth = dateofBirth;
		this.aadharNumber = aadharNumber;
		this.sslcMark = sslcMark;
		this.hscMark = hscMark;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.nationality = nationality;
	}
	
	public ApplicationDetails(int aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public ApplicationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApplicationDetails(String studentName, String fatherName, Date dateofBirth, int sslcMark, int hscMark,
			String address, String city, int pincode, String state, String nationality, int aadharNumber) {
		// TODO Auto-generated constructor stub
		
		
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.DateofBirth = dateofBirth;
		this.sslcMark = sslcMark;
		this.hscMark = hscMark;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.nationality = nationality;
		this.aadharNumber = aadharNumber;
	}

    
    
    
}