package com.example.administrator.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.Frag2Adapter;
import com.example.administrator.jingdong.bean.FenLeiBean;
import com.example.administrator.jingdong.presenter.FenLeiPresenter;
import com.example.administrator.jingdong.view.view.IFenLei_view;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 吴占彬
 * 2017/12/4
 */

public class Fragment2 extends Fragment implements IFenLei_view {
    @BindView(R.id.first_rv)
    RecyclerView firstRv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.frag_first, null);
        unbinder = ButterKnife.bind(this, view);
        FenLeiPresenter fenLeiP=new FenLeiPresenter(this);
        fenLeiP.data();
        GridLayoutManager manager=new GridLayoutManager(getActivity(),5);
        firstRv.setLayoutManager(manager);
        return view;
    }

    @Override
    public void setcid(final List<FenLeiBean.DataBean> dataBean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Frag2Adapter adapter = new Frag2Adapter(dataBean, getActivity());
                firstRv.setAdapter(adapter);
            }
        });

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
