package com.tareq.android.food.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ExtendedIngredient {

	@SerializedName("originalName")
	private String originalName;

	@SerializedName("image")
	private String image;

	@SerializedName("amount")
	private double amount;

	@SerializedName("unit")
	private String unit;

	@SerializedName("measures")
	private Measures measures;

	@SerializedName("nameClean")
	private String nameClean;

	@SerializedName("original")
	private String original;

	@SerializedName("meta")
	private List<Object> meta;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("aisle")
	private String aisle;

	@SerializedName("consistency")
	private String consistency;

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return originalName;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setAmount(double amount){
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setMeasures(Measures measures){
		this.measures = measures;
	}

	public Measures getMeasures(){
		return measures;
	}

	public void setNameClean(String nameClean){
		this.nameClean = nameClean;
	}

	public String getNameClean(){
		return nameClean;
	}

	public void setOriginal(String original){
		this.original = original;
	}

	public String getOriginal(){
		return original;
	}

	public void setMeta(List<Object> meta){
		this.meta = meta;
	}

	public List<Object> getMeta(){
		return meta;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAisle(String aisle){
		this.aisle = aisle;
	}

	public String getAisle(){
		return aisle;
	}

	public void setConsistency(String consistency){
		this.consistency = consistency;
	}

	public String getConsistency(){
		return consistency;
	}
}