package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.ShowCharBean;
import com.example.administrator.jingdong.event.MessageEvent;
import com.example.administrator.jingdong.event.PriceAndCountEvent;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


public class MyAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<ShowCharBean.DataBean> groupList;
    private List<List<ShowCharBean.DataBean.ListBean>> childList;
    private final LayoutInflater inflater;

    public MyAdapter(Context context, List<ShowCharBean.DataBean> groupList, List<List<ShowCharBean.DataBean.ListBean>> childList) {
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view;
        final GroupViewHolder holder;
        if (convertView == null) {
            holder = new GroupViewHolder();
            view = inflater.inflate(R.layout.item_parent_market, null);
            holder.cbGroup = view.findViewById(R.id.cb_parent);
            holder.tv_number = view.findViewById(R.id.tv_number);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (GroupViewHolder) view.getTag();
        }
        final ShowCharBean.DataBean dataBean = groupList.get(groupPosition);
        holder.cbGroup.setChecked(dataBean.isChecked());
        holder.tv_number.setText(dataBean.getSellerName());

        //给holder.cbGroup设置点击事件
        holder.cbGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBean.setChecked(holder.cbGroup.isChecked());
                PriceAndCountEvent priceAndCountEvent = computePriceAndCount(holder.cbGroup.isChecked(), groupPosition);
                selectChildAll(groupPosition, holder.cbGroup.isChecked());
                //判断列表中的checkbox是否都选中
                if (holder.cbGroup.isChecked()) {
                    //点击的一级列表checkbox是选中状态
                    setPriceAndCount(true,priceAndCountEvent.getPrice(),priceAndCountEvent.getCount());
                    if (isAllGroupListChecked()){
                        //让“全选”为选中状态
                        changeAllSelectState(true);
                    }
                }else {
                    changeAllSelectState(false);
                    setPriceAndCount(false, priceAndCountEvent.getPrice(), priceAndCountEvent.getCount());
                }
            }
        });
        return view;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view;
        final ChildViewHolder holder;
        if (convertView == null) {
            holder = new ChildViewHolder();
            view = inflater.inflate(R.layout.item_child_market, null);
            holder.cbChild = view.findViewById(R.id.cb_child);
            holder.tv_tel = view.findViewById(R.id.tv_tel);
            holder.tv_content = view.findViewById(R.id.tv_content);
            holder.tv_time = view.findViewById(R.id.tv_time);
            holder.tv_price = view.findViewById(R.id.tv_pri);
            holder.tv_del = view.findViewById(R.id.tv_del);
            holder.iv_add = view.findViewById(R.id.iv_add);
            holder.iv_del = view.findViewById(R.id.iv_del);
            holder.tv_num = view.findViewById(R.id.tv_num);
            holder.sdv=view.findViewById(R.id.sdv);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ChildViewHolder) view.getTag();
        }
        final ShowCharBean.DataBean.ListBean datasBean = childList.get(groupPosition).get(childPosition);
        holder.cbChild.setChecked(datasBean.isChecked());
        holder.tv_tel.setText(datasBean.getTitle());
        String[] split = datasBean.getImages().split("\\|");
        holder.sdv.setImageURI(split[0]);
