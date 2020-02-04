package com.donor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.donor.beans.Donor;
import com.donor.mail.SendMailAsynchronous;
import com.donor.views.AdminDashBoard;
/**
 * 
 * @author Ruchita Bhamare
 *
 */
public class DonorDao {
	
	/**
	 * 
	 * @param d
	 * @return 
	 * Add new student into database 
	 * 
	 */
	public int addNewDonor(Donor d) {
		int result = 0;
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			String sql = "insert into donor"
					+ "(first_name, last_name, blood_group, birth_date, username,password,"
					+ "email,mobile,age,gender,weight,"
					+ "address,date_last_donation,date_created,role_id) "
					+ " values(?,?,?,?,?,?"
					+ ",?,?,?,?,?"
					+ ",?,?,?,?)";
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement("select role_id from role where role_key='DONOR'");
				ResultSet rs= statement.executeQuery();
				Long donorRoleId=null;
				while(rs.next()) {
					donorRoleId=rs.getLong("role_id");
				}
				statement=connection.prepareStatement(sql);
				statement.setString(1, d.getFirstName());
				statement.setString(2, d.getLastName());
				statement.setString(3, d.getBloodGroup());
				if(d.getBirthDate()!=null) {
					statement.setDate(4, new java.sql.Date(d.getBirthDate().getTime()));	
				}else {
					statement.setNull(4, java.sql.Types.DATE);
				}
				// here set username as email Id  	
				d.setUsername(d.getEmail());
				statement.setString(5, d.getUsername());
			if(d.getPassword()!=null && d.getPassword().trim().length()>0) {
				statement.setString(6, d.getPassword());
			}else {
				d.setPassword(generateNewPassword());
				statement.setString(6, d.getPassword());
				// create password and set password
			}
				
				
				
				statement.setString(7, d.getEmail());
				statement.setString(8, d.getMobile());
				statement.setInt(9, d.getAge());
				statement.setString(10, d.getGender());
				statement.setDouble(11, d.getWeight());
				
				statement.setString(12, d.getAddress());
				if(d.getDateLastDonation()!=null) {
					statement.setDate(13, new java.sql.Date(d.getDateLastDonation().getTime()));	
				}else {
					statement.setNull(13, java.sql.Types.DATE);
				}
				statement.setTimestamp(14,
						new java.sql.Timestamp(System.currentTimeMillis()));
				statement.setLong(15, donorRoleId);
				result = statement.executeUpdate();
			}
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
			//send async mail 
			String sub= "Welcome to Online Blood Donation Management System";
			String body =
			"Dear "+d.getFirstName()+"\n"
					+ "\n"
					+ "\n"
					+ "Thanks for registering to Online Blood Donation Management System and this is"
					+ "\n"
					+ "your login info:"
					+ "\n"
					+ "\n"
					+ "Username:"+d.getUsername()
					+"\n"
					+ "Password:"+d.getPassword()
					+"\n"
					+ "\n\n"
					+ "Best regards,\n"
					+ "Online Blood Donation Management System.";

			try {
				new SendMailAsynchronous(d.getEmail(),body, sub, null).start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return result;
	}
	
	
	public String generateNewPassword() {
		Random r = new Random();
		StringBuffer buff = new StringBuffer() ;
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
	    for (int i = 0; i < 6; i++) {
	        buff.append(alphabet.charAt(r.nextInt(alphabet.length())));
	    }
	    return buff.toString() ;
	}

