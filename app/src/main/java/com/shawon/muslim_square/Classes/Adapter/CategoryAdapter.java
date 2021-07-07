package com.shawon.muslim_square.Classes.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shawon.muslim_square.Category.CategoryActivity;
import com.shawon.muslim_square.Classes.Models.CategoryModel;
import com.shawon.muslim_square.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryHolder> {

    List<CategoryModel> categoryModelList;

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public categoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_recyler_layout,parent,false);
        return new categoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.categoryHolder holder, int position) {
        String icon = categoryModelList.get(position).getCategoryIconLink();
        String title = categoryModelList.get(position).getCategoryTitle();
        Glide
                .with(holder.imageView.getContext())
                .load(icon)
                .into(holder.imageView);
        holder.textView.setText(title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 0){
                    Intent categoryIntent = new Intent(holder.itemView.getContext(),CategoryActivity.class);
                    categoryIntent.putExtra("categoryName",title);
                    holder.itemView.getContext().startActivity(categoryIntent);
                }
            }
        });
    }




    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    class categoryHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
         public categoryHolder(@NonNull View itemView) {
             super(itemView);

             imageView = itemView.findViewById(R.id.category_thumbnail);
             textView = itemView.findViewById(R.id.category_title);

         }

     }
}



