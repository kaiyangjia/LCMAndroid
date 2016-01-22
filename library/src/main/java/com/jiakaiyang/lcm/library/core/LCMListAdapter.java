package com.jiakaiyang.lcm.library.core;

import android.content.Context;

import com.jiakaiyang.lcm.library.base.LCMBaseAdapter;

import java.util.List;

/**
 * Created by kaiyangjia on 2016/1/21.
 */
public class LCMListAdapter<T> extends LCMBaseAdapter {

    public LCMListAdapter(Context context, List<T> data) {
        super.context = context;
        super.data = data;
    }

    /**
     * 给列表项填充数据
     * @param viewHolder
     * @param position
     */
    @Override
    public void fillContent(ViewHolder viewHolder, int position) {

    }

    @Override
    public int getItemResource() {
        return 0;
    }
}
