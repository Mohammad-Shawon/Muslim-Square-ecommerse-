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
import com.shawon.muslim_square.Classes.Models.HorizontalproductSliderModel;
import com.shawon.muslim_square.Product.ProductDetailsActivity;
import com.shawon.muslim_square.R;

import java.util.List;

public class HorizontalproductSliderAdapter extends RecyclerView.Adapter<HorizontalproductSliderAdapter.Viewholder> {

    List<HorizontalproductSliderModel> list;

    public HorizontalproductSliderAdapter(List<HorizontalproductSliderModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_product_slider_layout,parent,false);
        return  new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalproductSliderAdapter.Viewholder holder, int position) {
        ////////////// Get data from model//////////
        String image = list.get(position).getImage();
        String name = list.get(position).getName();
        String desc = list.get(position).getDesc();
        String price = list.get(position).getPrice();

        ////////////Set data in elements////////////
        Glide
                .with(holder.thumnail.getContext())
                .load(image)
                .into(holder.thumnail);

        holder.name.setText(name);
        holder.desc.setText(desc);
        holder.price.setText(price);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ProductDetailsActivity.class);
                intent.putExtra("productTitle",name);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        
    }

    @Override
    public int getItemCount() {
        if (list.size() > 8){
            return 8;
        }else {
            return list.size();
        }
    }

    class Viewholder extends RecyclerView.ViewHolder {
        ImageView thumnail;
        TextView name,desc,price;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            thumnail = itemView.findViewById(R.id.horizontalProductSliderImage);
            name = itemView.findViewById(R.id.horizontalProductSliderName);
            desc = itemView.findViewById(R.id.horizontalProductSliderDesciption);
            price = itemView.findViewById(R.id.horizontalProductSliderPrice);
        }
    }
}
