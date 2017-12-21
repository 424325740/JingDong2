package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.ChildFenLeiBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */

public class Classify_Right_Child_Grid_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ChildFenLeiBean.DataBean.ListBean> listBeen;
    OnItemClickListener listener;


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Classify_Right_Child_Grid_Adapter(Context context, List<ChildFenLeiBean.DataBean.ListBean> listBeen){
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.calssify_rigth_child_gridview, null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view,(int)view.getTag() );
            }
        });
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        holder1.imageView.setImageURI(listBeen.get(position).getIcon());
        holder1.textView.setText(listBeen.get(position).getName());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        SimpleDraweeView imageView;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.classify_right_gv_iv);
            textView=itemView.findViewById(R.id.classify_right_gv_tv);
        }
    }
    //定义接口
    public interface  OnItemClickListener {


        void onItemClick(View view, int position);
    }
}
