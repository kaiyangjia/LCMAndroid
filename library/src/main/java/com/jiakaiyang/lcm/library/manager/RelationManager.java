package com.jiakaiyang.lcm.library.manager;

import android.content.Context;
import android.util.Log;
import android.widget.AdapterView;

import com.jiakaiyang.lcm.library.core.LCMListAdapter;
import com.jiakaiyang.lcm.library.factory.RelationFactory;
import com.jiakaiyang.lcm.library.product.LCMRelation;
import com.jiakaiyang.lcm.library.utils.LogUtils;
import com.jiakaiyang.lcm.library.utils.TypeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jiakaiyang.lcm.library.utils.LogUtils.makeLogTag;

/**
 * Created by kaiyangjia on 2016/1/22.
 *
 * 服务提供者，提供关系的添加、移除、更新等操作
 */
public class RelationManager {
    private static final String TAG = makeLogTag("RelationManager");

    private Map<Integer, LCMRelation> mRelations;
    private Map<Integer, Map> mMappings;
    private RelationFactory mRelationFactory;

    public RelationManager() {
        init();
    }

    private void init(){
        mRelations = new HashMap<>();
        mMappings = new HashMap<>();
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
        Map map = TypeUtils.getMapFromBean(mBean);
        return bind(mList, map, Resid);
    }


    /**
     * 绑定，以map对象作为传入的内容结构
     * @param mList 列表View 的对象
     * @param map 标识内容的map对象
     * @param resId 列表条目的布局id
     * @return 绑定后这个对应关系的id
     */
    public int bind(AdapterView mList, Map map, int resId){
        LCMRelation relation = mRelationFactory.createRelation(mRelations);

        relation.setContent(map);
        relation.setAdapterView(mList);
        relation.setContent(map);
        relation.setResId(resId);

        mRelations.put(relation.getId(), relation);

        return relation.getId();
    }


    /**
     * 绑定Bean的类对象和 Item Layout 中的组件id之间的映射
     * @param map 绑定的映射，key 为 item组件的 id，value 为Bean的类成员的名称
     */
    public void buildMapping(Map<Integer, String> map, int relationId){
        mMappings.put(relationId, map);
    }


    public void show(Context context, int relationId, List data){
        if(data == null
                || data.size() == 0){
            LogUtils.LOGE(TAG, "The data must not be null");
            return;
        }
        if(!mRelations.containsKey(relationId)){
            LogUtils.LOGE(TAG, "The relation id is not binded");
            return;
        }
        if(!mMappings.containsKey(relationId)){
            LogUtils.LOGE(TAG, "The relation id has not bulided the map");
            return;
        }

        Object obj = data.get(0);
        boolean isMap = obj instanceof Map;

        List<Map> dataMap = new ArrayList<>();
        if(!isMap){
            for(Object o : data){
                Map map = TypeUtils.getMapFromBean(o);
                dataMap.add(map);
            }
        }

        LCMRelation relation = mRelations.get(relationId);
        int resId = relation.getResId();
        Map mapping = mMappings.get(relationId);

        LCMListAdapter adapter = new LCMListAdapter(context, dataMap,resId, mapping);
        relation.getAdapterView().setAdapter(adapter);
    }
}
