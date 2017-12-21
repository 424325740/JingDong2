package com.example.administrator.jingdong.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.MyAdapter;
import com.example.administrator.jingdong.bean.DeleteBean;
import com.example.administrator.jingdong.bean.ShowCharBean;
import com.example.administrator.jingdong.event.MessageEvent;
import com.example.administrator.jingdong.event.PriceAndCountEvent;
import com.example.administrator.jingdong.presenter.ShowCharPresenter;
import com.example.administrator.jingdong.util.MySharedPreferences;
import com.example.administrator.jingdong.view.view.Delete_view;
import com.example.administrator.jingdong.view.view.ShowChar_view;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopcartFragment extends Fragment implements ShowChar_view,Delete_view {

    @BindView(R.id.elv)
    ExpandableListView elv;
    @BindView(R.id.checkbox2)
    CheckBox checkbox2;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_num)
    TextView tvNum;
    Unbinder unbinder;
    private int uid;
    private int totalCount;
    private int totalPrice;
    private MyAdapter adapter;
    private List<ShowCharBean.DataBean> groupList;
    private List<List<ShowCharBean.DataBean.ListBean>> childList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_shopcart, null);
        EventBus.getDefault().register(this);
        uid = MySharedPreferences.getInt("uid", 0);
        ShowCharPresenter presenter = new ShowCharPresenter(this);
        presenter.showdata();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showdata(ShowCharBean bean) {
        groupList = new ArrayList<>();
        childList = new ArrayList<>();
        for (int i = 1; i < bean.getData().size(); i++) {
            groupList.add(bean.getData().get(i));
        }
        for (int i = 0; i < groupList.size(); i++) {
            childList.add(groupList.get(i).getList());
        }
        adapter = new MyAdapter(getActivity(), groupList, childList);
        elv.setAdapter(adapter);
        elv.setGroupIndicator(null);
        //默认让其全部展开
        for (int i = 0; i < groupList.size(); i++) {
            elv.expandGroup(i);
        }
    }

    @Override
    public void deletebean(DeleteBean bean) {

    }

    @Override
    public int uid() {
        return uid;
    }

    @Override
    public int pid() {
        return 1;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        checkbox2.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        totalCount += event.getCount();
        totalPrice += event.getPrice();
        tvNum.setText("结算(" + totalCount + ")");
        tvPrice.setText(totalPrice + "");
    }

    @OnClick(R.id.checkbox2)
    public void onViewClicked() {
        adapter.selectAllGroup(checkbox2.isChecked());
    }
}
