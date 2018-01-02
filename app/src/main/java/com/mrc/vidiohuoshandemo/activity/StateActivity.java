package com.mrc.vidiohuoshandemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.View.MainActivity;
import com.mrc.vidiohuoshandemo.common.BaseActivity;

public class StateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        final View view = View.inflate(this, R.layout.activity_state, null);
        AlphaAnimation aa = new AlphaAnimation(1.0f,1.0f);
        aa.setDuration(3000);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation arg0) {
                redirectTo();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }


    /**
     * 跳转到...
     */
    private void redirectTo(){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();


    }
}
