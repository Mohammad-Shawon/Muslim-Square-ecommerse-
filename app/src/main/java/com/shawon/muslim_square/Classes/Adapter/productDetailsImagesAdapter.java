package com.shawon.muslim_square.Classes.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.shawon.muslim_square.Classes.Models.productDetailsImagesModel;

import java.util.List;

public class productDetailsImagesAdapter extends PagerAdapter {

    List<productDetailsImagesModel> productDetailsImageList;

    public productDetailsImagesAdapter(List<productDetailsImagesModel> productDetailsImageList) {
        this.productDetailsImageList = productDetailsImageList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        Glide
                .with(container.getContext())
                .load(productDetailsImageList.get(position).getImages())
                .into(imageView);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }

    @Override
    public int getCount() {
        return productDetailsImageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
