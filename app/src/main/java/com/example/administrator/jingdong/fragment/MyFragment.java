package com.example.administrator.jingdong.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.util.MySharedPreferences;
import com.example.administrator.jingdong.view.activity.LoginActivity;
import com.example.administrator.jingdong.view.activity.ShwoAddressActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    @BindView(R.id.head_iv)
    ImageView headIv;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.layout_login)
    RelativeLayout layoutLogin;
    @BindView(R.id.orderWaitDriveTextView)
    TextView orderWaitDriveTextView;
    @BindView(R.id.orderWaitReceiptTextView)
    TextView orderWaitReceiptTextView;
    @BindView(R.id.orderWaitCommentTextView)
    TextView orderWaitCommentTextView;
    @BindView(R.id.orderWaitRefundTextView)
    TextView orderWaitRefundTextView;
    @BindView(R.id.orderWaitPayTextView)
    TextView orderWaitPayTextView;
    @BindView(R.id.orderLinearLayout)
    LinearLayout orderLinearLayout;
    @BindView(R.id.propertyMoneyTextView)
    TextView propertyMoneyTextView;
    @BindView(R.id.propertyCardTextView)
    TextView propertyCardTextView;
    @BindView(R.id.propertyVouchersTextView)
    TextView propertyVouchersTextView;
    @BindView(R.id.propertyRedTextView)
    TextView propertyRedTextView;
    @BindView(R.id.propertyIntegralTextView)
    TextView propertyIntegralTextView;
    @BindView(R.id.propertyLinearLayout)
    LinearLayout propertyLinearLayout;
    @BindView(R.id.shopWaitDriveTextView)
    TextView shopWaitDriveTextView;
    @BindView(R.id.dianpuWaitReceiptTextView)
    TextView dianpuWaitReceiptTextView;
    @BindView(R.id.contentorderWaitCommentTextView)
    TextView contentorderWaitCommentTextView;
    @BindView(R.id.liuWaitRefundTextView)
    TextView liuWaitRefundTextView;
    @BindView(R.id.olineLinearLayout)
    LinearLayout olineLinearLayout;
    @BindView(R.id.activeWaitDriveTextView)
    TextView activeWaitDriveTextView;
    @BindView(R.id.shequpuWaitReceiptTextView)
    TextView shequpuWaitReceiptTextView;
    @BindView(R.id.kehuorderWaitCommentTextView)
    TextView kehuorderWaitCommentTextView;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.aolineLinearLayout)
    LinearLayout aolineLinearLayout;
    Unbinder unbinder;
    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, view);
        String name = MySharedPreferences.getString("loginname", "loginname");
        login.setText(name.toString());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.head_iv, R.id.login,R.id.dizhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_iv:
                break;
            case R.id.login:
                intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
            case R.id.dizhi:
                intent =new Intent(getActivity(), ShwoAddressActivity.class);
                startActivity(intent);
            default:
        }
    }

}
