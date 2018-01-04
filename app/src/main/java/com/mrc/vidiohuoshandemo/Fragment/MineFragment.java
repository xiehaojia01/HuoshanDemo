package com.mrc.vidiohuoshandemo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.activity.CompileActivity;
import com.mrc.vidiohuoshandemo.activity.Setting_Activity;

/**
 * Created by Mr.c on 2017/12/28.
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView mYaoqing;
    /**
     * 关注
     */
    private TextView mWodeTitlename;
    private ImageView mFenxing;
    private ImageView mShezhi;
    private ScrollView mScrollView1;
    private SharedPreferences islogin;
    /**
     * 名字
     */
    private TextView mName;
    /**
     * 编辑
     */
    private TextView mCompile;
    /**
     * 性别
     */
    private TextView mSex;
    /**
     * 年龄
     */
    private TextView mAge;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mYaoqing = (ImageView) view.findViewById(R.id.yaoqing);
        mYaoqing.setOnClickListener(this);
        mWodeTitlename = (TextView) view.findViewById(R.id.wode_titlename);
        mFenxing = (ImageView) view.findViewById(R.id.fenxing);
        mFenxing.setOnClickListener(this);
        mShezhi = (ImageView) view.findViewById(R.id.shezhi);
        mShezhi.setOnClickListener(this);
        mScrollView1 = (ScrollView) view.findViewById(R.id.scrollView_mine);
        mName = (TextView) view.findViewById(R.id.name);
        mCompile = (TextView) view.findViewById(R.id.compile);
        mSex = (TextView) view.findViewById(R.id.sex);
        mAge = (TextView) view.findViewById(R.id.age);
        islogin = getContext().getSharedPreferences("counter", Context.MODE_PRIVATE);
        String name = islogin.getString("name", "");
        String sex = islogin.getString("sex", "");
        String age = islogin.getString("age", "");
        mWodeTitlename.setText(name);
        mName.setText(name);
        mSex.setText(sex);
        mAge.setText(age);
        mCompile.setOnClickListener(this);
}

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.yaoqing:
                break;
            case R.id.fenxing:
                break;
            case R.id.shezhi:
                Intent intent1 = new Intent(getContext(),Setting_Activity.class);
                startActivity(intent1);
                break;
            case R.id.compile:
                Intent intent = new Intent(getContext(),CompileActivity.class);
                startActivity(intent);
                break;
        }
    }

}
