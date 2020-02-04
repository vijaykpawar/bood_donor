package com.donor.actions;

import java.util.ArrayList;
import java.util.List;

import com.donor.beans.Donor;
import com.donor.dao.DonorDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Ruchita Bhamare
 */
public class DonorAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Donor> donorList = new ArrayList<Donor>();

	private Donor donor;

	private Long donorId;

	public String prepareAddDonor() {
		return SUCCESS;
	}

	public String listDonors() {
		donorList = new DonorDao().listDonors();
		return SUCCESS;
	}

	public String registerDonor() {
		DonorDao donorDao = new DonorDao();
		if (donor != null && donor.getDonorId() == null) {
			// donor Registration
			int result = donorDao.addNewDonor(donor);
			donorList = donorDao.listDonors();
			addActionMessage("Registration Successfull.");
		}
		return SUCCESS;

	}

	public void validateRegisterDonor() {
		validateAddEditDonor();
	}

	public String prepareEditDonor() {

		if (donorId != null && donorId > 0) {
			// if(donorId.equals())
			donor = new DonorDao().getDonorById(donorId);
		}
		return SUCCESS;

	}

	public String addEditDonor() {

		DonorDao donorDao = new DonorDao();
		if (donor != null && donor.getDonorId() == null) {
			// add new donor
			int result = donorDao.addNewDonor(donor);
			donorList = donorDao.listDonors();
			addActionMessage("Donor Successfully added");
		} else {
			int result = donorDao.updateDonor(donor);
			donorList = donorDao.listDonors();
			addActionMessage("Donor info Successfully Updated");

		}
		return SUCCESS;
	}

	public void validateAddEditDonor() {
		if (donor != null) {
			if ("".equals(donor.getFirstName())) {
				addFieldError("donor.firstName", "Please enter first name");
			} else if (donor.getFirstName().trim().length() == 0) {
				addFieldError("donor.firstName", "Please enter valid first name");
			}

			if ("".equals(donor.getLastName())) {
				addFieldError("donor.lastName", "Please enter last name");
			} else if (donor.getLastName().trim().length() == 0) {
				addFieldError("donor.lastName", "Please enter valid last name");
			}

			if ("".equals(donor.getEmail())) {
				addFieldError("donor.email", "Please enter Email Id");
			} else if (donor.getEmail().trim().length() == 0) {
				addFieldError("donor.email", "Please enter valid Email Id");
			}

		}
	}

	public String prepareSearch() {
		return SUCCESS;
	}

	public String searchDonor() {
		DonorDao donorDao = new DonorDao();
		donorList = donorDao.searchDonor(donor);
		return SUCCESS;
	}

	public List<Donor> getDonorList() {
		return donorList;
	}

	public void setDonorList(List<Donor> donorList) {
		this.donorList = donorList;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Long getDonorId() {
		return donorId;
	}

	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}

}
