package com.shawon.muslim_square.Store;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.shawon.muslim_square.Classes.Adapter.CategoryAdapter;
import com.shawon.muslim_square.Classes.Adapter.GrideProductAdapter;
import com.shawon.muslim_square.Classes.Adapter.HorizontalproductSliderAdapter;
import com.shawon.muslim_square.Classes.Models.CategoryModel;
import com.shawon.muslim_square.Classes.Models.HorizontalproductSliderModel;
import com.shawon.muslim_square.R;

import java.util.ArrayList;
import java.util.List;


public class StoreFragment extends Fragment {
    // Varriable
    RecyclerView categoryRecler;
    CategoryAdapter categoryAdapter;
    RecyclerView horizontalRecyler;

    HorizontalproductSliderAdapter hAdapter;
    GrideProductAdapter grideProductAdapter;
    GridView grideProductView;
    ImageSlider slider;
    Button ViewAll,GrideViewAll;
    RecyclerView homeRecyler;


    List<HorizontalproductSliderModel> horizontalproductSliderModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);


        //////////////////////////////Hooks///////////////////////////
        slider = view.findViewById(R.id.image_slider);


        //////////////////Category///////////////
        categoryRecler = view.findViewById(R.id.category_recyler_view);

        List<CategoryModel> catList = new ArrayList<>();
        catList.add(new CategoryModel("https://image.flaticon.com/icons/png/512/1946/1946488.png", "Home"));
        catList.add(new CategoryModel("https://image.flaticon.com/icons/png/512/2777/2777142.png", "Electronics"));
        catList.add(new CategoryModel("https://image.flaticon.com/icons/png/512/864/864685.png", "Books"));
        catList.add(new CategoryModel("https://image.flaticon.com/icons/png/512/15/15874.png", "Mobile"));
        catList.add(new CategoryModel("https://image.flaticon.com/icons/png/512/2533/2533267.png", "Gadget"));

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        categoryRecler.setLayoutManager(manager);
        categoryAdapter = new CategoryAdapter(catList);
        categoryRecler.setAdapter(categoryAdapter);
        //////////////////Category///////////////


        ///////////////////Horizontal product//////////////////
        horizontalRecyler = view.findViewById(R.id.horizontalproductRecylerView);
        ViewAll = view.findViewById(R.id.horizontalproductViewAllBtn);

        LinearLayoutManager horizontalproductMngr = new LinearLayoutManager(getContext());
        horizontalproductMngr.setOrientation(RecyclerView.HORIZONTAL);
        horizontalRecyler.setLayoutManager(horizontalproductMngr);

        horizontalProduct();
        ///////////////////Horizontal product//////////////////

        ///////////////////Gride product/////////////////////
        GrideViewAll = view.findViewById(R.id.grideproductViewAllBtn);
        grideProductView = view.findViewById(R.id.grideProductView);
        grideProductAdapter = new GrideProductAdapter(horizontalproductSliderModelList);
        grideProductView.setAdapter(grideProductAdapter);
        ///////////////////Gride product/////////////////////



        ///////////////Call function//////////////////////////
        setSlider();

        return view;
    }




    //////////////////////////Set slider/////////////////////////
    public void setSlider() {
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://muslim-square.com/wp-content/uploads/2021/07/MS-Web-Banner-2-scaled.jpg", null));
        slideModels.add(new SlideModel("https://muslim-square.com/wp-content/uploads/2021/07/MS-Web-Banner-scaled.jpg", null));
        slider.setImageList(slideModels, ScaleTypes.FIT);
    }

    ///////////////////Horizontal product////////////////////////
    public void horizontalProduct() {

        horizontalproductSliderModelList = new ArrayList<>();

        horizontalproductSliderModelList.add(new HorizontalproductSliderModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-রোগ-২.jpg", "অন্তরের রোগ", "অন্তরের রোগ", "price: 368 /-"));
        horizontalproductSliderModelList.add(new HorizontalproductSliderModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-আমল-২.jpg", "অন্তরের-আমল", "শাইখ সাকিহ আি-মুনালিদ", "price: 300 /-"));
        horizontalproductSliderModelList.add(new HorizontalproductSliderModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তিম-মুহূর্ত.jpg", "অন্তিম মুহূর্ত", "অন্তিম মুহূর্ত", "price: 150 /-"));
        horizontalproductSliderModelList.add(new HorizontalproductSliderModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-রোগ-২.jpg", "অন্তরের রোগ", "অন্তরের রোগ", "price: 368 /-"));
        horizontalproductSliderModelList.add(new HorizontalproductSliderModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-আমল-২.jpg", "অন্তরের-আমল", "শাইখ সাকিহ আি-মুনালিদ", "300 /-"));
        horizontalproductSliderModelList.add(new HorizontalproductSliderModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তিম-মুহূর্ত.jpg", "অন্তিম মুহূর্ত", "অন্তিম মুহূর্ত", "price: 150 /-"));
        horizontalproductSliderModelList.add(new HorizontalproductSliderModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-রোগ-২.jpg", "অন্তরের রোগ", "অন্তরের রোগ", "price: 368 /-"));
        horizontalproductSliderModelList.add(new HorizontalproductSliderModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তরের-আমল-২.jpg", "অন্তরের-আমল", "শাইখ সাকিহ আি-মুনালিদ", "price: 300 /-"));
        horizontalproductSliderModelList.add(new HorizontalproductSliderModel("https://muslim-square.com/wp-content/uploads/2018/01/অন্তিম-মুহূর্ত.jpg", "অন্তিম মুহূর্ত", "অন্তিম মুহূর্ত", "price: 150 /-"));

        if (horizontalproductSliderModelList.size() > 8){
            ViewAll.setVisibility(View.VISIBLE);
        }

        hAdapter = new HorizontalproductSliderAdapter(horizontalproductSliderModelList);
        horizontalRecyler.setAdapter(hAdapter);
    }

}