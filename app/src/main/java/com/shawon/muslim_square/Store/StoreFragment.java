package com.shawon.muslim_square.Store;

import android.graphics.Matrix;
import android.icu.number.Scale;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.shawon.muslim_square.Classes.Adapter.CategoryAdapter;
import com.shawon.muslim_square.Classes.Models.CategoryModel;
import com.shawon.muslim_square.R;

import java.util.ArrayList;
import java.util.List;


public class StoreFragment extends Fragment {
    // Varriable
    RecyclerView categoryRecler;
    CategoryAdapter categoryAdapter;
    ImageSlider slider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);


        //Hooks
        categoryRecler = view.findViewById(R.id.category_recyler_view);
        slider = view.findViewById(R.id.image_slider);



        //set layout manager
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        categoryRecler.setLayoutManager(manager);


        //Call function
         setCategory();
         setSlider();




        return view;
    }

    //set category
    private void setCategory() {
        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel("link","Home"));
        list.add(new CategoryModel("link","Electronics"));
        list.add(new CategoryModel("link","Books"));
        list.add(new CategoryModel("link","Mobile"));
        list.add(new CategoryModel("link","Gadget"));
        list.add(new CategoryModel("link","Other"));
        list.add(new CategoryModel("link","Fashion and beauty"));

        categoryAdapter = new CategoryAdapter(list);
        categoryRecler.setAdapter(categoryAdapter);
    }
    //Set slider
    public void setSlider(){
        List<SlideModel> slideModels = new ArrayList<>();
       slideModels.add(new SlideModel(R.drawable.japan,null,ScaleTypes.FIT));
       slideModels.add(new SlideModel(R.drawable.a,null,ScaleTypes.FIT));
       slideModels.add(new SlideModel(R.drawable.slider,null));
       slideModels.add(new SlideModel(R.drawable.b,null));
       slideModels.add(new SlideModel(R.drawable.c,null));
       slideModels.add(new SlideModel(R.drawable.d,null));

       slider.setImageList(slideModels,ScaleTypes.FIT);
    }
}