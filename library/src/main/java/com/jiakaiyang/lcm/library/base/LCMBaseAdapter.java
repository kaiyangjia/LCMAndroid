package com.jiakaiyang.lcm.library.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by kaiyangjia on 2016/1/21.
 *
 * 基础适配器类，提供适配器通用的功能
 */
public abstract class LCMBaseAdapter<T> extends BaseAdapter{
    protected Context context;
    protected List<T> data;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        if (position >= data.size())
            return null;
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(getItemResource(), null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        fillContent(viewHolder, position);
        return convertView;
    }


    /**
     * 给每一个convertView的组件填充内容
     * @param viewHolder
     * @param position
     */
    public abstract void fillContent(ViewHolder viewHolder, int position);

    /**
     * 该方法需要子类实现，需要返回item布局的resource id
     * @return
     */
    public abstract int getItemResource();


    protected class ViewHolder {
        private SparseArray<View> views = new SparseArray<View>();
        private View convertView;

        public ViewHolder(View convertView) {
            this.convertView = convertView;
        }

        @SuppressWarnings("unchecked")
        public <T extends View> T getView(int resId) {
            View v = views.get(resId);
            if (null == v) {
                v = convertView.findViewById(resId);
                views.put(resId, v);
            }
            return (T) v;
        }
    }
}
