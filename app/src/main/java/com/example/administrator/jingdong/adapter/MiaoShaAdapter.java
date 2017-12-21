package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.ShouYeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 吴占彬
 * 2017/12/11
 */

public class MiaoShaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ShouYeBean.MiaoshaBean.ListBeanX> list;
    private Context context;

    public MiaoShaAdapter(List<ShouYeBean.MiaoshaBean.ListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.miaosha_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder= (MyViewHolder) holder;
        String[] split = list.get(position).getImages().split("\\|");
        viewHolder.sdv.setImageURI(split[1]);
        viewHolder.title.setText(list.get(position).getTitle());
        viewHolder.tv.setText("￥"+list.get(position).getPrice()+"");
        viewHolder.price.setText("原价"+list.get(position).getBargainPrice()+"");
    }

    @Override
    public int getItemCount() {
        return 4;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView title;
        private final TextView tv;
        private final TextView price;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.miasha_sdv_item);
            title = itemView.findViewById(R.id.miaosha_title);
            tv = itemView.findViewById(R.id.miaosha_tv_item);
            price = itemView.findViewById(R.id.miaosha_tvprice_item);
        }
    }
}
