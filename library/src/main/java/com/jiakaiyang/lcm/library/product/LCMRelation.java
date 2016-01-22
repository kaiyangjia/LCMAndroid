package com.jiakaiyang.lcm.library.product;

import android.widget.AdapterView;

import java.util.List;

/**
 * Created by kaiyangjia on 2016/1/22.
 *
 * 关系的产品类，代表一个列表和内容的对应关系
 * 包含关系管理等一系列方法
 */
public class LCMRelation {
    //关系id，在一个关系列表中是唯一的
    private int id;
    //关系中的列表对象,一个内容可以对应多个列表，但是反过来不可以
    private List<AdapterView> lists;
    //关系中的存储每一条数据的内容对象
    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AdapterView> getLists() {
        return lists;
    }

    public void setLists(List<AdapterView> lists) {
        this.lists = lists;
    }
}
