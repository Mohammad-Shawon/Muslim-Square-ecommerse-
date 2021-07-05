package com.shawon.muslim_square.Store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.shawon.muslim_square.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoreActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //varriable
    ImageView toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    LinearLayout storeContainer;
    FrameLayout storeFrameLayout;

    //Extra string
    static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_store);

        //Hooks
        toolbar = findViewById(R.id.tollbar);
        navigationView = findViewById(R.id.storeNavView);
        drawerLayout = findViewById(R.id.storeDraweView);
        storeContainer = findViewById(R.id.storeContainer);

        storeFrameLayout = findViewById(R.id.storeFrameLayout);



        //open close nav drawer
        navigationDrawar();

        setStoreFragment(new StoreFragment());
    }

    //navigation drawer
    private void navigationDrawar() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_gift);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        navigationAnimation();
    }

    //navigation animation
    private void navigationAnimation() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                storeContainer.setScaleX(offsetScale);
                storeContainer.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = storeContainer.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                storeContainer.setTranslationX(xTranslation);
            }
        });
    }

    //nav item selcter
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_shop:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }

        return true;
    }

    //back press method
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //set fragment
    public void setStoreFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(storeFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}