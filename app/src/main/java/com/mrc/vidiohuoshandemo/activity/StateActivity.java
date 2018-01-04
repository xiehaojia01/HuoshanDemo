package com.mrc.vidiohuoshandemo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.View.Main2Activity;
import com.mrc.vidiohuoshandemo.View.MainActivity;

public class StateActivity extends AppCompatActivity {
    private SharedPreferences islogin;
    private Boolean checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        islogin = getSharedPreferences("counter", Context.MODE_PRIVATE);
        checkout = islogin.getBoolean("islogin",false);
        Handler sh = new Handler();

        sh.postDelayed(new Runnable() {//延迟多少秒执行Runnable()
            @Override
            public void run() {
                redirectTo();
            }
        }, 1000);//1秒后跳转



    }

    /**
     * 跳转到...
     */
    private void redirectTo(){
        if (checkout) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            finish();
        }else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
