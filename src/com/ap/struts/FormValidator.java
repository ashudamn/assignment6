package com.ap.struts;

public class FormValidator {
	private String message;
	public FormValidator()
	{
		
	}
	public boolean validate(String driver,String url,String username,String password,String query)
	{
		if(driver==null||driver.isEmpty())
		{
			setMessage("driver name is required");
			return false;
		}
		if(url==null||url.isEmpty())
		{
			setMessage("url is required");
			return false;
		}
		if(username==null||username.isEmpty())
		{
			setMessage("username is required");
			return false;
		}
		if(password==null||password.isEmpty())
		{
			setMessage("password is required");
			return false;
		}
		if(query==null||query.isEmpty())
		{
			setMessage("query cannot be empty");
			return false;
		}
		
			/*if(error.contains("ClassNotFound"))
			{
				setMessage("Incorrect Driver");
				return false;
			}
			if(error.contains("No suitable driver found"))
			{
				setMessage("Something wrong with url, system cannot access it with current driver");
				return false;
			}
			if(error.contains("Access denied for user"))
			{
				setMessage("Something wrong with username or password, Enter correct username, password");
				return false;
			}
			if(error.contains("MySQLSyntaxErrorException"))
			{
				setMessage("Something wrong with your Query check syntax and enter correct query");
				return false;
			}
			if(error.contains("No tables used"))
			{
				setMessage("Mention tables in your query ");
				return false;
			}
			else
			{
				setMessage(e.toString());
			}
			*/
		
		return true;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
