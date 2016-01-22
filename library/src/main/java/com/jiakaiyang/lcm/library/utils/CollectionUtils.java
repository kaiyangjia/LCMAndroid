package com.jiakaiyang.lcm.library.utils;

import com.jiakaiyang.lcm.library.product.LCMRelation;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by kaiyangjia on 2016/1/22.
 */
public class CollectionUtils {
    public static int getMaxInt(List<LCMRelation> list){
        int max = list.get(0).getId();
        for(LCMRelation i : list){
            if(i.getId() > max){
                max = i.getId();
            }
        }

        return max;
    }


    public static int getMaxInt(Map<Integer, LCMRelation> map){
        int max = -1;
        for(Integer key : map.keySet()){
            LCMRelation i = map.get(key);
            if(i.getId() > max){
                max = i.getId();
            }
        }

        return max;
    }
}
