package com.mrc.vidiohuoshandemo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.mrc.vidiohuoshandemo.R;

public class SameCityPlayVideoActivity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_city_play_video);
        initView();


    }

    private void initView() {
        mVideoView = (VideoView) findViewById(R.id.videoView);
        String ss =getIntent().getStringExtra("pull");
        mVideoView = findViewById(R.id.videoView);
        mVideoView.setVideoURI(Uri.parse(ss));
        mVideoView.start();
    }
}
