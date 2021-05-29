package com.lerarnus.mylistislamicvideo.Activiy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lerarnus.mylistislamicvideo.R;

public class VideoFulSreen extends AppCompatActivity {
WebView webViewFullScreen ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video_ful_sreen);

        webViewFullScreen=findViewById(R.id.FullscreenPage);
        String myLink= getIntent().getStringExtra("Link");

        webViewFullScreen.loadUrl(myLink);
        webViewFullScreen.setWebViewClient(new WebViewClient());
        webViewFullScreen.setWebChromeClient(new WebChromeClient());
        webViewFullScreen.getSettings().setJavaScriptEnabled(true);
    }
}
