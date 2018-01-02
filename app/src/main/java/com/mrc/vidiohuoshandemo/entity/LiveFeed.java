package com.mrc.vidiohuoshandemo.entity;

/**
 * Created by  on 2017/12/26.
 */
//这个是data里面封装公共类型
public class LiveFeed {
    public int type;
    public String rid;

    @Override
    public String toString() {
        return "LiveFeed{" +
                "type=" + type +
                ", rid='" + rid + '\'' +
                '}';
    }
}
