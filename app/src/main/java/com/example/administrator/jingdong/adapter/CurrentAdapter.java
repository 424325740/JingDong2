package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.CurrentBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 吴占彬
 * 2017/12/13
 */

public class CurrentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<CurrentBean.DataBean> list;
    Context context;
    int type;

    public CurrentAdapter(List<CurrentBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    OnItemClickListener listener;


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public void setType(int type) {
        this.type = type;
    }
    @Override
//用来获取当前项Item是哪种类型的布局
    public int getItemViewType(int position) {
        return type;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View baseView;
        if (viewType == 0) {
            baseView = View.inflate(context, R.layout.linviewholder, null);
            LinearViewHolder linearViewHolder = new LinearViewHolder(baseView);
            baseView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(view,(int)view.getTag() );
                }
            });
            return linearViewHolder;
        } else {
            baseView = View.inflate(context, R.layout.currentitem, null);
            GrouidViewHolder gridViewHolder = new GrouidViewHolder(baseView);
            baseView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(view,(int)view.getTag() );
                }
            });
            return gridViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (type==1) {
            GrouidViewHolder myViewHolder = (GrouidViewHolder) holder;
            String[] split = list.get(position).getImages().split("\\|");
            myViewHolder.sdv.setImageURI(split[0]);
            myViewHolder.tv.setText(list.get(position).getTitle());
            holder.itemView.setTag(position);
        }else if (type==0){
            LinearViewHolder myViewHolder = (LinearViewHolder) holder;
            String[] split = list.get(position).getImages().split("\\|");
            myViewHolder.lin_sdv.setImageURI(split[0]);
            myViewHolder.lin_tv.setText(list.get(position).getTitle());
            holder.itemView.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class GrouidViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv;

        public GrouidViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.current_sdv);
            tv = itemView.findViewById(R.id.current_tv);
        }
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private  SimpleDraweeView lin_sdv;
        private  TextView lin_tv;
        public LinearViewHolder(View itemView) {
            super(itemView);
            lin_sdv = itemView.findViewById(R.id.lin_sdv);
            lin_tv = itemView.findViewById(R.id.lin_tv);
        }
    }
    public interface  OnItemClickListener {


        public void onItemClick(View view, int position);
    }

}
