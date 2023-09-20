package com.ims.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ims.commons.DBConnection;
import com.ims.commons.Queries;
import com.ims.model.SalesModel;
import com.ims.model.ResponseModel;

public class SalesService
{
	Connection con = null;
	CallableStatement callableStmt = null;

	// adding product
	public ResponseModel addSale(SalesModel SalesModel)
	{
		ResponseModel response = new ResponseModel();
		try
		{
			con = DBConnection.getConnection();
			callableStmt = con.prepareCall(Queries.usp_addSale);
			callableStmt.setString(3, SalesModel.getProductName());
			callableStmt.setFloat(5, SalesModel.getPrice());
			callableStmt.setInt(4, SalesModel.getQuantity());
			callableStmt.setString(1, SalesModel.getPurchasedBy());
			callableStmt.setString(2, SalesModel.getSoldBy());
			
			int resultSet = callableStmt.executeUpdate();

			if (resultSet > 0)
			{
				response.setResponseCode(102);
				response.setResponseMessage(" Sales Adding Successfull! ");
			} else
			{
				response.setResponseCode(104);
				response.setResponseMessage(" Due to Client Side Mistake Sales Adding Failed! ");
			}
		} catch (Exception ex)
		{
			response.setResponseCode(101);
			response.setResponseMessage(" Exception Occured While Adding Sales ");
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
	public ResponseModel getAllSales()
	{
		ResponseModel response = new ResponseModel();
		List<SalesModel> list = new ArrayList<>();
		try
		{
			con = DBConnection.getConnection();
			callableStmt = con.prepareCall(Queries.usp_getAllSales);

			ResultSet rs = callableStmt.executeQuery();

			while (rs.next())
			{
				SalesModel model = new SalesModel();
				model.setProductName(rs.getString("productname"));
				model.setPurchasedBy(rs.getString("purchasedby"));
				model.setPrice(rs.getFloat("productprice"));
				model.setQuantity(rs.getInt("productquantity"));
				model.setSoldBy(rs.getString("soldby"));
				model.setTotalPrice(rs.getString("totalprice"));
				list.add(model);
			}

			if (list.size() > 0)
			{
				response.setResponseCode(102);
				response.setResponseMessage(" getting all Sales Successfull! ");
				response.setDataList(list);
			} else
			{
				response.setResponseCode(104);
				response.setResponseMessage(" getting all Sales Failed! ");
			}
		} catch (Exception ex)
		{
			response.setResponseCode(101);
			response.setResponseMessage(" Exception Occured While getting all Sales ");
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
