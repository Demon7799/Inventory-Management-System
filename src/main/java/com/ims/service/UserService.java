package com.ims.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ims.commons.DBConnection;
import com.ims.commons.Queries;
import com.ims.model.ResponseModel;
import com.ims.model.UserModel;

public class UserService
{
	Connection con=null;
	CallableStatement  callableStmt=null;
	
	//user registration
	public ResponseModel registerUser(UserModel userModel) 
	{
		ResponseModel response = new ResponseModel();
		try
		{
			con=DBConnection.getConnection();
			callableStmt = con.prepareCall(Queries.usp_registerUser);
			callableStmt.setString(1, userModel.getName());
			callableStmt.setString(2,userModel.getMail());
			callableStmt.setString(3,userModel.getPassword());
			
			int resultSet = callableStmt.executeUpdate();
			
			if(resultSet >0)
			{
				response.setResponseCode(102);
				response.setResponseMessage(" User Registration Successfull! ");
			}
			else
			{
				response.setResponseCode(104);
				response.setResponseMessage(" Due to Client Side Mistake User Registration Failed! ");
			}
		}
		catch(Exception ex)
		{
			response.setResponseCode(101);
			response.setResponseMessage(" Exception Occured While Registering User ");
			ex.printStackTrace();
		}
		finally
		{
			try {
				if(con!=null)
					con.close();
				if(callableStmt !=null)
					callableStmt.close();
			}catch(Exception ex) {ex.printStackTrace();}
			
		}
		return response;
	}
	
	
	//user login
	public ResponseModel userLogin(UserModel userModel) 
	{
		ResponseModel response = new ResponseModel();
		try
		{
			List<UserModel> list = new ArrayList<>();
			con=DBConnection.getConnection();
			callableStmt = con.prepareCall(Queries.usp_userLogin);
			callableStmt.setString(1,userModel.getMail());
			callableStmt.setString(2,userModel.getPassword());
			
			ResultSet resultSet = callableStmt.executeQuery();
			
			while(resultSet.next())
			{
				UserModel model = new UserModel();
				model.setName(resultSet.getString("username"));
				model.setMail(resultSet.getString("usermail"));
				list.add(model);
			}
			
			if(list.size() >0)
			{
				response.setResponseCode(102);
				response.setResponseMessage(" User Login Successfull! ");
			}
			else
			{
				response.setResponseCode(104);
				response.setResponseMessage(" Due to Invalid Credentials User Login Failed! ");
			}
		}
		catch(Exception ex)
		{
			response.setResponseCode(101);
			response.setResponseMessage(" Exception Occured While User Login ");
			ex.printStackTrace();
		}
		finally
		{
			try {
				if(con!=null)
					con.close();
				if(callableStmt !=null)
					callableStmt.close();
			}catch(Exception ex) {ex.printStackTrace();}
			
		}
		return response;
	}
	
}
