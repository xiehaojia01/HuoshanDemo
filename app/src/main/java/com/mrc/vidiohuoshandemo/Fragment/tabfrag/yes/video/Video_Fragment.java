package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.activity.PlayVideoActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

/**
 * Created by Mr.c on 2017/12/26.
 */
//视频的fragment
public class Video_Fragment extends Fragment implements Video_view{
    private RecyclerView rv;
    private List<VideoBean_Sp.DataBeanX> list;
    private VideoAdapter adapter;
    private SmartRefreshLayout videosf;
     VideoPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.video_fragment,null);
        rv=view.findViewById(R.id.rv);
        //刷新
        initSmartRefreshLayout(view);
        presenter=new VideoPresenter(this);
        presenter.videoP();
        rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(2, 2, 2, 2);
            }
        });
        return view;
    }
    private void initSmartRefreshLayout(View view) {
        videosf=view.findViewById(R.id.videosf);
        videosf.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
                presenter.videoP();
            }
        });
        videosf.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
                presenter.videoP();
            }
        });

    }
    @Override
    public void videoBean(final VideoBean_Sp videoBean) {
        Log.i("bean",videoBean.toString());
        list=videoBean.getData();
         adapter=new VideoAdapter(list,getActivity());
         rv.setAdapter(adapter);
        Log.e("ssssssss",list+"");
        adapter.setOnItemClickListener(new VideoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
                String s = videoBean.getData().get(position).getData().getVideo().getDownload_url().get(0);
                startActivity(new Intent(getActivity(),PlayVideoActivity.class).putExtra("pull",s));

            }
        });
    }

}
