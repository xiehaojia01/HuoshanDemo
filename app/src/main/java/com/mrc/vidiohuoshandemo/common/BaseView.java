package com.mrc.vidiohuoshandemo.common;

/**
 * Created by 杨群 on 2017/12/29.
 */

public interface BaseView<T> {
void setPresenter(T presenter);
void login();
void showError();
}
