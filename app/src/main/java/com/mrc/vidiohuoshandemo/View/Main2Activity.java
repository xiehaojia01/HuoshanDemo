package com.mrc.vidiohuoshandemo.View;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import com.hjm.bottomtabbar.BottomTabBar;
import com.mrc.vidiohuoshandemo.Fragment.AddFragment;
import com.mrc.vidiohuoshandemo.Fragment.AttentionFragment;
import com.mrc.vidiohuoshandemo.Fragment.HomePageFragment;
import com.mrc.vidiohuoshandemo.Fragment.MessageFragment;
import com.mrc.vidiohuoshandemo.Fragment.MineFragment;
import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.common.BaseActivity;

public class Main2Activity extends BaseActivity {

    private BottomTabBar mBottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        WindowManager wm = this.getWindowManager();

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        int a = width / 7, b = height / 15;
        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(a, b)
                .setFontSize(0)
                .setTabPadding(7, 5, 1)
                .setChangeColor(Color.DKGRAY, Color.RED)
                .addTabItem(null, R.mipmap.shouye, R.mipmap.shouye2, HomePageFragment.class)
                .addTabItem(null, R.mipmap.guanzhu, R.mipmap.guanzhu2, AttentionFragment.class)
                .addTabItem(null, R.mipmap.tianjia, R.mipmap.tianjia, AddFragment.class)
                .addTabItem(null, R.mipmap.xiaoxi, R.mipmap.xiaoxi2, MessageFragment.class)
                .addTabItem(null, R.mipmap.wode, R.mipmap.wode2, MineFragment.class)
                .setTabBarBackgroundColor(Color.WHITE)
                .isShowDivider(false);
    }

    private void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
    }
}

