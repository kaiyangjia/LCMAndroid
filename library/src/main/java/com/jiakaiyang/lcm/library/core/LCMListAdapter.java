package com.jiakaiyang.lcm.library.core;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jiakaiyang.lcm.library.base.LCMBaseAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by kaiyangjia on 2016/1/21.
 */
public class LCMListAdapter<T> extends LCMBaseAdapter {
    private int ResId;
    private Map<Integer, String> mapping;

    public LCMListAdapter(Context context, List<Map<String, Object>> data, int resId, Map<Integer, String> mapping) {
        super.context = context;
        super.data = data;
        this.ResId = resId;
        this.mapping = mapping;
    }

    /**
     * 给列表项填充数据
     * @param viewHolder
     * @param position
     */
    @Override
    public void fillContent(ViewHolder viewHolder, int position) {
        for(Map.Entry<Integer, String> entry : mapping.entrySet()){
            int key = entry.getKey();
            entry.getValue();

            View view = viewHolder.getView(key);
            boolean b = view instanceof TextView;
            if(b){
                ((TextView) view).setText(entry.getValue());
            }
        }
    }

    @Override
    public int getItemResource() {
        return ResId;
    }
}
