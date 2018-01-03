package com.mrc.vidiohuoshandemo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.mrc.vidiohuoshandemo.R;

public class PlayVideoActivity extends AppCompatActivity {
//    private IjkVideoView videoView;
    private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        initView();
        //String pull = getIntent().getStringExtra("pull");
//        IjkMediaPlayer.loadLibrariesOnce(null);
//        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
//        videoView =findViewById(R.id.ijkPlayer);
//        AndroidMediaController controller = new AndroidMediaController(this, false);
//        videoView.setMediaController(controller);
//        // String url = "http://o6wf52jln.bkt.clouddn.com/演员.mp3";
//        videoView.setVideoURI(Uri.parse(pull));
//        videoView.start();
    }
    private void initView() {
        mVideoView = (VideoView) findViewById(R.id.videoView);
        String ss =getIntent().getStringExtra("pull");
        mVideoView = findViewById(R.id.videoView);
        mVideoView.setVideoURI(Uri.parse(ss));
        mVideoView.start();
    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        videoView.pause();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        IjkMediaPlayer.native_profileEnd();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        videoView.resume();
//    }

}
