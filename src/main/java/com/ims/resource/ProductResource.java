package com.ims.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ims.model.ProductModel;
import com.ims.model.ResponseModel;
import com.ims.service.ProductService;

@Path("product")
public class ProductResource
{
	@POST
	@Path("addProduct")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseModel registerUser(ProductModel productModel)
	{
		ResponseModel response = new ResponseModel();
		try
		{
				response = new ProductService().addProduct(productModel);
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		return response;
	}
	
	@GET
	@Path("getAllProdcuts")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseModel getAllProducts(ProductModel productModel)
	{
		ResponseModel response = new ResponseModel();
		try
		{
				response = new ProductService().getAllProducts();
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		return response;
	}
	
	@GET
	@Path("getProdcutByName")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseModel getProductByName(ProductModel productModel)
	{
		ResponseModel response = new ResponseModel();
		try
		{
				response = new ProductService().getProductByName(productModel);
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		return response;
	}
}
