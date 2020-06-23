package com.servlet;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProfileDao;
import com.dao.ProfileDaoImpl;

@WebServlet("/profiles")
public class ProfilesServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//I need to fetch whole profiles data from database
		  ProfileDao profileDao=new ProfileDaoImpl();
		  List<ProfileDTO> profileDTOs=profileDao.findAll();
		   //adding profileDTO object inside request scope with namemagic
		   req.setAttribute("profileDTOs", profileDTOs);
		   req.setAttribute("listoptions", profileDao.findAllQualification());
		   req.getRequestDispatcher("profiles.jsp").forward(req, resp);
	}	

}
