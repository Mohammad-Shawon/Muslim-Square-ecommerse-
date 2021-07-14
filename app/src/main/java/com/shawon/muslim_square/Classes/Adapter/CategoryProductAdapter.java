package com.shawon.muslim_square.Classes.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shawon.muslim_square.Classes.Models.productCategoryModel;
import com.shawon.muslim_square.Product.ProductDetailsActivity;
import com.shawon.muslim_square.R;

import java.util.List;

public class CategoryProductAdapter extends BaseAdapter {

    List<productCategoryModel> productCategoryModelList;

    public CategoryProductAdapter(List<productCategoryModel> productCategoryModelList) {
        this.productCategoryModelList = productCategoryModelList;
    }

    @Override
    public int getCount() {
        return productCategoryModelList.size();
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
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_product_slider_layout, null);
            view.setPadding(0, 10, 0, 10);
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            view.setElevation(3);


            ImageView thumbnail = view.findViewById(R.id.horizontalProductSliderImage);
            TextView title = view.findViewById(R.id.horizontalProductSliderName);
            TextView desc = view.findViewById(R.id.horizontalProductSliderDesciption);
            TextView price = view.findViewById(R.id.horizontalProductSliderPrice);

            Glide
                    .with(view.getContext())
                    .load(productCategoryModelList.get(position).getImages())
                    .into(thumbnail);
            title.setText(productCategoryModelList.get(position).getName());
            desc.setText(productCategoryModelList.get(position).getDesc());
            price.setText(productCategoryModelList.get(position).getPrice());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class);
                    intent.putExtra("productTitle", productCategoryModelList.get(position).getName());
                    view.getContext().startActivity(intent);
                }
            });

        } else {
            return convertView;
        }
        return view;
    }
}
