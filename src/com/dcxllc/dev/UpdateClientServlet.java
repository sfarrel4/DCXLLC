package com.dcxllc.dev;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UpdateClientServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Long clientID = Long.valueOf(req.getParameter("clientID")).longValue();
		String companyName = req.getParameter("companyName");
		String companyAddress = req.getParameter("companyAddress");
		String mainEmail = req.getParameter("mainEmail");
		String secondaryEmail = req.getParameter("secondaryEmail");
		
		try{
			ClientAccount c = pm.getObjectById(ClientAccount.class, clientID);
			c.setCompanyAddress(companyAddress);
			c.setCompanyName(companyName);
			c.setMainEmail(mainEmail);
			c.setSecondaryEmail(secondaryEmail);
			
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
