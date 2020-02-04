package com.donor.beans;

import java.util.Date;

public class Donation {
	private Long donationId;
	private String firstname;
	private String lastname;
	private String bloodGroup;
	private String email;
	private Long donorId;
	private String bloodQty;  
	private String comments;
	private Date dateOfDonation;
	public Long getDonationId() {
		return donationId;
	}
	public void setDonationId(Long donationId) {
		this.donationId = donationId;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getDonorId() {
		return donorId;
	}
	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getDateOfDonation() {
		return dateOfDonation;
	}
	public void setDateOfDonation(Date dateOfDonation) {
		this.dateOfDonation = dateOfDonation;
	}
	public String getBloodQty() {
		return bloodQty;
	}
	public void setBloodQty(String bloodQty) {
		this.bloodQty = bloodQty;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", bloodGroup=" + bloodGroup + ", donorEmail=" + email + ", donorId=" + donorId + ", bloodQty="
				+ bloodQty + ", comments=" + comments + ", dateOfDonation=" + dateOfDonation + "]";
	}
	
	
	
}
