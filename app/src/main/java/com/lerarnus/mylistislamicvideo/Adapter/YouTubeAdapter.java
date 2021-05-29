package com.lerarnus.mylistislamicvideo.Adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lerarnus.mylistislamicvideo.Activiy.VideoFulSreen;
import com.lerarnus.mylistislamicvideo.Model.DataSetList;
import com.lerarnus.mylistislamicvideo.R;

import java.util.ArrayList;

public class YouTubeAdapter extends RecyclerView.Adapter<YoutubeViewHolder> {
    ArrayList<DataSetList> arrayList ;
   private Context context ;



    public YouTubeAdapter(ArrayList<DataSetList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_per_row,parent,false);

        return new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeViewHolder holder, final int position) {
        final  DataSetList current = arrayList.get(position);
        holder.webView.loadUrl("https://www.youtube.com/embed/"+current.getLink());
        
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullScrren = new Intent(context, VideoFulSreen.class);
                fullScrren.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                fullScrren.putExtra("Link","https://www.youtube.com/embed/"+current.getLink());
                context.startActivity(fullScrren);
            }
        });
//********************************************************************************************
  holder.copy.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          ClipboardManager clipboardManager = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
          ClipData clipData = ClipData.newPlainText("Label","https://youtu.be/"+current.getLink());
          clipboardManager.setPrimaryClip(clipData);
          Toast.makeText(context,"تم نسخ الرابط بنجاح",Toast.LENGTH_LONG).show();
      }
  });
//********************************************************************************************
holder.share.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent shareLink = new Intent(Intent.ACTION_SEND);
        shareLink.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareLink.setType("text/plain");
        shareLink.putExtra(Intent.EXTRA_TEXT,"https://youtu.be/"+current.getLink());
        context.startActivity(shareLink);
        Toast.makeText(context,"تم مشاركة الرابط بنجاح",Toast.LENGTH_LONG).show();

    }
});




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
