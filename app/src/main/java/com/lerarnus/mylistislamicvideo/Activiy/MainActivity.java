package com.lerarnus.mylistislamicvideo.Activiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.lerarnus.mylistislamicvideo.Model.DataSetList;
import com.lerarnus.mylistislamicvideo.R;
import com.lerarnus.mylistislamicvideo.Adapter.YouTubeAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String LastVideo[]={
            "IwGDdzbe4Wg",
            "LdA7fN9BKhE",
            "xjcbjSUUdFE",
            "4KGgx_WfmdE"

    };
    private String LinkVideo[]={
            "TFzHt5pXyfM",
            "XYwT0n2905I",
            "A2LCx4f-ubY",
            "fctmgq1kBuA" ,
            "fR8gEKOpCQc",
            "7sUBB0J8n6s",
            "lX2zYdBbhYU",
            "Q86pgvrRq70",
            "lTzeIH702uE",
            "6dK71A6pQYk",
            "ZzHVzAqIQWg",
            "DvgVONzm1AM",
            "k4ZA8WNfmPE",
            "iWX7M4GEFpE",
            "pZOFKz1XqWg"
    };

    RecyclerView recyclerView ;

    ArrayList<DataSetList> arrayList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


           Intent intent = getIntent();
           Bundle extras = intent.getExtras();
           int data = extras.getInt("BestVideo");

        if(data==1) {

            arrayList = new ArrayList<DataSetList>();
            for (int i = 0; i < LastVideo.length; i++) {
                DataSetList dataSetList = new DataSetList(LastVideo[i]);
                arrayList.add(dataSetList);
            }}

 if(data==2) {

     arrayList = new ArrayList<DataSetList>();
     for (int i = 0; i < LinkVideo.length; i++) {
         DataSetList dataSetList = new DataSetList(LinkVideo[i]);
         arrayList.add(dataSetList);
     }

 }
        YouTubeAdapter youTubeAdapter = new YouTubeAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(youTubeAdapter);


    }
}
