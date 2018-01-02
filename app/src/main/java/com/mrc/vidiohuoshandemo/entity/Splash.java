package com.mrc.vidiohuoshandemo.entity;

/**
 * Created by  on 2017/12/26.
 */
//这是另一个实体类
public class Splash {

    public int sdk_splash;
    public int splash_interval;
    public int leave_interval;
    public int show_limit;

    @Override
    public String toString() {
        return "Splash{" +
                "sdk_splash=" + sdk_splash +
                ", splash_interval=" + splash_interval +
                ", leave_interval=" + leave_interval +
                ", show_limit=" + show_limit +
                '}';
    }
}
