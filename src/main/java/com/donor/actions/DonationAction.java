package com.donor.actions;

import java.util.List;

import com.donor.beans.Donation;
import com.donor.beans.Donor;
import com.donor.dao.DonationDao;
import com.donor.dao.DonorDao;
import com.opensymphony.xwork2.ActionSupport;

public class DonationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Donation donation;
	private Long donationId;
    private List<Donation> donations;
	private Long donorId;

	public String addEditDonation() {

		DonationDao donationDao  = new DonationDao();
		if (donation != null && donation.getDonationId() == null) {
			// add new donor
			int result = donationDao.addNewDonation(donation);
			addActionMessage("Donation Successfully added");
		} else {
			int result = donationDao.updateDonation(donation);
			addActionMessage("Donation info Successfully Updated");
		}
		donations = donationDao.listDonations();
		return SUCCESS;
	}
	
	public void validateAddEditDonation() {
		System.out.println("validating Donation details::"+donation);
		// validate that donot with the metioned email exists 
		DonorDao dao=new DonorDao();
		Donor donor=dao.getDonorByEmailId(donation.getEmail());
		System.out.println("Donor by email id ::"+donor);
		
		if(donor==null) {
			addFieldError("donation.email", "Please enter valid Email Id Or Add donor");
		}else {
			donation.setDonorId(donor.getDonorId());
		}
	}
	
	
	public String listDonations() {
		DonationDao dao=new DonationDao();
		if(donorId!=null && donorId>0) {
			donations = dao.listDonations(donorId);
		}else {
			donations = dao.listDonations();	
		}
		return SUCCESS;
	}

	
	public String prepareAddEditDonation() {
		if(donationId!=null && donationId>0) {
			donation=new DonationDao().getDonationById(donationId);
		}
		return SUCCESS;
	}
	
	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public Long getDonationId() {
		return donationId;
	}

	public void setDonationId(Long donationId) {
		this.donationId = donationId;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}

	public Long getDonorId() {
		return donorId;
	}

	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}
	
	
	
	
	
}
