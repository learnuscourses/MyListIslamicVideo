package com.lerarnus.mylistislamicvideo.Activiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.lerarnus.mylistislamicvideo.R;
public class SettingApp extends AppCompatActivity {
    Switch NightModeSw ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.AppThemeNightMode);
        } else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_app);

        NightModeSw =findViewById(R.id.switchNightModw);

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            NightModeSw.setChecked(true);


        }

        NightModeSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if(isChecked){
                  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                  restApp();
              }else {
                  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                  setTheme(R.style.AppTheme);
                  restApp();

              }
            }

            public void restApp() {
                Intent restapp = new Intent(SettingApp.this,HomeActivity.class);
                startActivity(restapp);
                finish();
            }
        });
    }
}