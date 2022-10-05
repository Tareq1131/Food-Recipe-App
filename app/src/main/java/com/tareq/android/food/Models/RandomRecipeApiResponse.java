package com.tareq.android.food.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RandomRecipeApiResponse {

	@SerializedName("recipes")
	private List<Recipe> recipes;

	public void setRecipes(List<Recipe> recipes){
		this.recipes = recipes;
	}

	public List<Recipe> getRecipes(){
		return recipes;
	}



}