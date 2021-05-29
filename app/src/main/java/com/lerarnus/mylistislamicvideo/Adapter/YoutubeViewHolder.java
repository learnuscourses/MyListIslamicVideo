package com.lerarnus.mylistislamicvideo.Adapter;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lerarnus.mylistislamicvideo.R;

public class YoutubeViewHolder extends RecyclerView.ViewHolder {
    WebView webView ;
    Button button;
  ImageView copy , share ;


    public YoutubeViewHolder(@NonNull View itemView) {
        super(itemView);
        webView=itemView.findViewById(R.id.video_view);
        button=itemView.findViewById(R.id.FullScreen);
        copy=itemView.findViewById(R.id.imageCopy);
        share=itemView.findViewById(R.id.imageShare);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }
}
