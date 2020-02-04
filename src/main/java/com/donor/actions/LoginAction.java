package com.donor.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.donor.beans.Donor;
import com.donor.dao.DonorDao;
import com.donor.views.AdminDashBoard;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String username;
	private AdminDashBoard dashboard;
	private int donorDonationsCount;
	private String password;
	Map<String, Object> session;

	public String signIn() {
		DonorDao dao = new DonorDao();
		Donor donor = dao.authenticateDonor(username, password);
		try {
			if (donor == null) {
				addActionError("Incorrect Username or Password");
				return ERROR;
			} else {
				((SessionMap<String, Object>) this.session).invalidate();
				this.session = ActionContext.getContext().getSession();
				this.session.put("loggedinuser", donor);
				if (donor.getRole().equals("ADMIN")) {
					dashboard = dao.getAdminDashBoard();
					return SUCCESS;
				} else {
					return "donor";
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * Logout.
	 * 
	 * @return the string
	 */
	public String logout() {
		try {
			session.remove("loggedinuser");
			((SessionMap<String, Object>) this.session).invalidate();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String dashboard() {
		dashboard = new DonorDao().getAdminDashBoard();
		return SUCCESS;
	}
	
	public String donorDashboard() {

		return SUCCESS;
	}


	public String register() {
		return SUCCESS;
	}

	public void validateSignIn() {
		if (username == null || username.trim().length() <= 0) {
			addActionError(getText("Username Required"));
		}

		if (password == null || password.trim().length() <= 0) {
			addActionError(getText("Password required"));
		}
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

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

	public AdminDashBoard getDashboard() {
		return dashboard;
	}

	public void setDashboard(AdminDashBoard dashboard) {
		this.dashboard = dashboard;
	}

	public int getDonorDonationsCount() {
		return donorDonationsCount;
	}

	public void setDonorDonationsCount(int donorDonationsCount) {
		this.donorDonationsCount = donorDonationsCount;
	}

}
