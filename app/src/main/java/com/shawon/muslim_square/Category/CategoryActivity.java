package com.shawon.muslim_square.Category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.shawon.muslim_square.Classes.Adapter.CategoryProductAdapter;
import com.shawon.muslim_square.Classes.Adapter.GrideProductAdapter;
import com.shawon.muslim_square.Classes.Models.HorizontalproductSliderModel;
import com.shawon.muslim_square.Classes.Models.productCategoryModel;
import com.shawon.muslim_square.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
   ///////////////Verriable////////////////////
    TextView productCategoryTitle;
    GridView productCategoryGrideView;
    CategoryProductAdapter categoryProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activity);

        //////////////////Hooks////////////////////

        //////////////////set category title/////////////////
        productCategoryTitle = findViewById(R.id.productCategoryTitle);
        String catTitle = getIntent().getStringExtra("categoryName");
        productCategoryTitle.setText(catTitle);

        //////////////////end category title/////////////////

        /////////////////set grid view////////////////////
        productCategoryGrideView = findViewById(R.id.productCategoryGrideView);

        List<productCategoryModel> productCategoryModelList = new ArrayList<>();
        productCategoryModelList.add(new productCategoryModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-রোগ-২.jpg", "অন্তরের রোগ", "অন্তরের রোগ", "price: 368 /-"));
        productCategoryModelList.add(new productCategoryModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-আমল-২.jpg", "অন্তরের-আমল", "শাইখ সাকিহ আি-মুনালিদ", "price: 300 /-"));
        productCategoryModelList.add(new productCategoryModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তিম-মুহূর্ত.jpg", "অন্তিম মুহূর্ত", "অন্তিম মুহূর্ত", "price: 150 /-"));
        productCategoryModelList.add(new productCategoryModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-রোগ-২.jpg", "অন্তরের রোগ", "অন্তরের রোগ", "price: 368 /-"));
        productCategoryModelList.add(new productCategoryModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-আমল-২.jpg", "অন্তরের-আমল", "শাইখ সাকিহ আি-মুনালিদ", "300 /-"));
        productCategoryModelList.add(new productCategoryModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তিম-মুহূর্ত.jpg", "অন্তিম মুহূর্ত", "অন্তিম মুহূর্ত", "price: 150 /-"));
        productCategoryModelList.add(new productCategoryModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-রোগ-২.jpg", "অন্তরের রোগ", "অন্তরের রোগ", "price: 368 /-"));
        productCategoryModelList.add(new productCategoryModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-আমল-২.jpg", "অন্তরের-আমল", "শাইখ সাকিহ আি-মুনালিদ", "price: 300 /-"));
        productCategoryModelList.add(new productCategoryModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তিম-মুহূর্ত.jpg", "অন্তিম মুহূর্ত", "অন্তিম মুহূর্ত", "price: 150 /-"));

        categoryProductAdapter = new CategoryProductAdapter(productCategoryModelList);
        productCategoryGrideView.setAdapter(categoryProductAdapter);

        /////////////////end grid view////////////////////



    }
}