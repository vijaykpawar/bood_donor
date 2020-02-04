package com.donor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.donor.beans.BloodTest;
import com.donor.beans.Donation;

public class BloodTestDao {
	
	public int addNewBloodTest(BloodTest d) {
		int result = 0;
		System.out.println("START addNewBloodTest");
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			String sql = "insert into bloodtest"
					+ "(donation_id,west_nile_virus,syphilis,htlv_type2,htlv_type1,hiv,hepatitisc,hepatitisb,created_date ) "
					+ " values(?,?,?,?,?,?,?,?,?)";
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, d.getDonationId());
				statement.setString(2, d.getWestNileVirus());
				statement.setString(3, d.getSyphilis());
				statement.setString(4, d.getHtlvType2());
				statement.setString(5, d.getHtlvType1());
				statement.setString(6, d.getHiv());
				statement.setString(7, d.getHepatitisc());
				statement.setString(8, d.getHepatitisb());
				statement.setTimestamp(9,
						new java.sql.Timestamp(System.currentTimeMillis()));
				result = statement.executeUpdate();
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

	public int updateBloodTest(BloodTest d) {
		int result = 0;
		System.out.println("START updateBloodTest");
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			String sql = "update bloodtest"
					+ "set west_nile_virus=?,syphilis=?,htlv_type2=?,htlv_type1=?,hiv=?,hepatitisc=?,hepatitisb=?,updated_date=? "
					+ " where bloodtest_id=? ";
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, d.getWestNileVirus());
				statement.setString(2, d.getSyphilis());
				statement.setString(3, d.getHtlvType2());
				statement.setString(4, d.getHtlvType1());
				statement.setString(5, d.getHiv());
				statement.setString(6, d.getHepatitisc());
				statement.setString(7, d.getHepatitisb());
				statement.setTimestamp(8,
						new java.sql.Timestamp(System.currentTimeMillis()));
				statement.setLong(9, d.getBloodTestId());
				result = statement.executeUpdate();
			}
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		System.out.println("END updateBloodTest");
		return result;
	}


	public BloodTest getBloodTestByDonationId(Long donationId) {
		BloodTest b = null;
		System.out.println("START getBloodTestByDonationId");
		String sql="select * from bloodtest where donation_id =? ";
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
			
				statement.setLong(1, donationId);
				ResultSet result = statement.executeQuery();
				
				while (result.next()) {
					System.out.println("getBloodTestByDonationId found");
					b=new BloodTest();
					b.setBloodTestId(result.getLong("bloodtest_id"));
					b.setDonationId(result.getLong("donation_id"));
					b.setHepatitisb(result.getString("hepatitisb"));
					b.setHepatitisc(result.getString("hepatitisc"));
					b.setHtlvType1(result.getString("htlv_type1"));
					b.setHtlvType2(result.getString("htlv_type2"));
					b.setWestNileVirus(result.getString("west_nile_virus"));
					b.setSyphilis(result.getString("syphilis"));
					b.setHiv(result.getString("hiv"));
					b.setDateCreated(new Date(result.getTimestamp("created_date").getTime()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		System.out.println("START getBloodTestByDonationId");
		return b;	
	}
}