//        holder.tv_content.setText(datasBean.getBargainPrice() + "");
//        holder.tv_time.setText(datasBean.getAdd_time());
        holder.tv_price.setText(datasBean.getBargainPrice() + "");
        holder.tv_num.setText(datasBean.getNum() + "");
        holder.tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPriceAndCount(false,datasBean.getPrice()*datasBean.getNum(),datasBean.getNum());
                childList.get(groupPosition).remove(childPosition);
                if (childList.get(groupPosition).size()==0){
                    childList.remove(groupPosition);
                    groupList.remove(groupPosition);
                }
                notifyDataSetChanged();
            }
        });
        holder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = datasBean.getNum();
                datasBean.setNum(++num);
                //判断当前是否选中
                if (datasBean.isChecked()){
                    setPriceAndCount(true,datasBean.getPrice(),1);
                }
                notifyDataSetChanged();
            }
        });
        holder.iv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = datasBean.getNum();
                if (num == 1) {
                    return;
                }
                if (datasBean.isChecked()) {
                    //把当前点击的条目对应的数量和钱，发送到MainActivity进行显示
                    setPriceAndCount(false, datasBean.getPrice(), 1);
                }
                datasBean.setNum(--num);
                notifyDataSetChanged();
            }
        });
        //给holder.cbChild设置点击事件
        holder.cbChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断点击的checkbox是否选中
                if (holder.cbChild.isChecked()) {
                    //点击的时候，holder.cbChild是选中状态
                    datasBean.setChecked(true);
                    //把当前点击的条目对应的数量和钱，发送到Fragment进行显示
                    setPriceAndCount(true, datasBean.getPrice() * datasBean.getNum(), datasBean.getNum());
                    if (isAllChildListChecked(groupPosition)) {
                        ShowCharBean.DataBean dataBean = groupList.get(groupPosition);
                        dataBean.setChecked(true);
                        //判断一下其它的一级列表中的checkbox是否都选中，如果都选中则改变全选的状态
                        if (isAllGroupListChecked()) {
                            //去改变全选的状态
                            changeAllSelectState(true);
                        }
                        notifyDataSetChanged();
                    }
                } else {
                    datasBean.setChecked(false);
                    //点击的时候，holder.cbChild是未选中状态
                    setPriceAndCount(false, datasBean.getPrice() * datasBean.getNum(), datasBean.getNum());
                    ShowCharBean.DataBean dataBean = groupList.get(groupPosition);
                    dataBean.setChecked(false);
                    //因为此时一级列表checkbox为未选中状态，所以，要把全选改成未选中
                    changeAllSelectState(false);
                    notifyDataSetChanged();
                }
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupViewHolder {
        CheckBox cbGroup;
        TextView tv_number;
    }

    class ChildViewHolder {
        CheckBox cbChild;
        TextView tv_tel;
        TextView tv_content;
        TextView tv_time;
        TextView tv_price;
        TextView tv_del;
        ImageView iv_del;
        ImageView iv_add;
        TextView tv_num;
        SimpleDraweeView sdv;
    }

    /**
     * 设置FourFragment的钱和数量
     */
    private void setPriceAndCount(boolean isAdd, int price, int count) {
        PriceAndCountEvent priceAndCountEvent = new PriceAndCountEvent();
        priceAndCountEvent.setPrice(isAdd ? price : -price);
        priceAndCountEvent.setCount(isAdd ? count : -count);
        EventBus.getDefault().post(priceAndCountEvent);
    }

    /**
     * 设置二级列表是否全选
     *
     * @param groupPosition
     * @param isSelectAll   true 表示全选 false 表示全不选
     */
    private void selectChildAll(int groupPosition, boolean isSelectAll) {
        List<ShowCharBean.DataBean.ListBean> datasBeen = childList.get(groupPosition);
        for (int i = 0; i < datasBeen.size(); i++) {
            ShowCharBean.DataBean.ListBean datasBean = datasBeen.get(i);
            datasBean.setChecked(isSelectAll);
        }
        notifyDataSetChanged();
    }

    private boolean isAllGroupListChecked() {
        for (int i = 0; i < groupList.size(); i++) {
            ShowCharBean.DataBean dataBean = groupList.get(i);
            if (!dataBean.isChecked()) {
                return false;
            }
        }
        return true;
    }
    /**
     * 改变Fragment里的状态
     */
    private void changeAllSelectState(boolean isChecked){
        MessageEvent event=new MessageEvent();
        event.setChecked(isChecked);
        EventBus.getDefault().post(event);
    }
    /**
     * 遍历二级列表数据，判断其它的checkbox是否也都选中
     *
     * @return
     */
    private boolean isAllChildListChecked(int groupPostion) {
        List<ShowCharBean.DataBean.ListBean> db = childList.get(groupPostion);
        for (int i = 0; i < db.size(); i++) {
            ShowCharBean.DataBean.ListBean datasBean = db.get(i);
            if (!datasBean.isChecked()) {
                return false;
            }
        }
        return true;
    }
    public void selectAllGroup(boolean flag) {
        int count = 0;
        int price = 0;
        //先把MainActivity里的数量和钱置为0，然后计算出所有的数量和钱就行了
        for (int i = 0; i < groupList.size(); i++) {
            List<ShowCharBean.DataBean.ListBean> datasBeen = childList.get(i);
            count += datasBeen.size();
            for (int j = 0; j < datasBeen.size(); j++) {
                price += datasBeen.get(j).getPrice();
            }
        }
        setPriceAndCount(flag, price, count);

        for (int i = 0; i < groupList.size(); i++) {
            ShowCharBean.DataBean dataBean = groupList.get(i);
            dataBean.setChecked(flag);
            selectChildAll(i, flag);
        }
        notifyDataSetChanged();
        if (!flag){
            count=0;
            price=0;
        }
        notifyDataSetChanged();
    }
    /**
     * 点击一级列表时计算钱和数量
     */
    private PriceAndCountEvent computePriceAndCount(boolean flage, int groupPoisiton) {
        int count = 0;
        int price = 0;
        List<ShowCharBean.DataBean.ListBean> datasBeen = childList.get(groupPoisiton);
        //遍历集合计算钱和数量
        for (int i = 0; i < datasBeen.size(); i++) {
            ShowCharBean.DataBean.ListBean datasBean = datasBeen.get(i);
            if (flage) {
                //判断如果是flase执行代码数量加1在原来的基础上价钱增加
                if (!datasBean.isChecked()) {
                    count++;
                    price += datasBean.getPrice();
                }
            } else {
                if (datasBean.isChecked()) {
                    count++;
                    price += datasBean.getPrice();
                }
            }
        }
        //发送消息到
        PriceAndCountEvent priceAndCountEvent = new PriceAndCountEvent();
        priceAndCountEvent.setCount(count);
        priceAndCountEvent.setPrice(price);
        return priceAndCountEvent;
    }
}