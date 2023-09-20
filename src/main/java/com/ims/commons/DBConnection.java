package com.ims.commons;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root","abhi");			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return con;
	}
}
