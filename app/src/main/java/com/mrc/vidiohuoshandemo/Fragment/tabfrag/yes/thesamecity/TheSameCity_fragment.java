package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.thesamecity;


import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video.VideoAdapter;
import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.activity.SameCityPlayVideoActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

//同城的fragment
public class TheSameCity_fragment extends Fragment implements SameCity_view {
    private RecyclerView rv;
    private List<SameCityBean.DataBeanX> list;
    private SameCityAdapter sameCityAdapter;
    private SmartRefreshLayout thesamesf;
    private  SameCityPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.thesamecity_fragment,null);
        rv=view.findViewById(R.id.rv);
        //刷新
        initSmartRefreshLayout(view);
        presenter=new SameCityPresenter(this);
        presenter.sameCityP();
        //设置layoutManager

        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        rv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(2, 2, 2, 2);
            }
        });
        return view;
    }

    private void initSmartRefreshLayout(View view) {
        thesamesf=view.findViewById(R.id.thesamesf);
        thesamesf.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
                presenter.sameCityP();
            }
        });
        thesamesf.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
                presenter.sameCityP();
            }
        });

    }


    @Override
    public void sameCityBean(final SameCityBean sameCityBean) {
        Log.i("bean",sameCityBean.toString());
        list=sameCityBean.getData();
        sameCityAdapter=new SameCityAdapter(list,getActivity());
        rv.setAdapter(sameCityAdapter);
        Log.e("ssssssss",list+"");
        sameCityAdapter.setOnItemClickListener(new VideoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
                String s = sameCityBean.getData().get(position).getData().getVideo().getDownload_url().get(0);
                startActivity(new Intent(getActivity(),SameCityPlayVideoActivity.class).putExtra("pull",s));

            }
        });
    }
}

