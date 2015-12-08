package com.dcxllc.dev;

import java.io.IOException;

import javax.jdo.PersistenceManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UpdateEmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String[] empIDs = req.getParameterValues("empIDs");
		EmployeeAccount e = null;
		
		
			for(int i =0; i<empIDs.length; i++){
				e = pm.getObjectById(EmployeeAccount.class,Long.valueOf(empIDs[i]).longValue());
				pm.deletePersistent(e);
			}
			pm.close();
			resp.sendRedirect("adminPanel.jsp");
		
		
		
	}
}