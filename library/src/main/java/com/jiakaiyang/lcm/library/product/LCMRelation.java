package com.jiakaiyang.lcm.library.product;

import android.widget.AdapterView;

import java.util.List;
import java.util.Map;

/**
 * Created by kaiyangjia on 2016/1/22.
 *
 * 关系的产品类，代表一个列表和内容的对应关系
 * 包含关系管理等一系列方法
 * 一个对应关系由三部分组成：adapterView， Bean对象， item资源的id
 */
public class LCMRelation {
    //关系id，在一个关系列表中是唯一的
    private int id;
    //关系中的列表对象,一个对应关系中有唯一的adapterview
    private AdapterView adapterView;
    //关系中的存储每一条数据的内容对象
    private Map content;
    //条目对应的布局id
    private int resId;

    public Map getContent() {
        return content;
    }

    public void setContent(Map content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdapterView getAdapterView() {
        return adapterView;
    }

    public void setAdapterView(AdapterView adapterView) {
        this.adapterView = adapterView;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
