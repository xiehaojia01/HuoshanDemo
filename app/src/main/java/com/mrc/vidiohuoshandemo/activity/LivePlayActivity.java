package com.mrc.vidiohuoshandemo.activity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import com.mrc.vidiohuoshandemo.R;
import com.zhy.autolayout.AutoLayoutActivity;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

/**
 *
 */
public class LivePlayActivity extends AutoLayoutActivity {

   private IjkVideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liveplay);
        String pull = getIntent().getStringExtra("pull");
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        videoView =findViewById(R.id.ijkPlayer);
        AndroidMediaController controller = new AndroidMediaController(this, false);
        videoView.setMediaController(controller);
        videoView.setVideoURI(Uri.parse(pull));
        videoView.start();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IjkMediaPlayer.native_profileEnd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.resume();
    }
}
