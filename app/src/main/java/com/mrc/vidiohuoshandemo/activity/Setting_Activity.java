package com.mrc.vidiohuoshandemo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.View.MainActivity;

public class Setting_Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mRetutnBack;
    private SharedPreferences login;
    private SharedPreferences.Editor islogin;
    /**
     * 退出登录
     */
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_);
        initView();
    }

    private void initView() {
        mRetutnBack = (ImageView) findViewById(R.id.retutn_back);
        mRetutnBack.setOnClickListener(this);
        mBackButton = (Button) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.retutn_back:
                finish();
                break;
            case R.id.back_button:
                login = getSharedPreferences("counter", Context.MODE_PRIVATE);
                islogin = login.edit();
                islogin.putBoolean("islogin", false);
                islogin.commit();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
