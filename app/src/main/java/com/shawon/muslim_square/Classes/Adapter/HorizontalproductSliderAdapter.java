package com.shawon.muslim_square.Classes.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shawon.muslim_square.Classes.Models.HorizontalproductSliderModel;
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
        String nameh = list.get(position).getName();
        String desch = list.get(position).getDesc();
        String priceh = list.get(position).getPrice();

        ////////////Set data in elements////////////
        Glide
                .with(holder.thumnail.getContext())
                .load(image)
                .into(holder.thumnail);

        holder.name.setText(nameh);
        holder.desc.setText(desch);
        holder.price.setText(priceh);
        
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
