package com.tareq.android.food.Models;

import com.google.gson.annotations.SerializedName;

public class Us{

	@SerializedName("amount")
	private double amount;

	@SerializedName("unitShort")
	private String unitShort;

	@SerializedName("unitLong")
	private String unitLong;

	public void setAmount(double amount){
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public void setUnitShort(String unitShort){
		this.unitShort = unitShort;
	}

	public String getUnitShort(){
		return unitShort;
	}

	public void setUnitLong(String unitLong){
		this.unitLong = unitLong;
	}

	public String getUnitLong(){
		return unitLong;
	}
}