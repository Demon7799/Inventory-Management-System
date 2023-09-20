package com.ims.model;

import java.util.List;

public class ResponseModel
{
	private int responseCode;
	private String responseMessage;
	private List<?> dataList;
	public int getResponseCode()
	{
		return responseCode;
	}
	public void setResponseCode(int responseCode)
	{
		this.responseCode = responseCode;
	}
	public String getResponseMessage()
	{
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage)
	{
		this.responseMessage = responseMessage;
	}
	public List<?> getDataList()
	{
		return dataList;
	}
	public void setDataList(List<?> dataList)
	{
		this.dataList = dataList;
	}
}
