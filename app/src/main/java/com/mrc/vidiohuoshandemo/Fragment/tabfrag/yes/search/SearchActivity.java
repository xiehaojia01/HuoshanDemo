package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.View.Main2Activity;
import com.mrc.vidiohuoshandemo.activity.AddressList;
import com.mrc.vidiohuoshandemo.activity.PleaseFriendActivity;
import com.mrc.vidiohuoshandemo.activity.QRcodeActivity;
import com.mrc.vidiohuoshandemo.activity.ScanActivity;

public class SearchActivity extends AppCompatActivity implements ISearchView {
    private LinearLayout search_phone;
    private TextView tv_msg;
    private TextView pleaseFriend;
    private TextView QRcode;
    private TextView Scan;
    private SearchAdapter searchAdapter;
    private SearchPersenter searchPersenter;
    private RecyclerView mRecyclerviewSearch;
    private RecyclerView mRvtwoSearch;
    private SearchShowAdapter searchShowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchPersenter = new SearchPersenter(this);
        searchPersenter.showSearch();
        initView();

        //跳转获取手机通讯录
        initSearch_phone();
        //点击跳转到邀请朋友的界面
        initPleaseFriend();
        //点击取消退回主界面
        initCancel();
        //点击跳转到生成我的二维码界面
        initQRcode();
        //点击跳转到扫一扫界面
        initScan();
    }

    private void initView() {
        mRecyclerviewSearch = (RecyclerView) findViewById(R.id.search_recyclerview);
        search_phone = findViewById(R.id.search_phone);
        tv_msg = findViewById(R.id.tv_msg);
        pleaseFriend = findViewById(R.id.pleaseFriend);
        QRcode = findViewById(R.id.QRcode);
        Scan = findViewById(R.id.Scan);
        mRvtwoSearch = (RecyclerView) findViewById(R.id.search_rvtwo);
    }

    //点击跳转到扫一扫界面
    private void initScan() {
        Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });
    }

    //点击跳转到生成我的二维码界面
    private void initQRcode() {
        QRcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, QRcodeActivity.class);
                startActivity(intent);

            }
        });
    }

    //点击跳转到邀请朋友的界面
    private void initPleaseFriend() {
        pleaseFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, PleaseFriendActivity.class);
                startActivity(intent);
            }
        });
    }

    //点击取消
    private void initCancel() {
        tv_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    //点击跳转到通讯录
    private void initSearch_phone() {
        search_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, AddressList.class);
                startActivity(intent);
            }
        });

    }

    //展示下面建议的方法
    @Override
    public void searchShow(SearchBean searchBean) {
        mRecyclerviewSearch.setLayoutManager(new GridLayoutManager(this, 4));
        searchAdapter = new SearchAdapter(searchBean.getData().getHot_words(), SearchActivity.this);
        mRecyclerviewSearch.setAdapter(searchAdapter);
        //展示关注
        mRvtwoSearch.setLayoutManager(new LinearLayoutManager(this));
        searchShowAdapter=new SearchShowAdapter(searchBean.getData().getRecommend_user(),SearchActivity.this);

        mRvtwoSearch.setAdapter(searchShowAdapter);
    }
}
