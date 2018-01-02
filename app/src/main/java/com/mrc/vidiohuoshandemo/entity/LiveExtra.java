package com.mrc.vidiohuoshandemo.entity;

/**
 * Created by  on 2017/12/26.
 */
//这个是extra里面封装的方法，挑选出几个来封装。
public class LiveExtra {
    public int total;
    public long now;
    public long max_time;

    @Override
    public String toString() {
        return "LiveExtra{" +
                "total=" + total +
                ", now=" + now +
                ", max_time=" + max_time +
                '}';
    }
}
