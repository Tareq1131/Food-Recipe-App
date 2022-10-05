package com.tareq.android.food.Listners;

import com.tareq.android.food.Models.SimilarRecipeResponse;

import java.util.List;

public interface SimilarRecipesListener {
    void didFetch(List<SimilarRecipeResponse> responses,String message);
    void didError(String message);
}
