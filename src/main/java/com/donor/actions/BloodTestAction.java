package com.donor.actions;

import com.donor.beans.BloodTest;
import com.donor.dao.BloodTestDao;
import com.opensymphony.xwork2.ActionSupport;

public class BloodTestAction extends ActionSupport {

	private Long donationId ;
	 
	private BloodTest bloodTest;
	
	public String prepareAddEditBloodTest() {
		bloodTest=new BloodTestDao().getBloodTestByDonationId(donationId);
		if(bloodTest==null) {
			// add  case  set donation Id 
		bloodTest=new BloodTest();
		bloodTest.setDonationId(donationId);
		}
		return SUCCESS;
	}
	
	public String addEditBloodTest() {
		BloodTestDao dao =new BloodTestDao();
		if(bloodTest!=null && bloodTest.getBloodTestId()!=null && bloodTest.getBloodTestId()>0) {
			//edit labtest case 
			dao.updateBloodTest(bloodTest);
			addActionMessage("Blood Tests updated successfully.");
		}else {
			System.out.println("Blood Test to save is ::"+bloodTest);
			// add new labtest for a donation
			dao.addNewBloodTest(bloodTest);
			addActionMessage("Blood Tests added successfully.");
		}
		return SUCCESS;
	}
	
	public Long getDonationId() {
		return donationId;
	}

	public void setDonationId(Long donationId) {
		this.donationId = donationId;
	}

	public BloodTest getBloodTest() {
		return bloodTest;
	}

	public void setBloodTest(BloodTest bloodTest) {
		this.bloodTest = bloodTest;
	}
	
	
	
	
	
}
