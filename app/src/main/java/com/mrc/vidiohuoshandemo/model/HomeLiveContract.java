package com.mrc.vidiohuoshandemo.model;

import com.mrc.vidiohuoshandemo.common.BasePresenter;
import com.mrc.vidiohuoshandemo.common.BaseView;

/**
 * Created by 杨群 on 2017/12/29.
 */

public interface HomeLiveContract {
    interface View extends BaseView<Presenter>{
        void showTitle();
    }
    interface Presenter extends BasePresenter {
        String getTitle();
    }
}
