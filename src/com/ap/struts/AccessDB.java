package com.ap.struts;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class AccessDB {
	private static ResultSet rs;
	private static Statement st;
	private static Connection conn;
	public static void connect2DB(String driver,String url,String username,String password,String query) throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
		conn=(Connection) DriverManager.getConnection(url,username,password);
		st=(Statement) conn.createStatement();
		rs=st.executeQuery(query);
		setRs(rs);
	}
	public ResultSet getRs() {
		return rs;
	}
	public static void setRs(ResultSet rs) {
		AccessDB.rs = rs;
	}
	public static void closeAllConnections(){
		if(AccessDB.rs!=null){
			try {
				AccessDB.rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(AccessDB.st!=null){
			try {
				AccessDB.st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(AccessDB.conn!=null){
			try {
				AccessDB.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static ArrayList<ArrayList<String>> resultSet2arrayList()
	{
		ArrayList<ArrayList<String>> record= new ArrayList<ArrayList<String>>();
		if(rs==null){
			return record;
		}
		try {
			ResultSetMetaData rsmd=rs.getMetaData();
			int columns=rsmd.getColumnCount();
			ArrayList<String> temp=new ArrayList<String>();
			for(int i=1;i<=columns;i++)
			{
				temp.add(rsmd.getColumnName(i));
			}
			record.add(temp);
			int j=1;
			while(rs.next())
			{
				temp=new ArrayList<String>();
				for(int i=1;i<=columns;i++)
				{
					String typeOfColumn = rsmd.getColumnTypeName(i);
					if (typeOfColumn.contains("BLOB") || typeOfColumn.contains("CLOB")){
						temp.add("Image"+j);
					}
					else
					{
						temp.add(rs.getString(i));
					}
				}
				j++;
				record.add(temp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}
}
