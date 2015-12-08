package com.dcxllc.dev;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CloseTicketServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String issueCategory = null;
		String issueDescription = null;
		String dateIssued = null;
		String companyName = null;
		int ticketNumber = 0;
		String comments = null;
		
		Date currentDate = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String dateClosed = df.format(currentDate);
		
		String[] ticketIDs = req.getParameterValues("ticketIDs");
		
		Long[] tickets = new Long[ticketIDs.length];
		for(int i = 0; i< ticketIDs.length; i++){
			tickets[i] = Long.valueOf(ticketIDs[i]).longValue();
		}
		OpenTicket o = null;
		
		for(int x = 0; x<tickets.length; x++){
			o = pm.getObjectById(OpenTicket.class, tickets[x]);
			issueCategory = o.getIssueCategory();
			issueDescription = o.getIssueDescription();
			dateIssued = o.getDateIssued();
			companyName = o.getCompanyName();
			comments = o.getComments();
			ticketNumber = o.getTicketNumber();
			
			ClosedTicket ct = new ClosedTicket(issueCategory, issueDescription, dateIssued, companyName, ticketNumber, comments, dateClosed);
			try{
				pm.makePersistent(ct);
				pm.deletePersistent(o);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
			
			
			
		}
		resp.sendRedirect("employeePage.jsp");
	}
}
