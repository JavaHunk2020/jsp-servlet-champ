package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProfileDao;
import com.dao.ProfileDaoImpl;
import com.servlet.dto.ProfileDTO;

@WebServlet("/filterProfile")
public class FilterProfileServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String filterText=req.getParameter("filterText");
		  ProfileDao profileDao=new ProfileDaoImpl();
		  List<ProfileDTO> profileDTOs=null;
		  if(!"Select".equalsIgnoreCase(filterText)) {
			  profileDTOs=profileDao.filterProfiles(filterText);
		  }else {
			  profileDTOs=profileDao.findAll();
		  }
		   //adding profileDTO object inside request scope with namemagic
		  
		   req.setAttribute("listoptions", profileDao.findAllQualification());
		   
		   req.setAttribute("profileDTOs", profileDTOs);
		   req.getRequestDispatcher("profiles.jsp").forward(req, resp);
	}	

}
