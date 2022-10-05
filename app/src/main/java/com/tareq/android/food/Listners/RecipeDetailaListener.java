package com.tareq.android.food.Listners;

import com.tareq.android.food.Models.RecipeDetailsResponse;

public interface RecipeDetailaListener {
    void didFetch(RecipeDetailsResponse response,String message);
    void didError(String message);
}
