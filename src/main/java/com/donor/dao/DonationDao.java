package com.donor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.donor.beans.Donation;

public class DonationDao {

	public int addNewDonation(Donation d) {
		int result = 0;
		System.out.println("START addNewDonation");
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			String sql = "insert into donation"
					+ "(donor_id, date_donation, comments, date_created,blood_qty) "
					+ " values(?,?,?,?,?)";
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, d.getDonorId());
				if(d.getDateOfDonation()!=null) {
					statement.setDate(2, new java.sql.Date(d.getDateOfDonation().getTime()));	
				}else {
					statement.setNull(2, java.sql.Types.DATE);
				}
				statement.setString(3, d.getComments());
				statement.setTimestamp(4,
						new java.sql.Timestamp(System.currentTimeMillis()));
				statement.setString(5, d.getBloodQty());
				result = statement.executeUpdate();
				// update donor donation count
				statement=connection.prepareStatement("update donor set  donations_count=(IFNULL(donations_count, 0)+1) where donor_id =?");
				statement.setLong(1, d.getDonorId());
				statement.executeUpdate();
			}
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		System.out.println("END addNewDonation");
		return result;
	}

	public int updateDonation(Donation d) {
		int result = 0;
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			String sql = "update donation "
					+ " set donor_id=?, date_donation=?, comments=?, date_updated=? , blood_qty=? where donation_id=? ";
					
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, d.getDonorId());
				if(d.getDateOfDonation()!=null) {
					statement.setDate(2, new java.sql.Date(d.getDateOfDonation().getTime()));	
				}else {
					statement.setNull(2, java.sql.Types.DATE);
				}
				statement.setString(3, d.getComments());
				
				statement.setTimestamp(4,
						new java.sql.Timestamp(System.currentTimeMillis()));
				statement.setString(5, d.getBloodQty());
				statement.setLong(6, d.getDonationId());
				result = statement.executeUpdate();
			}
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return result;
	}

	public List<Donation> listDonations() {
		String sql ="select dn.donation_id,d.donor_id, d.first_name,d.last_name,d.email,d.blood_group,"
				+ " dn.comments,dn.blood_qty, dn.date_donation,dn.date_updated "
				+ " from donation dn, donor d where dn.donor_id=d.donor_id";

		List<Donation> donations = new ArrayList<Donation>();
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
				ResultSet result = statement.executeQuery();
				Donation d = null;
				while (result.next()) {
					d = new Donation();
					d.setDonationId(result.getLong("donation_id"));
					d.setDonorId(result.getLong("donor_id"));
					d.setFirstname(result.getString("first_name"));
					d.setLastname(result.getString("last_name"));
					d.setBloodQty(result.getString("blood_qty"));
					d.setBloodGroup(result.getString("blood_group"));
					d.setEmail(result.getString("email"));
					d.setComments(result.getString("comments"));
					d.setDateOfDonation(new Date(result.getTimestamp("date_donation").getTime()));
					donations.add(d);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return donations;
	}
	
	public List<Donation> listDonations(Long donorId) {
		String sql ="select dn.donation_id,d.donor_id, d.first_name,d.last_name,d.email,d.blood_group,"
				+ " dn.comments,dn.blood_qty, dn.date_donation,dn.date_updated "
				+ " from donation dn, donor d where dn.donor_id=d.donor_id and d.donor_id=?";
		List<Donation> donations = new ArrayList<Donation>();
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
				statement.setLong(1, donorId);
				ResultSet result = statement.executeQuery();
				Donation d = null;
				while (result.next()) {
					d = new Donation();
					d.setDonationId(result.getLong("donation_id"));
					d.setDonorId(result.getLong("donor_id"));
					d.setFirstname(result.getString("first_name"));
					d.setLastname(result.getString("last_name"));
					d.setBloodQty(result.getString("blood_qty"));
					d.setBloodGroup(result.getString("blood_group"));
					d.setEmail(result.getString("email"));
					d.setComments(result.getString("comments"));
					d.setDateOfDonation(new Date(result.getTimestamp("date_donation").getTime()));
					donations.add(d);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return donations;
	}

	
	

	public Donation getDonationById(Long donationId) {
		String sql ="select dn.donation_id,d.donor_id, d.first_name,d.last_name,d.email,d.blood_group,"
				+ " dn.comments,dn.blood_qty, dn.date_donation,dn.date_updated "
				+ " from donation dn, donor d where dn.donor_id=d.donor_id and dn.donation_id=?";
		Donation d = null;
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
				statement.setLong(1, donationId);
				ResultSet result = statement.executeQuery();
				
				while (result.next()) {
					d = new Donation();
					d.setDonationId(result.getLong("donation_id"));
					d.setDonorId(result.getLong("donor_id"));
					d.setFirstname(result.getString("first_name"));
					d.setLastname(result.getString("last_name"));
					d.setBloodQty(result.getString("blood_qty"));
					d.setBloodGroup(result.getString("blood_group"));
					d.setEmail(result.getString("email"));
					d.setComments(result.getString("comments"));
					d.setDateOfDonation(new Date(result.getTimestamp("date_donation").getTime()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return d;
	}

	
	
	

}
