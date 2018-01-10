package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.live;

/**
 * Created by Lenovo on 2017/12/28.
 */

public class Livepersenterinte implements Livepersente,LiveFinishListener {
    //接口
    Liveview liveview;
    private final Livemodeliste livemodeliste;

    //初始化
    public Livepersenterinte(Liveview liveview){
        this.liveview  = liveview;
        //多态
        livemodeliste = new Livemodeliste();
    }
    @Override
    public void relevance() {
        //p跟m关联
        livemodeliste.getData(this);
    }

    @Override
    public void onSuccess(Livebean livebean) {
        //关联view
        liveview.showData(livebean);
    }
}