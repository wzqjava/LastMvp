package com.wzq.mvpdemo.base;

/**
 * author:Created by WangZhiQiang on 2018/5/18.
 * iew 中定义了 Activity 的具体操作，主要是些将请求到的数据在界面中更新之类的。
 */


public interface IMvpView extends IBaseView{

    void showData(String data);


}