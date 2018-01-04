package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.live;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mrc.vidiohuoshandemo.R;


/**
 *
 * @author Lenovo
 * @date 2017/12/28
 */

public class LiveAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    Context context;
    Livebean bean;

    public LiveAdapter(Context context, Livebean bean) {
        this.context = context;
        this.bean = bean;


    }
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    private OnItemClickListener mOnItemClickListener = null;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view;

           view = View.inflate(context, R.layout.liveplayer_item, null);
        MyViewHolder holder = new MyViewHolder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        //将position保存在itemView的Tag中，以便点击时进行获取
        myViewHolder.itemView.setTag(position);
        String s = bean.getData().get(position).getData().getOwner().getAvatar_jpg().getUrl_list().get(0);
            myViewHolder.lv1.setImageURI(s);

    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public int getItemCount() {
        return bean.getData().size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView lv1;

        public MyViewHolder(View itemView) {
            super(itemView);
            lv1 = itemView.findViewById(R.id.sdv);
        }
    }
}



