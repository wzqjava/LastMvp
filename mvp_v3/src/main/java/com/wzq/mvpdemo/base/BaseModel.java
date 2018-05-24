package com.wzq.mvpdemo.base;

import java.util.Map;



/**
 * author:Created by WangZhiQiang on 2018/5/21.
 */

public abstract class BaseModel<T> {

    //数据请求参数
    protected String[] mParams;
    /**
     * 设置数据请求参数
     * @param mParams 参数数组
     */
    public  BaseModel params(String... mParams){
        this.mParams = mParams; //返回自己对象的引用,这个对象是用反射创建的;
        return this;
    }
    // 添加Callback并执行数据请求
    // 具体的数据请求由子类实现
    public abstract void execute(MvpCallback<T> callback);
    // 执行Get网络请求，此类看需求由自己选择写与不写
    protected void requestGetAPI(String url,MvpCallback<T> callback){
        //这里写具体的网络请求
    }
    // 执行Post网络请求，此类看需求由自己选择写与不写
    protected void requestPostAPI(String url, Map params, MvpCallback<T> callback){
        //这里写具体的网络请求
    }

}
