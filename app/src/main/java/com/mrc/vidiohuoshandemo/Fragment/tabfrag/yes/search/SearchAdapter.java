package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video.VideoAdapter;
import com.mrc.vidiohuoshandemo.R;

import java.util.List;

/**
 * Created by 杨群 on 2018/1/8.
 */

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<SearchBean.DataBean.HotWordsBean> list;
    Context context;
    VideoAdapter.OnItemClickListener listener;
    public SearchAdapter(List<SearchBean.DataBean.HotWordsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }



    public void setOnItemClickListener(VideoAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_suggest_item,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(view,(int)view.getTag() );
            }
        });
        return new SearchAdapter.MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SearchAdapter.MyViewHodler viewHodler= (SearchAdapter.MyViewHodler) holder;
        String s=list.get(position).getWord();
        Log.e("1111111111",s);
        viewHodler.suggestItem.setText(s);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHodler extends RecyclerView.ViewHolder{

       private TextView suggestItem;

        public MyViewHodler(View itemView) {
            super(itemView);
            suggestItem = itemView.findViewById(R.id.search_suggestItem);

        }
    }
    public interface  OnItemClickListener {


        void onItemClick(View view, int position);
    }
}
