package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.FenLeiBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */

public class Frag2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<FenLeiBean.DataBean> list;
    private Context context;

    public Frag2Adapter(List<FenLeiBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_fragfirst, null);
        return new MyFirstViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyFirstViewHolder viewHolder= (MyFirstViewHolder) holder;
        viewHolder.sdv.setImageURI(list.get(position+10).getIcon());
        viewHolder.tv.setText(list.get(position+10).getName());
    }

    @Override
    public int getItemCount() {
        return list.size()-10;
    }
    class MyFirstViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv;

        public MyFirstViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.first_item_sdv);
            tv = itemView.findViewById(R.id.first_item_tv);
        }
    }
}
