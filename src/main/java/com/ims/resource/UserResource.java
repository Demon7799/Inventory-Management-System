package com.ims.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ims.model.ResponseModel;
import com.ims.model.UserModel;
import com.ims.service.UserService;

@Path("user")
public class UserResource
{
	@POST
	@Path("register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseModel registerUser(UserModel userModel)
	{
		ResponseModel response = new ResponseModel();
		try
		{
			if(userModel.getMail()==null || userModel.getMail().isEmpty())
			{
				response.setResponseCode(108);
				response.setResponseMessage(" Mail Id is Required ");
			}
			else if(userModel.getPassword()==null || userModel.getPassword().isEmpty())
			{
				response.setResponseCode(108);
				response.setResponseMessage(" Password is Required ");
			}
			else
				response = new UserService().registerUser(userModel);
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		return response;
	}
	@GET
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel userLogin(UserModel userModel)
	{
		ResponseModel response = new ResponseModel();
		try
		{
			if(userModel.getMail()==null || userModel.getMail().isEmpty())
			{
				response.setResponseCode(108);
				response.setResponseMessage(" Mail Id is Required ");
			}
			else if(userModel.getPassword()==null || userModel.getPassword().isEmpty())
			{
				response.setResponseCode(108);
				response.setResponseMessage(" Password is Required ");
			}
			else
				response = new UserService().userLogin(userModel);
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		return response;
	}
}
