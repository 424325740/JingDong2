package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.ShowRessBean;

import java.util.List;

/**
 * 吴占彬
 * 2017/12/16
 */

public class ShowRessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ShowRessBean.DataBean> list;
    Context context;

    public ShowRessAdapter(List<ShowRessBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.showressitem, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.name.setText("姓名："+list.get(position).getName());
        myViewHolder.moblie1.setText("手机号："+list.get(position).getMobile()+"");
        myViewHolder.dizhi.setText("地址："+list.get(position).getAddr());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView moblie1;
        private final TextView name;
        private final TextView dizhi;
        private final TextView xiangxi;

        public MyViewHolder(View itemView) {
            super(itemView);
            moblie1 = itemView.findViewById(R.id.moble);
            name = itemView.findViewById(R.id.name);
            dizhi = itemView.findViewById(R.id.dizhi);
            xiangxi = itemView.findViewById(R.id.xiangxi);
        }
    }
}
