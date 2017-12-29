package com.mrc.vidiohuoshandemo.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.hjm.bottomtabbar.BottomTabBar;
import com.mrc.vidiohuoshandemo.R;

public class Main2Activity extends AppCompatActivity {

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
                .addTabItem(null, R.mipmap.shouye, R.mipmap.shouye2, ShouyeFragment.class)
                .addTabItem(null, R.mipmap.guanzhu, R.mipmap.guanzhu2, GuanzhuFragment.class)
                .addTabItem(null, R.mipmap.tianjia, R.mipmap.tianjia, TianjiaFragment.class)
                .addTabItem(null, R.mipmap.xiaoxi, R.mipmap.xiaoxi2, XiaoxiFragment.class)
                .addTabItem(null, R.mipmap.wode, R.mipmap.wode2, MedeFragment.class)
                .setTabBarBackgroundColor(Color.WHITE)
                .isShowDivider(false);
    }

    private void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
    }
}

