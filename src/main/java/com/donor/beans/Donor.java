package com.donor.beans;

import java.util.Date;

public class Donor {

	private Long donorId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String bloodGroup;
	private String mobile;
	private String email;
	private String address;
	private Date birthDate;
	private String gender;
	private int age;
	private double weight;
	private Date dateLastDonation;
	private Date dateCreated;
	private String role;
	private Long donationsCount;
	public Long getDonorId() {
		return donorId;
	}
	public void setDonorId(Long donorId) {
		this.donorId = donorId;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getDateLastDonation() {
		return dateLastDonation;
	}
	public void setDateLastDonation(Date dateLastDonation) {
		this.dateLastDonation = dateLastDonation;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getDonationsCount() {
		return donationsCount;
	}
	public void setDonationsCount(Long donationsCount) {
		this.donationsCount = donationsCount;
	}
	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", bloodGroup=" + bloodGroup + ", mobile=" + mobile + ", email="
				+ email + ", address=" + address + ", birthDate=" + birthDate + ", gender=" + gender + ", age=" + age
				+ ", weight=" + weight + ", dateLastDonation=" + dateLastDonation + ", dateCreated=" + dateCreated
				+ ", role=" + role + ", donationsCount=" + donationsCount + "]";
	}
	
	
}
