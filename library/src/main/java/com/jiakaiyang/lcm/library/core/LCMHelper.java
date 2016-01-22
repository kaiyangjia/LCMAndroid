package com.jiakaiyang.lcm.library.core;

import android.widget.AdapterView;

import com.jiakaiyang.lcm.library.manager.RelationManager;

import java.util.List;
import java.util.Map;

/**
 * Created by kaiyangjia on 2016/1/17.
 *
 * 该类是用户直接使用进行操作的类，主要功能是给用户提供一套方便的使用方法
 * 而不处理核心的业务
 */
public class LCMHelper {
    private RelationManager mRelationManager;

    public LCMHelper() {
        mRelationManager = new RelationManager();
    }

    /**
     * 以某个对应关系展示数据
     * @param relationId
     */
    public void show(int relationId){

    }


    public int addRelation(AdapterView mList, Object mBean, int Resid, Map<Integer, String> map){
        int id = mRelationManager.bind(mList, mBean, Resid);
        mRelationManager.buildMapping(map, id);

        return id;
    }


    /**
     * 更新某个对应关系，该关系关联的所有list都将会更新
     * @param relationId
     */
    public void update(int relationId){

    }


    /**
     * 更新某个列表
     * @param mList
     */
    public void update(AdapterView mList){

    }
}
