package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.live;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.activity.LivePlayActivity;
import com.mrc.vidiohuoshandemo.activity.WebActivity;
import com.mrc.vidiohuoshandemo.api.net.Marquee;
import com.mrc.vidiohuoshandemo.util.Imagebanner;
import com.mrc.vidiohuoshandemo.util.MarqueeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mr.c on 2017/12/26.
 */
//直播的fragment
public class LiveFragment extends Fragment implements Liveview {
    private SmartRefreshLayout smartRefreshLayout;
    private RecyclerView rv;
    private Banner banner;
    //图片的地址和title的集合
    private List<String> mListImage;
    private Livepersenterinte livepersenterinte;
    private List<Livebean.ExtraBean.RankRoundBannerBean.RankListBean> rank_list;
    private MarqueeView marqueeView;
    private List<Marquee> marquees;
    private LiveAdapter adapter;
    private SharedPreferences user;
    private ImageView Rv_bt;
    private boolean b;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.onefragment, null);
        initView(view);
        user =getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        livepersenterinte = new Livepersenterinte(this);
        livepersenterinte.relevance();
        return view;
    }
    @Override
    public void showData(final Livebean livebean) {
        b= user.getBoolean("b", false);
        if (b ==true) {
            //点击后想要变成什么要的布局样式就搞一个你的需求
            rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
            Rv_bt.setImageResource(R.mipmap.a6e);
        }else if (b==false) {
            rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            Rv_bt.setImageResource(R.mipmap.a6c);
        }
        //切换大小图
        Rv_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"点击了切换视图按钮",Toast.LENGTH_SHORT).show();
                if (b ==false) {
                    //点击后想要变成什么要的布局样式就搞一个你的需求
                    rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
                    //给布尔值重新赋值
                    b = true;
                    user.edit().putBoolean("b",b).commit();
                    //给点击按钮的图片重新赋值
                    Rv_bt.setImageResource(R.mipmap.a6e);
                }else if (b ==true) {
                    rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                    //给布尔值重新赋值
                    b = false;
                    user.edit().putBoolean("b",b).commit();
                    //给点击按钮的图片重新赋值
                    Rv_bt.setImageResource(R.mipmap.a6c);
                }
            }
        });
        adapter = new LiveAdapter(getActivity(),livebean);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new LiveAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view , int position){
                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
                String ss = livebean.getData().get(position).getData().getStream_url().getRtmp_pull_url();
                startActivity(new Intent(getActivity(), LivePlayActivity.class).putExtra("pull",ss));
            }
        });
        //轮播
        getbanner(livebean);
        //榜单
        getbandfan(livebean);


    }

    private void getbandfan(Livebean livebean) {
        rank_list = livebean.getExtra().getRank_round_banner().getRank_list();
        marquees = new ArrayList<>();

        for (int i = 0; i < rank_list.size(); i++) {
            Livebean.ExtraBean.RankRoundBannerBean.RankListBean rankListBean = rank_list.get(i);
            Marquee marquee = new Marquee();
            marquee.setImgUrl(rankListBean.getIcon().getUrl_list().get(0));
            marquee.setTitle(rankListBean.getName());
            marquee.setImgUrl1(rankListBean.getList().get(0).getUser_avatar().getUrl_list().get(0));
            marquee.setImgUrl2(rankListBean.getList().get(1).getUser_avatar().getUrl_list().get(0));
            marquee.setImgUrl3(rankListBean.getList().get(2).getUser_avatar().getUrl_list().get(0));
            // marquee.setImgUrl4(rankListBean.getIcon().getUrl_list().get(0));
            marquees.add(marquee);
        }
        marqueeView.setImage(true);
        marqueeView.startWithList(marquees);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View textView) {
                Toast.makeText(getActivity(), "position:" +position, Toast.LENGTH_SHORT).show();

                String schema_url = rank_list.get(position).getUrl();
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url",schema_url);
                startActivity(intent);
            }
        });
    }

    private void getbanner(Livebean livebean) {
        final List<Livebean.ExtraBean.BannerBean.BannersBean> banners = livebean.getExtra().getBanner().getBanners();
        //加载图片的方法
        this.banner.setImageLoader(new Imagebanner());
        mListImage= new ArrayList<>();
        for (int i = 0; i <   banners.size(); i++) {
            mListImage.add(banners.get(i).getUrl_list().get(0));
        }
        //设置Banner图片集合
        this.banner.setImages(mListImage);
//切换的时间
        this.banner.setDelayTime(2000);
//启动banner
        this.banner.start();
        this.banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getActivity(), "position:" + position, Toast.LENGTH_SHORT).show();
                String schema_url = banners.get(position).getSchema_url();
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url",schema_url);
                startActivity(intent);
            }
        });
    }
    private void initView(View view) {
        rv =view.findViewById(R.id.rv1);
        Rv_bt =view.findViewById(R.id.Rv_bt);
        smartRefreshLayout =view.findViewById(R.id.sf);
        banner =view.findViewById(R.id.br_live);
        marqueeView = (MarqueeView) view.findViewById(R.id.marqueeView);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
                livepersenterinte.relevance();
            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
                livepersenterinte.relevance();
            }
        });

    }
}
