package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video;

import com.mrc.vidiohuoshandemo.util.OnNetLinsenter;

public class VideoPresenter {
    private IVidelModel model;
    private Video_view view;

    VideoPresenter(Video_view view) {
        this.view = view;
        model=new VideoModel();
    }
    public void videoP(){
        model.videodata(new OnNetLinsenter<VideoBean_Sp>() {
            @Override
            public void callBack(VideoBean_Sp videoBean_sp) {
                view.videoBean(videoBean_sp);

            }
        });
    }
}
