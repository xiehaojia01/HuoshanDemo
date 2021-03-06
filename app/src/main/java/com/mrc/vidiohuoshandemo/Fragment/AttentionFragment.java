package com.mrc.vidiohuoshandemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrc.vidiohuoshandemo.R;

/**
 * Created by Mr.c on 2017/12/28.
 */
//关注的fragment
public class AttentionFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.attention_fragment, null);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
    }
}
