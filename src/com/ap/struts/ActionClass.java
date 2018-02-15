package com.ap.struts;

import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
public class ActionClass extends ActionSupport{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String driver,url,username,password,query;
private String errorMessage;
private ArrayList<ArrayList<String>> records;
public String execute(){
	
	FormValidator fv=new FormValidator();
	if(fv.validate(driver, url, username, password, query))
	{
		//display table in success page
		try
		{
			//accessing Database
			AccessDB.connect2DB(driver, url, username, password, query);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			String error=e.getMessage();
			fv.setMessage(error);
			e.printStackTrace();
			return "failure";
		}
		setRecords(AccessDB.resultSet2arrayList());
		if(records.isEmpty()){
			fv.setMessage("the query returned empty records");
			System.out.println(fv.getMessage());
			setErrorMessage(fv.getMessage());
			return "failure";			
		}
		return "success";
	}
	//go to form page again with an error message
	System.out.println(driver+" "+url+" "+username+" "+password+" "+query);
	System.out.println(fv.getMessage());
	setErrorMessage(fv.getMessage());
	return "failure";
	}
/*public void validate(){
	if(driver==null||driver.trim().equals("")){
		addFieldError("driver","driver is required");
	}
	if(url==null||url.trim().equals("")){
		addFieldError("url","url is required");
	}
	if(username==null||username.trim().equals("")){
		addFieldError("username","username is required");
	}
	if(password==null||password.equals("")){
		addFieldError("password","password is required");
	}
	if(query==null||query.equals("")){
		addFieldError("query","query is required");
	}
}*/
public String getUsername() {
	return username;
}

public void setUsername(String username) {
	if(username!=null)
	{this.username = username;}
}

public String getDriver() {
	return driver;
}

public void setDriver(String driver) {
	if(driver!=null)
	{this.driver = driver;}
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	if(url!=null)
	{this.url = url;}
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	if(password!=null)
	{this.password = password;}
}

public String getQuery() {
	return query;
}

public void setQuery(String query) {
	if(query!=null)
	{this.query = query;}
}

public String getErrorMessage() {
	return errorMessage;
}

public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}

public ArrayList<ArrayList<String>> getRecords() {
	return records;
}

public void setRecords(ArrayList<ArrayList<String>> records) {
	if(records!=null)
	{this.records = records;}
}
}
