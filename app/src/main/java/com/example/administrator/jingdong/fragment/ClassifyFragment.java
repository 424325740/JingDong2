package com.example.administrator.jingdong.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.ClassifyRightAdapter;
import com.example.administrator.jingdong.adapter.FenLeileftAdapter;
import com.example.administrator.jingdong.bean.ChildFenLeiBean;
import com.example.administrator.jingdong.bean.FenLeiBean;
import com.example.administrator.jingdong.presenter.ChildfenleiPresenter;
import com.example.administrator.jingdong.presenter.FenLeiPresenter;
import com.example.administrator.jingdong.view.view.Childfenlei_view;
import com.example.administrator.jingdong.view.view.IFenLei_view;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends Fragment implements IFenLei_view, Childfenlei_view {


    @BindView(R.id.fragtow_lv)
    RecyclerView fragtowLv;
    @BindView(R.id.fragtow_el)
    ExpandableListView fragtowEl;
    Unbinder unbinder;
    private List<FenLeiBean.DataBean> list;
    private int cid = 1;
    private List<List<ChildFenLeiBean.DataBean.ListBean>> childList;
    private ChildfenleiPresenter childfenleiPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify, container, false);
        unbinder = ButterKnife.bind(this, view);
        //实例化P层
        FenLeiPresenter presenter = new FenLeiPresenter(this);
        presenter.data();
        //实例化子分类下的P层
        childfenleiPresenter = new ChildfenleiPresenter(this);
        childfenleiPresenter.ChildData();
        //加载recycleview布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        fragtowLv.setLayoutManager(manager);
        return view;
    }

    @Override
    public void setcid(final List<FenLeiBean.DataBean> dataBean) {
        list = dataBean;
        FenLeileftAdapter adapter = new FenLeileftAdapter(getActivity(), list);
        fragtowLv.setAdapter(adapter);
        //点击事件
        adapter.setOnItemClickListener(new FenLeileftAdapter.OnItemClickLister() {
            @Override
            public void onItemClick(View view, int position) {
                cid = dataBean.get(position).getCid();
                Log.i("qwe", cid + "");
                childfenleiPresenter.ChildData();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void childdata(List<ChildFenLeiBean.DataBean> grouplist) {
        childList = new ArrayList<>();
        for (ChildFenLeiBean.DataBean date : grouplist) {
            List<ChildFenLeiBean.DataBean.ListBean> list = date.getList();
            childList.add(list);
        }
        fragtowEl.setAdapter(new ClassifyRightAdapter(getActivity(), grouplist, childList));
        fragtowEl.setDivider(null);
        for (int i = 0; i < grouplist.size(); i++) {
            fragtowEl.expandGroup(i);

        }
    }

    @Override
    public int cid() {
        return cid;
    }

}
