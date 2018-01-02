package com.mrc.vidiohuoshandemo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mrc.vidiohuoshandemo.Adapter.PagerAdapter.MyViewPagerAdapter;
import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.thesamecity.TheSameCity_fragment;
import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video.Video_Fragment;
import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.activity.SearchActivity;
import com.mrc.vidiohuoshandemo.model.LiveFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.c on 2017/12/28.
 */

public class HomePageFragment extends Fragment implements View.OnClickListener {
    private TabLayout mIndicator;
    /**
     * 登录/注册
     */
    private ViewPager mViewPager;
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;
    private View view;
    private ImageView mSousuo1;
    private ImageView mXinxi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.homepage_fragment, null);
        //初始化控件
        initView();
        //添加标题
        initTitile();
        //添加fragment
        initFragment();
        //设置适配器
        mViewPager.setAdapter(new MyViewPagerAdapter(getFragmentManager(), mFragmentList, mTitleList));
        //将tablayout与fragment关联
        mIndicator.setupWithViewPager(mViewPager);
        return view;
    }

    private void initTitile() {
        mTitleList = new ArrayList<>();
        mTitleList.add("直播");
        mTitleList.add("视频");
        mTitleList.add("同城");

        //设置tablayout模式
        mIndicator.setTabMode(TabLayout.MODE_FIXED);
        //tablayout获取集合中的名称
        mIndicator.addTab(mIndicator.newTab().setText(mTitleList.get(0)));
        mIndicator.addTab(mIndicator.newTab().setText(mTitleList.get(1)));
        mIndicator.addTab(mIndicator.newTab().setText(mTitleList.get(2)));
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new LiveFragment());
        mFragmentList.add(new Video_Fragment());
        mFragmentList.add(new TheSameCity_fragment());
    }

    private void initView() {
        mIndicator = (TabLayout) view.findViewById(R.id.indicator1);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager1);
        mSousuo1 = (ImageView) view.findViewById(R.id.sousuo1);
        mSousuo1.setOnClickListener(this);
        mXinxi = (ImageView) view.findViewById(R.id.xinxi);
        mXinxi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.sousuo1:
                Intent intent_sousuo = new Intent(getContext(), SearchActivity.class);
                startActivity(intent_sousuo);
                break;
            case R.id.xinxi:

                break;
        }
    }
}