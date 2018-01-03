package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.live;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrc.vidiohuoshandemo.R;

import butterknife.ButterKnife;


/**
 * Created by Mr.c on 2017/12/26.
 */
//直播的fragment
public class LiveFragment extends Fragment {

//    @BindView(R.id.helloTitle)
//    TextView helloTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.live_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
