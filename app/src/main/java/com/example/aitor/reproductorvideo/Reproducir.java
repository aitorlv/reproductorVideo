package com.example.aitor.reproductorvideo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.MediaController;
import android.widget.VideoView;


public class Reproducir extends Activity{
    private VideoView video;
    private DisplayMetrics dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducir);
        Bundle b=getIntent().getExtras();
        video=(VideoView)findViewById(R.id.videoView);
        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        video.setMinimumWidth(width);
        video.setMinimumHeight(height);
        video.setVideoURI(Uri.parse(b.getString("ruta")));
        video.setMediaController(new MediaController(this));
        video.start();
    }

}
