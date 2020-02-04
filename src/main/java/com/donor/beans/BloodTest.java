package com.donor.beans;

import java.util.Date;

public class BloodTest {
	
	private Long donationId;
	private String email;
	private Long bloodTestId;
	private String hepatitisb;
	private String hepatitisc;
	private String htlvType1;
	private String htlvType2;
	private String westNileVirus;
	private String syphilis;
	private String hiv;
	private Date dateCreated;
	
	public String getHepatitisb() {
		return hepatitisb;
	}
	public void setHepatitisb(String hepatitisb) {
		this.hepatitisb = hepatitisb;
	}
	public String getHepatitisc() {
		return hepatitisc;
	}
	public void setHepatitisc(String hepatitisc) {
		this.hepatitisc = hepatitisc;
	}
	public String getHtlvType1() {
		return htlvType1;
	}
	public void setHtlvType1(String htlvType1) {
		this.htlvType1 = htlvType1;
	}
	public String getHtlvType2() {
		return htlvType2;
	}
	public void setHtlvType2(String htlvType2) {
		this.htlvType2 = htlvType2;
	}
	public String getWestNileVirus() {
		return westNileVirus;
	}
	public void setWestNileVirus(String westNileVirus) {
		this.westNileVirus = westNileVirus;
	}
	public String getSyphilis() {
		return syphilis;
	}
	public void setSyphilis(String syphilis) {
		this.syphilis = syphilis;
	}
	public String getHiv() {
		return hiv;
	}
	public void setHiv(String hiv) {
		this.hiv = hiv;
	}
	public Long getDonationId() {
		return donationId;
	}
	public void setDonationId(Long donationId) {
		this.donationId = donationId;
	}
	public Long getBloodTestId() {
		return bloodTestId;
	}
	public void setBloodTestId(Long bloodTestId) {
		this.bloodTestId = bloodTestId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "BloodTest [donationId=" + donationId + ", email=" + email + ", bloodTestId=" + bloodTestId
				+ ", hepatitisB=" + hepatitisb + ", hepatitisC=" + hepatitisc + ", htlvType1=" + htlvType1
				+ ", htlvType2=" + htlvType2 + ", westNileVirus=" + westNileVirus + ", syphilis=" + syphilis + ", hiv="
				+ hiv + ", dateCreated=" + dateCreated + "]";
	}
	
	
	

}
