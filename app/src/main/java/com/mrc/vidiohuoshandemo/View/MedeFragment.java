package com.mrc.vidiohuoshandemo.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrc.vidiohuoshandemo.R;

/**
 * Created by Mr.c on 2017/12/28.
 */

public class MedeFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView mYaoqing;
    /**
     * 关注
     */
    private TextView mWodeTitlename;
    private ImageView mFenxing;
    private ImageView mShezhi;
    private RecyclerView mRecyclerView1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wode_fragment, null);
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
        mRecyclerView1 = (RecyclerView) view.findViewById(R.id.recyclerView1);
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
                break;
        }
    }
}
