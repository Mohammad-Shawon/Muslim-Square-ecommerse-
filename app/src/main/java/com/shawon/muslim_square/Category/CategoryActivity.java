package com.shawon.muslim_square.Category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.shawon.muslim_square.R;

public class CategoryActivity extends AppCompatActivity {
    TextView catName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activity);
        catName = findViewById(R.id.catName);
        String catename = getIntent().getStringExtra("categoryName");
        catName.setText(catename);
    }
}