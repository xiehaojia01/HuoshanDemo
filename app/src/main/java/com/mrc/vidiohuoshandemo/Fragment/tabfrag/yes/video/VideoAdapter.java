package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mrc.vidiohuoshandemo.R;

import java.util.List;

/**
 * Created by 杨群 on 2018/1/1.
 */

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<VideoBean_Sp.DataBeanX> list;
    Context context;
    OnItemClickListener listener;
    public VideoAdapter(List<VideoBean_Sp.DataBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }



    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(view,(int)view.getTag() );
            }
        });
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
   MyViewHodler viewHodler= (MyViewHodler) holder;
   String s=list.get(position).getData().getAuthor().getAvatar_jpg().getUrl_list().get(0);
        Log.e("1111111111",s);
     viewHodler.sdv.setImageURI(s);
   holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHodler extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;

        public MyViewHodler(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdvs);

        }
    }
    public interface  OnItemClickListener {


        void onItemClick(View view, int position);
    }
}
