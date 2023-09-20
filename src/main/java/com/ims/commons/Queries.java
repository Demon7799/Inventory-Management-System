package com.ims.commons;

public class Queries
{
	//user registration
	public static String usp_registerUser = "{call usp_registerUser(?,?,?)}";

	//user login
	public static String usp_userLogin = "{call usp_userLogin(?,?)}";
	
	// add product
	public static String usp_addProduct = "{call usp_addProdcut(?,?,?,?)}";
	
	// get all products
	public static String usp_getAllProducts = "{call usp_getAllProducts()}";
	
	// get product by name
	public static String usp_getProductByName = "{call usp_getProdcutByName(?)}";
	
	//add sale
	public static String usp_addSale = "{call usp_addSale(?,?,?,?,?)}";
	
	//get sales
	public static String usp_getAllSales = "{call usp_getAllSales()}";
}
