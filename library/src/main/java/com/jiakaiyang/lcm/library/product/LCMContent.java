package com.jiakaiyang.lcm.library.product;

import java.util.List;
import java.util.Map;

/**
 * Created by kaiyangjia on 2016/1/22.
 *
 * 内容的产品类，表示一个列表项的内容以及其展示形式
 */
public class LCMContent {
    //每一条内容的名称的列表，每一个名称必须是唯一的
    private List<String> names;
    //内容的没成对应的类型，可以是文本、图片等,此处指的是数据的描述方式，而不是view的展示方式
//    private List<Map<String, Constant.CONTENT_TYPE>> types;
}
