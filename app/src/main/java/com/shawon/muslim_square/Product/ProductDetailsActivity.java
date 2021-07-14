package com.shawon.muslim_square.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.shawon.muslim_square.Classes.Adapter.productDetailsImagesAdapter;
import com.shawon.muslim_square.Classes.Models.productDetailsImagesModel;
import com.shawon.muslim_square.R;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    //////////////////Varriable////////////////

    ViewPager productImageViewPager;
    TabLayout productDetailsIndicator;
    TextView productDetailsTitle,pd_Title;
    FloatingActionButton pdFevButton;

    boolean ALREADY_ADDED_WISHLISH = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        String name = getIntent().getStringExtra("productTitle");



        ///////////////////// Start Product details image//////////////////////

        productImageViewPager = findViewById(R.id.productDetailsImageViewPager);
        productDetailsIndicator = findViewById(R.id.productDetailsIndicator);
        pdFevButton = findViewById(R.id.pd_fev_button);
        pd_Title = findViewById(R.id.pd_Title);


        pd_Title.setText(name);

        pdFevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ALREADY_ADDED_WISHLISH){
                    ALREADY_ADDED_WISHLISH = false;
                    pdFevButton.setSupportImageTintList(getResources().getColorStateList(R.color.Accent));


                }else {
                    ALREADY_ADDED_WISHLISH = true;
                    pdFevButton.setSupportImageTintList(getResources().getColorStateList(R.color.Primary));

                }
            }
        });

       setImages();

        ///////////////////// End Product details image//////////////////////

    }

   /////////////////// Set Image function //////////////////

    private void setImages() {

        List<productDetailsImagesModel> productDetailsImageList = new ArrayList<>();

        productDetailsImageList.add(new productDetailsImagesModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তিম-মুহূর্ত.jpg"));
        productDetailsImageList.add(new productDetailsImagesModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-রোগ-১.jpg"));

        productDetailsImagesAdapter productDetailsImagesadapter = new productDetailsImagesAdapter(productDetailsImageList);
        productImageViewPager.setAdapter(productDetailsImagesadapter);

        productDetailsIndicator.setupWithViewPager(productImageViewPager,true);
    }

   /////////////////// End Image function //////////////////
}