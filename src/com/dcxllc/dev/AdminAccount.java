package com.dcxllc.dev;

import javax.jdo.annotations.PersistenceCapable;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class AdminAccount {
	
	 @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Long id;
	 
	 @Persistent
	 private String username;
	 
	 @Persistent
	 private String password;
	 
	 public AdminAccount(String username, String password){
		 this.username = username;
		 this.password = password;
	 }
	 
	 public String getUname(){
		 return username;
	 }
	 
	 public void setUname(String username){
		 this.username = username;
	 }
	 
	 public String getPword(){
		 return password;
	 }
	 
	 public void setPword(String password){
		 this.password = password;
	 }
	 
	 
	 public Long getId() {
		return id;
	}

	@SuppressWarnings("unchecked")
		public static List<AdminAccount> getAllAdmin(){
	    	PersistenceManager pm = PMF.get().getPersistenceManager();
			List<AdminAccount> results = null;
			try {
				Query q = pm.newQuery(AdminAccount.class);
				
				results = (List<AdminAccount>) q.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return results;
	    }
}
