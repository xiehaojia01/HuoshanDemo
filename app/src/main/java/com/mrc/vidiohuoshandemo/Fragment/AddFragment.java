package com.mrc.vidiohuoshandemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrc.vidiohuoshandemo.R;

/**
 * Created by Mr.c on 2017/12/28.
 */
//添加的fragment
public class AddFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment,null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
