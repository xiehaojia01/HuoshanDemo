package com.mrc.vidiohuoshandemo.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrc.vidiohuoshandemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Mr.c on 2017/12/26.
 */
//直播的fragment
public class LiveFragment extends Fragment implements HomeLiveContract.View{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public HomeLiveContract.Presenter presenter;
    @BindView(R.id.helloTitle)
    TextView helloTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.live_fragment,container,false);
        ButterKnife.bind(this, view);
        presenter = new HomeLivePresenter(this);
        return view;
    }

    @Override
    public void setPresenter(HomeLiveContract.Presenter presenter) {

    }



    @Override
    public void login() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showTitle() {
        helloTitle.setText(presenter.getTitle());
    }

}
