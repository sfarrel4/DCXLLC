package com.dcxllc.dev;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CreateEmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String mainEmail = req.getParameter("mainEmail");
		String phoneNumber = req.getParameter("phoneNumber");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		EmployeeAccount a = new EmployeeAccount(username, password, firstName, lastName, mainEmail, phoneNumber);
		try{
			pm.makePersistent(a);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			pm.close();
		}
		
		resp.sendRedirect("adminPanel.jsp");
	}

}
