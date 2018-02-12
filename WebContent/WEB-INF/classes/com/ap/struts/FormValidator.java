package com.ap.struts;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FormValidator {
	private static String message;
	private ResultSet rs;
	FormValidator()
	{
		
	}
	public boolean validate(String driver,String url,String username,String password,String query)
	{
		if(driver.isEmpty())
		{
			setMessage("driver name is required");
			return false;
		}
		if(url.isEmpty())
		{
			setMessage("url is required");
			return false;
		}
		if(username.isEmpty())
		{
			setMessage("username is required");
			return false;
		}
		if(password.isEmpty())
		{
			setMessage("password is required");
		}
		if(query.isEmpty())
		{
			setMessage("query cannot be empty");
		}
		try {
			//accessing Database
			Class.forName(driver);
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			Statement st=(Statement) conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			setRs(rs);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			setMessage(e.toString());
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		FormValidator.message = message;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
}
