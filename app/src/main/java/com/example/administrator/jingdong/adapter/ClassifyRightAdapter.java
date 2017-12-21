package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.ChildFenLeiBean;
import com.example.administrator.jingdong.view.activity.CurrentActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */

public class ClassifyRightAdapter extends BaseExpandableListAdapter {
    Context context;
    List<ChildFenLeiBean.DataBean> grouplist;
    List<List<ChildFenLeiBean.DataBean.ListBean>> childlist;

    public ClassifyRightAdapter(Context context, List<ChildFenLeiBean.DataBean> grouplist, List<List<ChildFenLeiBean.DataBean.ListBean>> childlist) {
        this.context = context;
        this.grouplist = grouplist;
        this.childlist = childlist;
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return grouplist.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childlist.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderGroup holderGroup;
        if (view == null) {
            view = View.inflate(context, R.layout.calssify_rigth_group, null);
            holderGroup = new ViewHolderGroup();
            holderGroup.Group_tv = view.findViewById(R.id.classify_right_tv);
            view.setTag(holderGroup);
        } else {
            holderGroup = (ViewHolderGroup) view.getTag();
        }
        holderGroup.Group_tv.setText(grouplist.get(i).getName());
        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderChild holderChild;
        if (view == null) {
            holderChild = new ViewHolderChild();
            view = View.inflate(context, R.layout.calssify_rigth_child, null);
            GridLayoutManager manager=new GridLayoutManager(context,3);
            holderChild.Child_gv = view.findViewById(R.id.classify_right_gv);
            holderChild.Child_gv.setLayoutManager(manager);
            view.setTag(holderChild);
        } else {
            holderChild = (ViewHolderChild) view.getTag();
        }
        Classify_Right_Child_Grid_Adapter classify_right_child_grid_adapter = new Classify_Right_Child_Grid_Adapter(context, childlist.get(i));
        holderChild.Child_gv.setAdapter(classify_right_child_grid_adapter);
        classify_right_child_grid_adapter.setOnItemClickListener(new Classify_Right_Child_Grid_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int pscid = childlist.get(i).get(i1).getPscid();
                Intent intent=new Intent(context, CurrentActivity.class);
                intent.putExtra("pscid",pscid);
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public class ViewHolderGroup {
        TextView Group_tv;
    }

    public class ViewHolderChild {
        RecyclerView Child_gv;
    }
}
