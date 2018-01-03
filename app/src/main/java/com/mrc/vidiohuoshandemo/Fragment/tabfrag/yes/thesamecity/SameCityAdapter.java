package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.thesamecity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video.VideoAdapter;
import com.mrc.vidiohuoshandemo.R;

import java.util.List;

/**
 * Created by 杨群 on 2018/1/1.
 */

public class SameCityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<SameCityBean.DataBeanX> list;
    Context context;
    VideoAdapter.OnItemClickListener listener;


    public SameCityAdapter(List<SameCityBean.DataBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setOnItemClickListener(VideoAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thesamecity_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(view, (int) view.getTag());
            }
        });
        return new MyViewHodler(view);
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHodler viewHodler = (MyViewHodler) holder;
        String s = list.get(position).getData().getAuthor().getAvatar_jpg().getUrl_list().get(0);
        Log.e("nnnnn", s);
        viewHodler.sdv.setImageURI(s);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final LinearLayout ll;
        private TextView mVideoName;
        private SimpleDraweeView mBelowSdv;
        private TextView mName;
        private TextView mLiuyan;
        public MyViewHodler(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            ll = itemView.findViewById(R.id.ll);
            mVideoName = (TextView) itemView.findViewById(R.id.videoName);
            mBelowSdv = (SimpleDraweeView) itemView.findViewById(R.id.sdv_below);
            mName = (TextView) itemView.findViewById(R.id.name);
            mLiuyan = (TextView) itemView.findViewById(R.id.liuyan);
            int width = ((Activity) ll.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams params = sdv.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            params.width = width / 2;
            params.height = (int) (200 + Math.random() * 400);
            sdv.setLayoutParams(params);

        }
    }

    public interface OnItemClickListener {


        void onItemClick(View view, int position);
    }
}
