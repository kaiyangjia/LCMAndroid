package com.jiakaiyang.lcm.library.core;

import android.widget.AdapterView;

import java.util.List;
import java.util.Map;

/**
 * Created by kaiyangjia on 2016/1/17.
 *
 * 该类是用户直接使用进行操作的类，主要功能是给用户提供一套方便的使用方法
 * 而不处理核心的业务
 */
public class LCMHelper {
    public LCMHelper() {

    }

    /**
     * 以某个对应关系展示数据
     * @param relationId
     */
    public void show(int relationId){

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

    /**
     * 绑定一个列表、一个bean和一个list条目的布局文件id，并返回一个标识该对应关系的唯一的id
     * @param mList
     * @param mBean
     * @param Resid list条目的layout 的id
     * @return
     */
    public int bind(AdapterView mList, Object mBean, int Resid){
        int i = 0;

        return i;
    }


    /**
     * 绑定Bean的类对象和 Item Layout 中的组件id之间的映射
     * Bean中用到的类对象必须有相对应的 public 的 get 方法
     * @param map 绑定的映射，key 为 item组件的 id，value 为Bean的类对象的名称
     */
    public void buildMapping(Map<Integer, String> map){

    }
}
