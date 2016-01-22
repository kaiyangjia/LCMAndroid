package com.jiakaiyang.lcm.library.manager;

import android.widget.AdapterView;

import com.jiakaiyang.lcm.library.factory.RelationFactory;
import com.jiakaiyang.lcm.library.product.LCMRelation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kaiyangjia on 2016/1/22.
 *
 * 服务提供者，提供关系的添加、移除、更新等操作
 */
public class RelationManager {
    private Map<Integer, LCMRelation> mRelations;
    private RelationFactory mRelationFactory;

    public RelationManager() {
        init();
    }

    private void init(){
        mRelations = new HashMap<>();
        mRelationFactory = RelationFactory.getInstance();
    }

    public void addRelation(){

    }

    /**
     * 绑定一个列表、一个bean和一个list条目的布局文件id，并返回一个标识该对应关系的唯一的id
     * @param mList
     * @param mBean
     * @param Resid list条目的layout 的id
     * @return
     */
    public int bind(AdapterView mList, Object mBean, int Resid){
        LCMRelation relation = mRelationFactory.createRelation(mRelations);

        relation.setContent(mBean);
        mRelations.put(relation.getId(), relation);

        return relation.getId();
    }


    /**
     * 绑定Bean的类对象和 Item Layout 中的组件id之间的映射
     * Bean中用到的类对象必须有相对应的 public 的 get 方法
     * @param map 绑定的映射，key 为 item组件的 id，value 为Bean的类成员的名称
     */
    public void buildMapping(Map<Integer, String> map, int relationId){

    }
}
