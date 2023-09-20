package com.ims.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ims.commons.DBConnection;
import com.ims.commons.Queries;
import com.ims.model.ProductModel;
import com.ims.model.ResponseModel;

public class ProductService
{
	Connection con = null;
	CallableStatement callableStmt = null;

	// adding product
	public ResponseModel addProduct(ProductModel productModel)
	{
		ResponseModel response = new ResponseModel();
		try
		{
			con = DBConnection.getConnection();
			callableStmt = con.prepareCall(Queries.usp_addProduct);
			callableStmt.setString(1, productModel.getProductName());
			callableStmt.setFloat(2, productModel.getPrice());
			callableStmt.setInt(3, productModel.getQuantity());
			callableStmt.setString(4, productModel.getAddedBy());
			int resultSet = callableStmt.executeUpdate();

			if (resultSet > 0)
			{
				response.setResponseCode(102);
				response.setResponseMessage(" Product Adding Successfull! ");
			} else
			{
				response.setResponseCode(104);
				response.setResponseMessage(" Due to Client Side Mistake Product Adding Failed! ");
			}
		} catch (Exception ex)
		{
			response.setResponseCode(101);
			response.setResponseMessage(" Exception Occured While Adding Product ");
			ex.printStackTrace();
		} finally
		{
			try
			{
				if (con != null)
					con.close();
				if (callableStmt != null)
					callableStmt.close();
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}

		}
		return response;
	}

	// get All Prodcuts
	public ResponseModel getAllProducts()
	{
		ResponseModel response = new ResponseModel();
		List<ProductModel> list = new ArrayList<>();
		try
		{
			con = DBConnection.getConnection();
			callableStmt = con.prepareCall(Queries.usp_getAllProducts);

			ResultSet rs = callableStmt.executeQuery();

			while (rs.next())
			{
				ProductModel model = new ProductModel();
				model.setProductName(rs.getString("productname"));
				model.setAddedBy(rs.getString("addedby"));
				model.setPrice(rs.getFloat("productprice"));
				model.setQuantity(rs.getInt("productquantity"));
				list.add(model);
			}

			if (list.size() > 0)
			{
				response.setResponseCode(102);
				response.setResponseMessage(" getting all products Successfull! ");
				response.setDataList(list);
			} else
			{
				response.setResponseCode(104);
				response.setResponseMessage(" getting all products Failed! ");
			}
		} catch (Exception ex)
		{
			response.setResponseCode(101);
			response.setResponseMessage(" Exception Occured While getting all products ");
			ex.printStackTrace();
		} finally
		{
			try
			{
				if (con != null)
					con.close();
				if (callableStmt != null)
					callableStmt.close();
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}

		}
		return response;
	}
	
	// get All Prodcuts by name
		public ResponseModel getProductByName(ProductModel pmodel)
		{
			ResponseModel response = new ResponseModel();
			List<ProductModel> list = new ArrayList<>();
			try
			{
				con = DBConnection.getConnection();
				callableStmt = con.prepareCall(Queries.usp_getProductByName);
				callableStmt.setString(1, pmodel.getProductName());
				ResultSet rs = callableStmt.executeQuery();

				while (rs.next())
				{
					ProductModel model = new ProductModel();
					model.setProductName(rs.getString("productname"));
					model.setAddedBy(rs.getString("addedby"));
					model.setPrice(rs.getFloat("productprice"));
					model.setQuantity(rs.getInt("productquantity"));
					list.add(model);
				}

				if (list.size() > 0)
				{
					response.setResponseCode(102);
					response.setResponseMessage(" getting  products Successfull! ");
					response.setDataList(list);
				} else
				{
					response.setResponseCode(104);
					response.setResponseMessage(" getting  products Failed! ");
				}
			} catch (Exception ex)
			{
				response.setResponseCode(101);
				response.setResponseMessage(" Exception Occured While getting products ");
				ex.printStackTrace();
			} finally
			{
				try
				{
					if (con != null)
						con.close();
					if (callableStmt != null)
						callableStmt.close();
				} catch (Exception ex)
				{
					ex.printStackTrace();
				}

			}
			return response;
		}

}
