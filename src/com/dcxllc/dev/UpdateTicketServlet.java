package com.dcxllc.dev;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UpdateTicketServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Long ticketID = Long.valueOf(req.getParameter("ticketID")).longValue();
		String issueDescription = req.getParameter("issueDescription");
		String comments = req.getParameter("comments");
		
		try{
			OpenTicket o = pm.getObjectById(OpenTicket.class, ticketID );
			o.setComments(comments);
			o.setIssueDescription(issueDescription);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			pm.close();
		}
		resp.sendRedirect("employeePage.jsp");
	}
}
