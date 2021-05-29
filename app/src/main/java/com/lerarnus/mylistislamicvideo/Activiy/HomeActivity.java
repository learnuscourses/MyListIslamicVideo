package com.lerarnus.mylistislamicvideo.Activiy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.lerarnus.mylistislamicvideo.R;

public class HomeActivity extends AppCompatActivity {

CardView cardone ,cardTwo,cardThree,cardFour,cardFive,cardSix;
Animation cardAnimOne,cardAnimTwo,cardAnimThree,cardAnimFour,cardAnimFive,cardAnimSix,fade_in;
private ImageView ImageLogo;
TextView NumberVersion ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.AppThemeNightMode);
        }else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent FavoriteVideo = new Intent(HomeActivity.this,VideoFulSreen.class);
                FavoriteVideo.putExtra("Link","https://www.youtube.com/embed/xjcbjSUUdFE");
                startActivity(FavoriteVideo);
            }
        });

        DefinedComponent();

        NumberVersion.setText(" الأصدار "+getNumberVersionApp());
        CardOnClickListener();
        DefinedAnimation();
        shwoAnimation();

    }

    private String getNumberVersionApp() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(),0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void CardOnClickListener() {
///  CardTwo

        cardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BestVideo = new Intent(HomeActivity.this,MainActivity.class);
                BestVideo.putExtra("BestVideo",2);
                startActivity(BestVideo);
            }
        });
///  CardThree

        cardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BestVideo = new Intent(HomeActivity.this,MainActivity.class);
                BestVideo.putExtra("BestVideo",1);
                startActivity(BestVideo);
            }
        });
///  CardFour

        cardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SettingApp = new Intent(HomeActivity.this,SettingApp.class);

                startActivity(SettingApp);
            }
        });
////////*****************Card Six *****************************

        cardSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share= new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT,HomeActivity.this.getString(R.string.app_name)+
                        "\n"+"https://play.google.com/store/apps/details?id="
                        +HomeActivity.this.getPackageName());
                Intent.createChooser(share,"مشاركة التطبيق");
                startActivity(share);
            }
        });
    }


    private void shwoAnimation() {
        cardone.setAnimation(cardAnimOne);
        cardTwo.setAnimation(cardAnimTwo);
        cardThree.setAnimation(cardAnimThree);
        cardFour.setAnimation(cardAnimFour);
        cardFive.setAnimation(cardAnimFive);
        cardSix.setAnimation(cardAnimSix);

        ImageLogo.setAnimation(fade_in);

    }

    private void DefinedAnimation() {
        cardAnimOne =AnimationUtils.loadAnimation(this,R.anim.onecard);
        cardAnimTwo =AnimationUtils.loadAnimation(this,R.anim.twocard);
        cardAnimThree =AnimationUtils.loadAnimation(this,R.anim.threecard);
        cardAnimFour =AnimationUtils.loadAnimation(this,R.anim.fourcard);
        cardAnimFive =AnimationUtils.loadAnimation(this,R.anim.fivecard);
        cardAnimSix =AnimationUtils.loadAnimation(this,R.anim.sixcard);

        fade_in=AnimationUtils.loadAnimation(this,R.anim.fade_in);

    }

    private void DefinedComponent() {
        cardone=(CardView)findViewById(R.id.oneCard);
        cardTwo=(CardView)findViewById(R.id.TwoCard);
        cardThree=(CardView)findViewById(R.id.ThreeCard);
        cardFour=(CardView)findViewById(R.id.FourCard);
        cardFive=(CardView)findViewById(R.id.FiveCard);
        cardSix=(CardView)findViewById(R.id.SixCard);

        ImageLogo = findViewById(R.id.ChannelImage);
        NumberVersion = findViewById(R.id.NumberVersion);

    }


}