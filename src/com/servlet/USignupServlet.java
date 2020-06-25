package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProfileDao;
import com.dao.ProfileDaoImpl;
import com.servlet.dto.ProfileDTO;

@WebServlet("/usignup")
public class USignupServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String qualification=req.getParameter("qualification");
		String mobile=req.getParameter("mobile");
		String gender=req.getParameter("gender");
		String photo=req.getParameter("photo");
		ProfileDTO profileDTO=new  ProfileDTO(username, "", name, email, mobile, gender, photo, qualification);
		ProfileDao profileDao = new ProfileDaoImpl();
		profileDao.updateSignup(profileDTO);
		resp.sendRedirect(req.getContextPath()+"/profiles");
	}

}
