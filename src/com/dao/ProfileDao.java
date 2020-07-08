package com.dao;

import java.util.List;

import com.servlet.dto.ProfileDTO;

public interface ProfileDao {
	void deleteByUsername(String pusername);
	ProfileDTO authUser(String pusername, String ppassword);
	ProfileDTO findByUsername(String pusername);
	List<ProfileDTO> findAll();
	List<ProfileDTO> searchProfiles(String search);
	String createSignup(ProfileDTO profileDTO);
	List<ProfileDTO> sortProfiles(String sort);
	String updateSignup(ProfileDTO profileDTO);
	List<ProfileDTO> filterProfiles(String filterText);
	List<String> findAllQualification();
	ProfileDTO findByEmail(String email);
}
