package com.dcxllc.dev;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ClientAccount {
	
	 public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getCompanyName() {
		return companyName;
	}





	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}





	public String getCompanyAddress() {
		return companyAddress;
	}





	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}





	public String getMainEmail() {
		return mainEmail;
	}





	public void setMainEmail(String mainEmail) {
		this.mainEmail = mainEmail;
	}





	public String getSecondaryEmail() {
		return secondaryEmail;
	}





	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}





	@PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Long id;
	 
	 @Persistent
	 private String username;
	 
	 @Persistent
	 private String password;
	 
	 @Persistent
	 private String companyName;
	 
	 @Persistent
	 private String companyAddress;
	 
	 @Persistent
	 private String mainEmail;
	 
	 @Persistent
	 private String secondaryEmail;
	 
	 
	 public ClientAccount(String username, String password, String companyName, String companyAddress, String mainEmail, String secondaryEmail){
		 this.username = username;
		 this.password = password;
		 this.companyName = companyName;
		 this.companyAddress = companyAddress;
		 this.mainEmail = mainEmail;
		 this.secondaryEmail = secondaryEmail;
		 
	 }
	 
	 
	 @SuppressWarnings("unchecked")
		public static List<ClientAccount> getAllClient(){
	    	PersistenceManager pm = PMF.get().getPersistenceManager();
			List<ClientAccount> results = null;
			try {
				Query q = pm.newQuery(ClientAccount.class);
				
				results = (List<ClientAccount>) q.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return results;
	    }

}
