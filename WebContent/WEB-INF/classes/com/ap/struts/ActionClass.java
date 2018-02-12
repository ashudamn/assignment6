package com.ap.struts;

public class ActionClass {
private String driver,url,username,password,query;
public String execute(){
	
	FormValidator fv=new FormValidator();
	if(fv.validate(driver, url, username, password, query))
	{
		//display table in success page
		return "success";
	}
	//go to form page again with an error message
	System.out.println(fv.getMessage());
	return "failure";
	}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getDriver() {
	return driver;
}

public void setDriver(String driver) {
	this.driver = driver;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getQuery() {
	return query;
}

public void setQuery(String query) {
	this.query = query;
}
}
