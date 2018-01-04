package com.mrc.vidiohuoshandemo.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrc.vidiohuoshandemo.R;

public class CompileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mRetutnBack;
    /**
     * 保存
     */
    private TextView mSave;
    private ImageView mCompileHeader;
    private EditText mCompileSetname;
    private EditText mCompileSetsex;
    private EditText mCompileSetage;
    private SharedPreferences login;
    private SharedPreferences.Editor islogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compile);
        initView();

    }

    private void initView() {
        mRetutnBack = (ImageView) findViewById(R.id.retutn_back);
        mRetutnBack.setOnClickListener(this);
        mSave = (TextView) findViewById(R.id.save);
        mSave.setOnClickListener(this);
        mCompileHeader = (ImageView) findViewById(R.id.compile_header);
        mCompileHeader.setOnClickListener(this);
        mCompileSetname = (EditText) findViewById(R.id.compile_setname);
        mCompileSetsex = (EditText) findViewById(R.id.compile_setsex);
        mCompileSetage = (EditText) findViewById(R.id.compile_setage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.retutn_back:
                finish();
                break;
            case R.id.save:
                String name = mCompileSetname.getText().toString();
                String sex = mCompileSetsex.getText().toString();
                String age = mCompileSetage.getText().toString();
                login = getSharedPreferences("counter", Context.MODE_PRIVATE);
                islogin = login.edit();
                islogin.putString("name",name);
                islogin.putString("sex",sex);
                islogin.putString("age",age);
                islogin.commit();
                finish();
                break;
            case R.id.compile_header:
                Toast.makeText(this,"暂不支持设置头像",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
