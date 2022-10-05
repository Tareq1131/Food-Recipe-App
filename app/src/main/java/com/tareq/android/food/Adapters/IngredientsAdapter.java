package com.tareq.android.food.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tareq.android.food.Models.ExtendedIngredient;
import com.tareq.android.food.R;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsViewHolder> {

    Context context;
    List<ExtendedIngredient> list;

    public IngredientsAdapter(Context context, List<ExtendedIngredient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IngredientsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_meal_ingredient,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
  holder.textView_ingredients_name.setText(list.get(position).getName());
  holder.textView_ingredients_name.setSelected(true);
  holder.textView_ingredients_quantity.setText(list.get(position).getOriginal());
  holder.textView_ingredients_quantity.setSelected(true);
      // Picasso.get().load(list.get(position).getImage()).into(holder.imageView_ingredients);
  Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/"+list
        .get(position).getImage()).into(holder.imageView_ingredients);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class IngredientsViewHolder extends RecyclerView.ViewHolder{
    TextView textView_ingredients_quantity, textView_ingredients_name;
    ImageView imageView_ingredients;
    public IngredientsViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_ingredients_quantity=itemView.findViewById(R.id.textView_ingredients_quantity);
        textView_ingredients_name=itemView.findViewById(R.id.textView_ingredients_name);
        imageView_ingredients=itemView.findViewById(R.id.imageView_ingredients);
    }

}
