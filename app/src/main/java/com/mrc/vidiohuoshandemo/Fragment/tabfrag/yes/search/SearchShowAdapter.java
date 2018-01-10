package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video.VideoAdapter;
import com.mrc.vidiohuoshandemo.R;

import java.util.List;

/**
 * Created by 杨群 on 2018/1/8.
 */

public class SearchShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<SearchBean.DataBean.RecommendUserBean> list;
    Context context;
    VideoAdapter.OnItemClickListener listener;


    public SearchShowAdapter(List<SearchBean.DataBean.RecommendUserBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    public void setOnItemClickListener(VideoAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_show, parent, false);
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
//        String s=list.get(position).getWord();
//        Log.e("1111111111",s);
//        viewHodler.suggestItem.setText(s);
        viewHodler.mSimpleDraweeViewMain.setImageURI(list.get(position).getUser().getAvatar_jpg().getUrl_list().get(0));
        viewHodler.mNameSearch.setText(list.get(position).getUser().getNickname());
        viewHodler.mTitleSearch.setText(list.get(position).getDescription());
        viewHodler.mSquarePhoneoneSearch.setImageURI(list.get(position).getUser().getAvatar_jpg().getUrl_list().get(0));
        viewHodler.mSquarePhonetwoSearch.setImageURI(list.get(position).getUser().getAvatar_jpg().getUrl_list().get(0));
        viewHodler.mSquarePhonethreeSearch.setImageURI(list.get(position).getUser().getAvatar_jpg().getUrl_list().get(0));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {

        private SimpleDraweeView mSimpleDraweeViewMain;
        private TextView mNameSearch;
        private TextView mTitleSearch;
        private Button mConcern;
        private SimpleDraweeView mSquarePhoneoneSearch;
        private SimpleDraweeView mSquarePhonetwoSearch;
        private SimpleDraweeView mSquarePhonethreeSearch;

        public MyViewHodler(View itemView) {
            super(itemView);
            mSimpleDraweeViewMain = (SimpleDraweeView) itemView.findViewById(R.id.main_simple_drawee_view);
            mNameSearch = (TextView) itemView.findViewById(R.id.search_name);
            mTitleSearch = (TextView) itemView.findViewById(R.id.search_title);
            mConcern = (Button) itemView.findViewById(R.id.concern);
            mSquarePhoneoneSearch = (SimpleDraweeView) itemView.findViewById(R.id.search_square_phoneone);
            mSquarePhonetwoSearch = (SimpleDraweeView) itemView.findViewById(R.id.search_square_phonetwo);
            mSquarePhonethreeSearch = (SimpleDraweeView) itemView.findViewById(R.id.search_square_phonethree);

        }
    }

    public interface OnItemClickListener {


        void onItemClick(View view, int position);
    }
}
