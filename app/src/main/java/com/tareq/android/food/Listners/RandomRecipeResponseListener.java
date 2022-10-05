package com.tareq.android.food.Listners;

import com.tareq.android.food.Models.RandomRecipeApiResponse;

public interface RandomRecipeResponseListener {
    void didFetch(RandomRecipeApiResponse response,String message);
    void didError(String message);
}
