package com.wzq.mvp_retrofit.base;

/**
 * autho:Created by WangZhiQiang on 2018/5/21.
 * mvp 的  model层的顶级控制类;
 */

public class DataModelReflex {
    public static BaseModel request(String token){
        // 声明一个空的BaseModel
        BaseModel model = null;
        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel)Class.forName(token).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
