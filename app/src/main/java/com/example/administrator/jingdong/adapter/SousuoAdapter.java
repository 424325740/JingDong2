package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.SousuoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 吴占彬
 * 2017/12/18
 */

public class SousuoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<SousuoBean.DataBean> list;

    public SousuoAdapter(Context context, List<SousuoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sousuoitem, null);
        return new MySouSuoHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MySouSuoHolder suoHolder= (MySouSuoHolder) holder;
        String[] split = list.get(position).getImages().split("\\|");
        suoHolder.sdv.setImageURI(split[0]);
        suoHolder.tv.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MySouSuoHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv;

        public MySouSuoHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sousuo_sdv);
            tv = itemView.findViewById(R.id.sousuo_tv);
        }
    }
}
