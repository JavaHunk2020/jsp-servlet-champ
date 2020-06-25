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
import com.servlet.utils.Utils;

@WebServlet("/signup")
public class SignupServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String qualification=req.getParameter("qualification");
		String mobile=req.getParameter("mobile");
		String gender=req.getParameter("gender");
		String photo=req.getParameter("photo");
		String password =Utils.generateRandomPassword(5);
		String username=email;
		 ProfileDao profileDao=new ProfileDaoImpl();
		 ProfileDTO profileDTO=new  ProfileDTO(username, password, name, email, mobile, gender, photo, qualification);
		 profileDao.createSignup(profileDTO);
		  req.setAttribute("hmmmm", "Hi , "+name+" , you have done signup successfully!!!!!!!!!!!");
		  req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

}
