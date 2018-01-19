package com.mrc.vidiohuoshandemo.model;

import com.mrc.vidiohuoshandemo.common.BasePresenter;
import com.mrc.vidiohuoshandemo.common.BaseView;


public interface HomeLiveContract {
    interface View extends BaseView<Presenter>{
        void showTitle();
    }
    interface Presenter extends BasePresenter {
        String getTitle();
    }
}
