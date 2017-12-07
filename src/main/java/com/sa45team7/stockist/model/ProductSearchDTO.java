package com.sa45team7.stockist.model;



public class ProductSearchDTO
{
	private String partNumber;
	private String partName;
	private String brand;
	private String shelfLocation;
	
	
	public ProductSearchDTO()
	{
		super();
	}
	
	
	public String getPartNumber()
	{
		return partNumber;
	}
	
	
	public void setPartNumber(String partNumber)
	{
		this.partNumber = partNumber;
	}
	
	
	public String getPartName()
	{
		return partName;
	}
	
	
	public void setPartName(String partName)
	{
		this.partName = partName;
	}
	
	
	public String getBrand()
	{
		return brand;
	}
	
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	
	public String getShelfLocation()
	{
		return shelfLocation;
	}
	
	
	public void setShelfLocation(String shelfLocation)
	{
		this.shelfLocation = shelfLocation;
	}
	
}
