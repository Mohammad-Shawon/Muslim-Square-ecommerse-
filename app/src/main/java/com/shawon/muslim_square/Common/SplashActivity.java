package com.shawon.muslim_square.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shawon.muslim_square.Store.StoreActivity;
import com.shawon.muslim_square.R;

public class SplashActivity extends AppCompatActivity {

    //Verriable
    private ImageView splashImage;
    private TextView splashTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hooks
        splashImage = findViewById(R.id.splashImage);
        splashTitle = findViewById(R.id.splashTitle);


        //Set Animation
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_screen_anim);
        splashImage.setAnimation(animation);
        splashTitle.setAnimation(animation);

        //Set timer
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), StoreActivity.class));
                finish();
            }
        },3000);

    }
}