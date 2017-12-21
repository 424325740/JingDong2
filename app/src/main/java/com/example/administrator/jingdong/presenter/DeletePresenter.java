package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.DeleteBean;
import com.example.administrator.jingdong.model.DeleteModel;
import com.example.administrator.jingdong.model.IModel.IDeleteModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.Delete_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/16
 */

public class DeletePresenter {
    private IDeleteModel model;
    private Delete_view view;

    public DeletePresenter(Delete_view view) {
        this.view = view;
        model=new DeleteModel();
    }
    public void deletedata(){
        int pid = view.pid();
        int uid = view.uid();
        Map<String,String> map=new HashMap<>();
        map.put("pid",pid+"");
        map.put("uid",uid+"");
        map.put("source","android");
        model.delete(map, new OnNetLinsenter<DeleteBean>() {
            @Override
            public void ChengGong(DeleteBean bean) {
                view.deletebean(bean);
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
