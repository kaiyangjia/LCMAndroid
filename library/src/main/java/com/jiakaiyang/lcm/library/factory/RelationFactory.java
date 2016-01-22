package com.jiakaiyang.lcm.library.factory;

import com.jiakaiyang.lcm.library.product.LCMRelation;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.jiakaiyang.lcm.library.utils.CollectionUtils.getMaxInt;

/**
 * Created by kaiyangjia on 2016/1/22.
 */
public class RelationFactory {
    private static RelationFactory instance = new RelationFactory();

    private RelationFactory(){

    }

    /**
     * 单例模式获取工厂实例
     * @return
     */
    public static RelationFactory getInstance(){
        return instance;
    }


    private LCMRelation createRelation(){
        return new LCMRelation();
    }


    /**
     * 根据已有的id创建id不重复的关系
     * @param map
     * @return
     */
    public LCMRelation createRelation(Map<Integer, LCMRelation> map){
        LCMRelation relation = createRelation();
        relation.setId(getMaxInt(map) + 1);
        return relation;
    }
}
