package com.mrc.vidiohuoshandemo.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrc.vidiohuoshandemo.Adapter.PagerAdapter.MyViewPagerAdapter;
import com.mrc.vidiohuoshandemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.c on 2017/12/28.
 */

public class XiaoxiFragment extends Fragment {

    private View view;
    private TabLayout mIndicator2;
    private ViewPager mViewPager2;
    private View mXiaoxiFragmentView;
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.xiaoxi_fragment, null);
    //初始化控件
    initView();
    //添加标题
    initTitile();
    //添加fragment
    initFragment();
    //设置适配器
        mViewPager2.setAdapter(new MyViewPagerAdapter(getFragmentManager(), mFragmentList, mTitleList));
    //将tablayout与fragment关联
        mIndicator2.setupWithViewPager(mViewPager2);
        return view;
      }

    private void initTitile() {
        mTitleList = new ArrayList<>();
        mTitleList.add("八卦");
        mTitleList.add("消息");
        //设置tablayout模式
        mIndicator2.setTabMode(TabLayout.MODE_FIXED);
        //tablayout获取集合中的名称
        mIndicator2.addTab(mIndicator2.newTab().setText(mTitleList.get(0)));
        mIndicator2.addTab(mIndicator2.newTab().setText(mTitleList.get(1)));
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new Bagua_fragment());
        mFragmentList.add(new Xiaoxi2_fragment());
    }

    private void initView() {
        mIndicator2 = (TabLayout) view.findViewById(R.id.indicator2);
        mViewPager2 = (ViewPager) view.findViewById(R.id.viewPager2);
    }
}
