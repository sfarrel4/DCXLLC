package com.dcxllc.dev;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ClosedTicket {
	
	 @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long ticketID;
	 
	 @Persistent
	private String issueCategory;
	 @Persistent
	private String issueDescription;
	 @Persistent
	private String dateIssued;
	 @Persistent
	private String companyName;
	 @Persistent
	private String comments;
	 @Persistent
	private int ticketNumber;
	 @Persistent
	private String dateClosed;
	 
	 
	 public ClosedTicket(String issueCategory, String issueDescription, String dateIssued, String companyName, int ticketNumber, String comments, String dateClosed){
		 this.issueCategory = issueCategory;
		 this.issueDescription = issueDescription;
		 this.dateIssued = dateIssued;
		 this.companyName = companyName;
		 this.ticketNumber= ticketNumber;
		 this.comments = comments;
		 this.dateClosed = dateClosed;
		  
		 
	 }

	public Long getTicketID() {
		return ticketID;
	}

	public String getIssueCategory() {
		return issueCategory;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public String getDateIssued() {
		return dateIssued;
	}

	public String getComments() {
		return comments;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setIssueCategory(String issueCategory) {
		this.issueCategory = issueCategory;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public  void setComments(String comments) {
		this.comments = comments;
	}
	public String getCompanyName(){
		return companyName;
	}
	
	
	
	
	public String getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(String dateClosed) {
		this.dateClosed = dateClosed;
	}

	@SuppressWarnings("unchecked")
	public static List<ClosedTicket> getAllClosedTickets(){
    	PersistenceManager pm = PMF.get().getPersistenceManager();
		List<ClosedTicket> results = null;
		try {
			Query q = pm.newQuery(ClosedTicket.class);
			q.setOrdering("ticketNumber ascending");
			
			results = (List<ClosedTicket>) q.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
    }

}
