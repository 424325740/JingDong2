package com.example.administrator.jingdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.LunBoAdapter;
import com.example.administrator.jingdong.adapter.MiaoShaAdapter;
import com.example.administrator.jingdong.adapter.TuiJianAdapter;
import com.example.administrator.jingdong.bean.ShouYeBean;
import com.example.administrator.jingdong.presenter.ShouYePresenter;
import com.example.administrator.jingdong.util.Imageloader;
import com.example.administrator.jingdong.view.activity.ShowSousuoActivity;
import com.example.administrator.jingdong.view.view.Shouye_view;
import com.xys.libzxing.zxing.activity.CaptureActivity;
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
 * 2017/12/8
 */

public class HomeFragment extends Fragment implements Shouye_view{
    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    List<String> listpath = new ArrayList<String>();
    @BindView(R.id.home_rv)
    RecyclerView homeRv;
    @BindView(R.id.miaosha_time)
    TextView miaosha_time;
    @BindView(R.id.home_rv_tuijie)
    RecyclerView homeRvTuijie;
    @BindView(R.id.home_vp)
    ViewPager homeVp;
    @BindView(R.id.sanmiao)
    ImageView sanmiao;
    @BindView(R.id.sousuo)
    ImageView sousuo;
    @BindView(R.id.et_sousuo)
    EditText etSousuo;
    private List<ShouYeBean.MiaoshaBean.ListBeanX> miaoshalist;
    private List<ShouYeBean.TuijianBean.ListBean> tuijianList;
    private List<Fragment> fraglist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        //调用P层方法
        ShouYePresenter presenter = new ShouYePresenter(this);
        presenter.Data();
        //设置recycleview管理器
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        homeRv.setLayoutManager(manager);
        //设置recycleview管理器
        GridLayoutManager mage = new GridLayoutManager(getContext(), 2);
        homeRvTuijie.setLayoutManager(mage);
        initData();
        homeVp.setAdapter(new LunBoAdapter(getActivity().getSupportFragmentManager(), fraglist, getActivity()));
        return view;
    }

    //创建Fragment的方法
    private void initData() {
        fraglist = new ArrayList<>();
        fraglist.add(new FragmentFirst());
        fraglist.add(new Fragment2());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void Data(ShouYeBean bean) {
        miaoshalist = new ArrayList<>();
        miaoshalist.addAll(bean.getMiaosha().getList());
        tuijianList = new ArrayList<>();
        tuijianList.addAll(bean.getTuijian().getList());
        //绑定秒杀适配器
        homeRv.setAdapter(new MiaoShaAdapter(miaoshalist, getActivity()));
        homeRvTuijie.setAdapter(new TuiJianAdapter(tuijianList, getActivity()));
//        miaosha_time.setText(bean.getMiaosha().getTime());
        //遍历集合
        for (int i = 0; i < bean.getData().size(); i++) {
            String icon = bean.getData().get(i).getIcon();
            listpath.add(icon);
        }
        //加载图片
        banner.setImageLoader(new Imageloader());
        //设置图片的集合
        banner.setImages(listpath);
        //设置圆点的样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //轮播间隔时间
        banner.setDelayTime(3000);
        banner.start();
    }

    @OnClick({R.id.sanmiao, R.id.sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sanmiao:
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
                break;
            case R.id.sousuo:
//                    sousuoPresenter.sousuodata();
                    Intent intent=new Intent(getActivity(), ShowSousuoActivity.class);
                    startActivity(intent);
                break;
            default:
        }
    }


}
