package com.example.administrator.jingdong.fragment.tab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.AddCharBean;
import com.example.administrator.jingdong.bean.DetailsBean;
import com.example.administrator.jingdong.presenter.AddcharPresenter;
import com.example.administrator.jingdong.presenter.DetailsPresenter;
import com.example.administrator.jingdong.util.Imageloader;
import com.example.administrator.jingdong.util.MySharedPreferences;
import com.example.administrator.jingdong.view.view.AddChar_view;
import com.example.administrator.jingdong.view.view.Detail_view;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 吴占彬
 * 2017/12/14
 */

public class Find_hotCollectionFragment extends Fragment implements Detail_view, AddChar_view {

    @BindView(R.id.detail_title)
    TextView detailTitle;
    @BindView(R.id.detail_price)
    TextView detailPrice;
    Unbinder unbinder;
    @BindView(R.id.findbanner)
    Banner findbanner;
    @BindView(R.id.detail_jieshao)
    TextView detailJieshao;
    @BindView(R.id.charshopping)
    ImageView charshopping;
    @BindView(R.id.addchar)
    Button addchar;
    @BindView(R.id.xiadan)
    Button xiadan;
    private int pid;
    List<String> listpath = new ArrayList<String>();
    private int uid;
    private AddcharPresenter addcharPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.findfragment, null);
        //获取uid
        uid = MySharedPreferences.getInt("uid", 0);
        //获取pid
        Intent intent = getActivity().getIntent();
        pid = intent.getIntExtra("pid", 0);
        //调用P层方法
        DetailsPresenter presenter = new DetailsPresenter(this);
        presenter.detailsdata();
        addcharPresenter = new AddcharPresenter(this);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void details(DetailsBean bean) {
        String[] split = bean.getData().getImages().split("\\|");
        //遍历集合
        for (int i = 0; i < split.length; i++) {
            listpath.add(split[i]);
        }
        //加载图片
        findbanner.setImageLoader(new Imageloader());
        //设置图片的集合
        findbanner.setImages(listpath);
        //设置圆点的样式
        findbanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //轮播间隔时间
        findbanner.setDelayTime(2000);
        findbanner.start();
        detailTitle.setText(bean.getData().getTitle());
        detailJieshao.setText(bean.getData().getSubhead());
        detailPrice.setText("￥" + bean.getData().getPrice());
    }


    @Override
    public void CharBean(AddCharBean bean) {
        Log.i("addchar", bean.getMsg());
    }

    @Override
    public int uid() {
        return uid;
    }

    @Override
    public int pid() {
        return pid;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.addchar, R.id.xiadan,R.id.charshopping})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addchar:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("加入购物车");
                builder.setMessage("你确定要加入购物车？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        addcharPresenter.chardata();
                        Toast.makeText(getActivity(), "加入购物车成功", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
                AlertDialog b = builder.create();
                b.show();
                break;
            case R.id.xiadan:
                Toast.makeText(getActivity(), "停止下单", Toast.LENGTH_LONG).show();
                break;
            case R.id.charshopping:
//                Intent intent=new Intent(getActivity(), ShopcartFragment.class);
//                getActivity().startActivity(intent);
                break;
            default:
        }
    }

}
