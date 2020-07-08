package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.servlet.dto.ProfileDTO;
import com.servlet.utils.DbUtils;

public class ProfileDaoImpl implements ProfileDao {
	@Override
	public String updateSignup(ProfileDTO profileDTO) {
		String sql = "update user_login_tbl set name=?,email=?,qualification=?,mobile=?,photo=?,gender=? where username=?";
		//Try with resource - JDK 1.7
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, profileDTO.getName());
			pstmt.setString(2, profileDTO.getEmail());
			pstmt.setString(3, profileDTO.getQualification());
			pstmt.setString(4, profileDTO.getMobile());
			pstmt.setString(5, profileDTO.getPhoto());
			pstmt.setString(6, profileDTO.getGender());
			pstmt.setString(7, profileDTO.getUsername());
		    pstmt.executeUpdate();
			// This is making new request
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public String createSignup(ProfileDTO profileDTO) {
		String sql = "insert into  user_login_tbl(username,password,name,email,qualification,mobile,photo,gender,createdate) values(?,?,?,?,?,?,?,?,?)";
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, profileDTO.getUsername());
			pstmt.setString(2, profileDTO.getPassword());
			pstmt.setString(3, profileDTO.getName());
			pstmt.setString(4, profileDTO.getEmail());
			pstmt.setString(5, profileDTO.getQualification());
			pstmt.setString(6, profileDTO.getMobile());
			pstmt.setString(7, profileDTO.getPhoto());
			pstmt.setString(8, profileDTO.getGender());
			Timestamp createdate = new Timestamp(new Date().getTime());
			pstmt.setTimestamp(9, createdate);
			int iwiiwiw = pstmt.executeUpdate();
			System.out.println("Rows inserted = " + iwiiwiw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public List<ProfileDTO> sortProfiles(String sort) {
		List<ProfileDTO> profileDTOs = new ArrayList<>();
		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl order by email "
				+ sort;
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);ResultSet rs = pstmt.executeQuery();){
			// Fire the query
			// CTR+SHIFT+O
			while (rs.next()) { // here user is there
				String username = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String qualification = rs.getString(5);
				String mobile = rs.getString(6);
				String photo = rs.getString(7);
				String gender = rs.getString(8);
				ProfileDTO profileDTO = new ProfileDTO(username, password, name, email, mobile, gender, photo,
						qualification);
				profileDTOs.add(profileDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profileDTOs;
	}
	
	@Override
	public List<String> findAllQualification() {
		List<String> qualifications = new ArrayList<>();
		String sql = "select distinct qualification from user_login_tbl ";
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);ResultSet rs = pstmt.executeQuery();){
			// Fire the query
			// CTR+SHIFT+O
			while (rs.next()) { // here user is there
				String q = rs.getString(1);
				qualifications.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qualifications;
	}
	
	
	
	@Override
	public List<ProfileDTO>  filterProfiles(String filterText) {
		// I need to fetch whole profiles data from database
		List<ProfileDTO> profileDTOs = new ArrayList<>();
		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl  where qualification = ?";
		ResultSet rs=null;
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, filterText);
			rs = pstmt.executeQuery();
			// Fire the query
			// CTR+SHIFT+O
			while (rs.next()) { // here user is there
				String username = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String qualification = rs.getString(5);
				String mobile = rs.getString(6);
				String photo = rs.getString(7);
				String gender = rs.getString(8);
				ProfileDTO profileDTO = new ProfileDTO(username, password, name, email, mobile, gender, photo,
						qualification);
				profileDTOs.add(profileDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return profileDTOs;
	}

	@Override
	public List<ProfileDTO> searchProfiles(String search) {
		// I need to fetch whole profiles data from database
		List<ProfileDTO> profileDTOs = new ArrayList<>();
		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl  where name like '%"
				+ search + "%'  or  qualification like '%" + search + "%'";
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);ResultSet rs = pstmt.executeQuery();){
			// Fire the query
			// CTR+SHIFT+O
			while (rs.next()) { // here user is there
				String username = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String qualification = rs.getString(5);
				String mobile = rs.getString(6);
				String photo = rs.getString(7);
				String gender = rs.getString(8);
				ProfileDTO profileDTO = new ProfileDTO(username, password, name, email, mobile, gender, photo,
						qualification);
				profileDTOs.add(profileDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profileDTOs;
	}

	@Override
	public List<ProfileDTO> findAll() {
		List<ProfileDTO> profileDTOs = new ArrayList<>();
		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl";
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);ResultSet rs = pstmt.executeQuery();){
			// Fire the query
			// CTR+SHIFT+O
			while (rs.next()) { // here user is there
				String username = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String qualification = rs.getString(5);
				String mobile = rs.getString(6);
				String photo = rs.getString(7);
				String gender = rs.getString(8);
				ProfileDTO profileDTO = new ProfileDTO(username, password, name, email, mobile, gender, photo,
						qualification);
				profileDTOs.add(profileDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profileDTOs;
	}
	
	
	@Override
	public ProfileDTO findByEmail(String pemail) {
		ProfileDTO profileDTO = null;
		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl where email=?";
		ResultSet rs=null;
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, pemail);
			 rs = pstmt.executeQuery();
			// Fire the query
			// CTR+SHIFT+O
			if (rs.next()) { // here user is there
				String username = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String qualification = rs.getString(5);
				String mobile = rs.getString(6);
				String photo = rs.getString(7);
				String gender = rs.getString(8);
				profileDTO = new ProfileDTO(username, password, name, email, mobile, gender, photo, qualification);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return profileDTO;
	}

	@Override
	public ProfileDTO findByUsername(String pusername) {
		ProfileDTO profileDTO = null;
		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl where username=?";
		ResultSet rs=null;
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, pusername);
			 rs = pstmt.executeQuery();
			// Fire the query
			// CTR+SHIFT+O
			if (rs.next()) { // here user is there
				String username = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String qualification = rs.getString(5);
				String mobile = rs.getString(6);
				String photo = rs.getString(7);
				String gender = rs.getString(8);
				profileDTO = new ProfileDTO(username, password, name, email, mobile, gender, photo, qualification);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return profileDTO;
	}

	@Override
	public void deleteByUsername(String pusername) {
		String sql = "delete from user_login_tbl where username=?";
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, pusername);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ProfileDTO authUser(String pusername, String ppassword) {
		ProfileDTO profileDTO = null;
		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl where username=? and password=?";
		ResultSet rs=null;
		try(Connection conn = DbUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, pusername);
			pstmt.setString(2, ppassword);
			 rs = pstmt.executeQuery();
			// Fire the query
			// CTR+SHIFT+O
			if (rs.next()) { // here user is there
				String username = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String qualification = rs.getString(5);
				String mobile = rs.getString(6);
				String photo = rs.getString(7);
				String gender = rs.getString(8);
				profileDTO = new ProfileDTO(username, password, name, email, mobile, gender, photo, qualification);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return profileDTO;

	}

}
