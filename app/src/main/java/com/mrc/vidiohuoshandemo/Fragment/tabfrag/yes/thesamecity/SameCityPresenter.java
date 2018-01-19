package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.thesamecity;

import com.mrc.vidiohuoshandemo.util.OnNetLinsenter;


public class SameCityPresenter {
    private ISameCityModel model;
    private SameCity_view view;

    SameCityPresenter(SameCity_view view) {
        this.view = view;
        model = new SameCityModel();
    }

    public void sameCityP() {
        model.sameCitydata(new OnNetLinsenter<SameCityBean>() {
            @Override
            public void callBack(SameCityBean sameCityBean) {
                view.sameCityBean(sameCityBean);
            }

        });

    }

}