	private List<Donor> getDonorList(String sql){
		List<Donor> students = new ArrayList<Donor>();
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
				ResultSet result = statement.executeQuery();
				Donor donor = null;
				while (result.next()) {
					donor = new Donor();
					donor.setDonorId(result.getLong("donor_id"));
					donor.setFirstName(result.getString("first_name"));
					donor.setLastName(result.getString("last_name"));
					donor.setUsername(result.getString("username"));
					donor.setPassword(result.getString("password"));
					donor.setBloodGroup(result.getString("blood_group"));
					donor.setMobile(result.getString("mobile"));
					donor.setEmail(result.getString("email"));
					donor.setAge(result.getInt("age"));
					donor.setWeight(result.getDouble("weight"));
					donor.setGender(result.getString("gender"));
					donor.setAddress(result.getString("address"));
					donor.setDonationsCount(result.getLong("donations_count"));
					donor.setDateCreated(new Date(result.getTimestamp("date_created").getTime()));
					students.add(donor);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return students;
	}
	/**
	 * 
	 * @return
	 * 
	 * 
	 * gets list of students present in database 
	 */
	public List<Donor> listDonors() {
		String sql ="select * from donor d";
		return getDonorList(sql);
	}
	
	public static void main(String[] args) {
		Donor student=new Donor();
		student.setFirstName("vijay");
		System.out.println(new DonorDao().searchDonor(student));
	}
	private String getUpper(String s){
		if(s!=null && !"".equals(s.trim()))
			return s.toUpperCase();
	return null;
	}
	public List<Donor> searchDonor(Donor search) {
		String sql="select * from donor where upper(first_name) like ? or upper(last_name) like ? or upper(blood_group) like ?";

		List<Donor> donors = new ArrayList<Donor>();
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
			
				statement.setString(1, getUpper(search.getFirstName())+"%");
				statement.setString(2, getUpper(search.getLastName())+"%");
				if("".equals(search.getBloodGroup())) {
					statement.setString(3, getUpper(search.getBloodGroup())+"%");	
				}else {
					statement.setString(3, getUpper(search.getBloodGroup()));
				}
				
				ResultSet result = statement.executeQuery();
				Donor donor = null;
				while (result.next()) {
					donor=new Donor();
					donor.setDonorId(result.getLong("donor_id"));
					donor.setFirstName(result.getString("first_name"));
					donor.setLastName(result.getString("last_name"));
					donor.setUsername(result.getString("username"));
					donor.setPassword(result.getString("password"));
					donor.setBloodGroup(result.getString("blood_group"));
					donor.setMobile(result.getString("mobile"));
					donor.setEmail(result.getString("email"));
					donor.setAge(result.getInt("age"));
					donor.setWeight(result.getDouble("weight"));
					donor.setGender(result.getString("gender"));
					donor.setAddress(result.getString("address"));
					donor.setDateCreated(new Date(result.getTimestamp("date_created").getTime()));
							donors.add(donor);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return donors;	
	}

	


	public Donor authenticateDonor(String username, String password) {
		Donor donor = null;
		String sql="select d.*,r.role_key from donor d, role r where d.username=? and d.password=? and r.role_id=d.role_id";
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
			
				statement.setString(1, username);
				statement.setString(2, password);
				ResultSet result = statement.executeQuery();
				
				while (result.next()) {
					donor=new Donor();
					donor.setDonorId(result.getLong("donor_id"));
					donor.setFirstName(result.getString("first_name"));
					donor.setLastName(result.getString("last_name"));
					donor.setUsername(result.getString("username"));
					donor.setPassword(result.getString("password"));
					donor.setBloodGroup(result.getString("blood_group"));
					donor.setMobile(result.getString("mobile"));
					donor.setEmail(result.getString("email"));
					donor.setAge(result.getInt("age"));
					donor.setWeight(result.getDouble("weight"));
					donor.setGender(result.getString("gender"));
					donor.setAddress(result.getString("address"));
					donor.setRole(result.getString("role_key"));
					donor.setDonationsCount(result.getLong("donations_count"));
					donor.setDateCreated(new Date(result.getTimestamp("date_created").getTime()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return donor;	
	}


	public Donor getDonorById(Long donorId) {
		Donor donor = null;
		String sql="select * from donor where donor_id=?";
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
			
				statement.setLong(1, donorId);
				ResultSet result = statement.executeQuery();
				
				while (result.next()) {
					donor=new Donor();
					donor.setDonorId(result.getLong("donor_id"));
					donor.setFirstName(result.getString("first_name"));
					donor.setLastName(result.getString("last_name"));
					donor.setUsername(result.getString("username"));
					donor.setPassword(result.getString("password"));
					donor.setBloodGroup(result.getString("blood_group"));
					donor.setMobile(result.getString("mobile"));
					donor.setEmail(result.getString("email"));
					donor.setAge(result.getInt("age"));
					donor.setWeight(result.getDouble("weight"));
					donor.setGender(result.getString("gender"));
					donor.setAddress(result.getString("address"));
					donor.setRole(result.getString("role"));
					donor.setDonationsCount(result.getLong("donations_count"));
					donor.setDateCreated(new Date(result.getTimestamp("date_created").getTime()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return donor;	
	}
	
	
	


	public int updateDonor(Donor d) {
		int result = 0;
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			String sql = "update donor "
					+ " set first_name=?, last_name=?, blood_group=?, birth_date=?, "
					+ " mobile=?,age=?,gender=?,weight=?,"
					+ " address=?,date_last_donation=?,date_updated=? where donor_id=? ";
					
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, d.getFirstName());
				statement.setString(2, d.getLastName());
				statement.setString(3, d.getBloodGroup());
				if(d.getBirthDate()!=null) {
					statement.setDate(4, new java.sql.Date(d.getBirthDate().getTime()));	
				}else {
					statement.setNull(4, java.sql.Types.DATE);
				}
				statement.setString(5, d.getMobile());
				statement.setInt(6, d.getAge());
				statement.setString(7, d.getGender());
				statement.setDouble(8, d.getWeight());
				statement.setString(9, d.getAddress());
				if(d.getDateLastDonation()!=null) {
					statement.setDate(10, new java.sql.Date(d.getDateLastDonation().getTime()));	
				}else {
					statement.setNull(10, java.sql.Types.DATE);
				}
				statement.setTimestamp(11,
						new java.sql.Timestamp(System.currentTimeMillis()));
				statement.setLong(12, d.getDonorId());
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


	public AdminDashBoard getAdminDashBoard() {
		String sql ="select \r\n" + 
				"(select count(*) from donor) donors,\r\n" + 
				"(select count(*) from donor where blood_group= 'O+') opositives,\r\n" + 
				"(select count(*) from donor where blood_group= 'O-') onegatives\r\n" ;
			

		AdminDashBoard d = null;
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
			
				ResultSet result = statement.executeQuery();
				
				while (result.next()) {
					d=new AdminDashBoard();
					d.setTotalDonors(result.getInt("donors"));
					d.setOpositiveDonors(result.getInt("opositives"));
					d.setOnegativeDonors(result.getInt("onegatives"));
								}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return d;	
	}


	public Donor getDonorByEmailId(String donorEmail) {
		Donor donor = null;
		System.out.println("START getDonorByEmailId");
		String sql="select d.*,r.role_key from donor d, role r where d.email=? and r.role_id=d.role_id";
		DatabaseConnection dbconnection = new DatabaseConnection();
		try {
			Connection connection = dbconnection.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(sql);
			
				statement.setString(1, donorEmail);
				ResultSet result = statement.executeQuery();
				
				while (result.next()) {
					System.out.println("getDonorByEmailId found");
					donor=new Donor();
					donor.setDonorId(result.getLong("donor_id"));
					donor.setFirstName(result.getString("first_name"));
					donor.setLastName(result.getString("last_name"));
					donor.setUsername(result.getString("username"));
					donor.setPassword(result.getString("password"));
					donor.setBloodGroup(result.getString("blood_group"));
					donor.setMobile(result.getString("mobile"));
					donor.setEmail(result.getString("email"));
					donor.setAge(result.getInt("age"));
					donor.setWeight(result.getDouble("weight"));
					donor.setGender(result.getString("gender"));
					donor.setAddress(result.getString("address"));
					donor.setRole(result.getString("role"));
					donor.setDonationsCount(result.getLong("donations_count"));
					donor.setDateCreated(new Date(result.getTimestamp("date_created").getTime()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		System.out.println("START getDonorByEmailId");
		return donor;	
	}
	
	
}
