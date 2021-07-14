package com.shawon.muslim_square.Classes.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shawon.muslim_square.Classes.Models.HorizontalproductSliderModel;
import com.shawon.muslim_square.Product.ProductDetailsActivity;
import com.shawon.muslim_square.R;

import java.io.Serializable;
import java.util.List;

import static com.shawon.muslim_square.R.drawable.gride_product_bg;
import static java.lang.String.valueOf;

public class GrideProductAdapter extends BaseAdapter {

    List<HorizontalproductSliderModel> list;

    public GrideProductAdapter(List<HorizontalproductSliderModel> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if ( convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_product_slider_layout,null);
            view.setPadding(0,10,0,10);
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            view.setElevation(3);

            ImageView thumbail = view.findViewById(R.id.horizontalProductSliderImage);
            TextView name = view.findViewById(R.id.horizontalProductSliderName);
            TextView desc = view.findViewById(R.id.horizontalProductSliderDesciption);
            TextView price = view.findViewById(R.id.horizontalProductSliderPrice);

            Glide
                    .with(view.getContext())
                    .load(list.get(position).getImage())
                    .into(thumbail);
            name.setText(list.get(position).getName());
            desc.setText(list.get(position).getDesc());
            price.setText(list.get(position).getPrice());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class);
                    intent.putExtra("productTitle",  list.get(position).getName());
                    view.getContext().startActivity(intent);
                }
            });

        }else {
            return convertView;
        }
       return view;

    }
}
