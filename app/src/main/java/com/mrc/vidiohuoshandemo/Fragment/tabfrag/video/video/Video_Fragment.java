package com.mrc.vidiohuoshandemo.Fragment.tabfrag.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrc.vidiohuoshandemo.R;

/**
 * Created by Mr.c on 2017/12/26.
 */
//视频的fragment
public class Video_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment,null);
        return view;
    }
}
