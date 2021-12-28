package com.collegeadmission.model;


	import java.util.Objects;

	public class UserDetails {
		
		private int userId;
	    private String userName;
	    private String email;
	    private long mobileNumber;
	    private String userPassword;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(int mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		@Override
		public int hashCode() {
			return Objects.hash(email, mobileNumber, userName, userPassword);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UserDetails other = (UserDetails) obj;
			return Objects.equals(email, other.email) && mobileNumber == other.mobileNumber
					&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword);
		}
	
		
		@Override
		public String toString() {
			return "UserDetails [userId=" + userId + ", userName=" + userName + ", email=" + email + ", mobileNumber="
					+ mobileNumber + ", userPassword=" + userPassword + "]";
		}
		public UserDetails() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserDetails(String userName, String email, long mobileNumber, String userPassword) {
			super();
			this.userName = userName;
			this.email = email;
			this.mobileNumber = mobileNumber;
			this.userPassword = userPassword;
		}
		
		
		public UserDetails(int userId, String userName, String email, long mobileNumber, String userPassword) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.userPassword = userPassword;
}
		public UserDetails(int userId2) {
			// TODO Auto-generated constructor stub
			this.userId=userId2;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
}


