package com.jiakaiyang.lcm.library.core;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiakaiyang.lcm.library.R;
import com.jiakaiyang.lcm.library.base.LCMBaseAdapter;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static com.jiakaiyang.lcm.library.utils.LogUtils.LOGE;
import static com.jiakaiyang.lcm.library.utils.LogUtils.makeLogTag;

/**
 * Created by kaiyangjia on 2016/1/21.
 */
public class LCMListAdapter<T> extends LCMBaseAdapter {
    private static final String TAG = makeLogTag("LCMListAdapter");

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
        Map<String, Object> currentData = (Map<String, Object>) data.get(position);

        for(Map.Entry<Integer, String> entry : mapping.entrySet()){
            int key = entry.getKey();
            String value = entry.getValue();

            //填充文本内容
            View view = viewHolder.getView(key);
            if(view instanceof TextView){
                TextView textView = ((TextView) viewHolder.getView(key));
                String text = String.valueOf(currentData.get(value));
                textView.setText(text);
            }else if(view instanceof ImageView){//填充图片内容
                ImageView imageView = (ImageView) viewHolder.getView(key);
                String url = String.valueOf(currentData.get(value));
                Picasso.with(context).load(url).error(R.drawable.ic_launcher).into(imageView);
            }
        }
    }

    @Override
    public int getItemResource() {
        return ResId;
    }
}
