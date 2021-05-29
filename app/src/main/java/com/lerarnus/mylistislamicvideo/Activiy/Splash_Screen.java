package com.lerarnus.mylistislamicvideo.Activiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.lerarnus.mylistislamicvideo.R;

public class Splash_Screen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 12000;
    private ImageView logo  ,youtube ;
    Animation logoAnimation ,youtubeAnamation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash__screen);

        logo= findViewById(R.id.LogoChannel);
        youtube= findViewById(R.id.animationView);

        logoAnimation = AnimationUtils.loadAnimation(this,R.anim.up_to_down_alpha);
        youtubeAnamation = AnimationUtils.loadAnimation(this,R.anim.alpha);


        logo.startAnimation(logoAnimation);
        youtube.startAnimation(youtubeAnamation);

        logo.animate()
            .translationY(-1600)
            .setDuration(7000)
            .setStartDelay(8000);

        youtube.animate()
                .translationY(1600)
                .setDuration(7000)
                .setStartDelay(8000);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(new Intent(Splash_Screen.this,HomeActivity.class));
            }
        },SPLASH_SCREEN);
    }
}