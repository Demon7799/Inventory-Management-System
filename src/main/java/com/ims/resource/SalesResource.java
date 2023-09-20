package com.ims.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ims.model.SalesModel;
import com.ims.model.ResponseModel;
import com.ims.service.SalesService;

@Path("sales")
public class SalesResource
{
	@POST
	@Path("addSale")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseModel registerUser(SalesModel SalesModel)
	{
		ResponseModel response = new ResponseModel();
		try
		{
				response = new SalesService().addSale(SalesModel);
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		return response;
	}
	
	@GET
	@Path("getAllSales")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseModel getAllProducts()
	{
		ResponseModel response = new ResponseModel();
		try
		{
				response = new SalesService().getAllSales();
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		return response;
	}
}
