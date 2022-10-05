package com.tareq.android.food.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AnalyzedInstructionsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("steps")
	private List<Step> steps;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSteps(List<Step> steps){
		this.steps = steps;
	}

	public List<Step> getSteps(){
		return steps;
	}
}