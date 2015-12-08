package com.dcxllc.dev;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ReallyUpdateEmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Long empID = Long.valueOf(req.getParameter("empID")).longValue();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String mainEmail = req.getParameter("mainEmail");
		String phoneNumber = req.getParameter("phoneNumber");
		try{
			EmployeeAccount e = pm.getObjectById(EmployeeAccount.class, empID );
			e.setFirstName(firstName);
			e.setLastName(lastName);
			e.setMainEmail(mainEmail);
			e.setPhoneNumber(phoneNumber);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			pm.close();
		}
		resp.sendRedirect("adminPanel.jsp");
		
	}
}
