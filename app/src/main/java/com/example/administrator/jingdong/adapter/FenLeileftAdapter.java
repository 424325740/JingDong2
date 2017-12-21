package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.FenLeiBean;

import java.util.List;

/**
 * 吴占彬
 * 2017/12/13
 */

public class FenLeileftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FenLeiBean.DataBean> list;

    public FenLeileftAdapter(Context context, List<FenLeiBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    OnItemClickLister listener;


    public void setOnItemClickListener(OnItemClickLister listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fenleiitem, null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view,(int)view.getTag() );
            }
        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder myViewHolder= (MyViewHolder) holder;
            myViewHolder.tv.setText(list.get(position).getName());
            holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.fenlei_tv);
        }
    }
    //定义一个接口
    public interface OnItemClickLister{
        void onItemClick(View view, int position);
    }
}
