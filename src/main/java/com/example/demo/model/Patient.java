package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table (name = "patient")
@DynamicUpdate
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@Column(name="domain")
//	private boolean isTechnical;
//	
//	public boolean isTechnical() {
//		return isTechnical;
//	}
//	public void setTechnical(boolean isTechnical) {
//		this.isTechnical = isTechnical;
//	}
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name="birth_date")
	private String birthdate;
	@Column(name="gender")
	private String gender;
	@Column(name="email_id")
	private String emailID;	
	@Column(name="mobile_no")
	private long mobileNo;	
	@Column(name="adhar_no")
	private long adharNo;
	@Column(name="blood_group")
	private String bloodGroup;

	Patient(){}
	public Patient(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
}
	
	public Patient(String firstName, String lastName,String birthdate, String gender, String emailID, long mobileNo,
			long adharNo, String bloodGroup) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.emailID = emailID;
		this.mobileNo = mobileNo;
		this.adharNo = adharNo;
		this.bloodGroup = bloodGroup;

		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

}
