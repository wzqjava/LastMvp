package com.wzq.mvpdemo.model;

import android.os.Handler;

import com.wzq.mvpdemo.base.BaseModel;
import com.wzq.mvpdemo.base.MvpCallback;

/**
 * author:Created by WangZhiQiang on 2018/5/18.
 * 模拟的请求网络的数据;
 */


public class MvpModel extends BaseModel<String>{

    @Override
    public void execute(final MvpCallback<String> callback) {
        /**
            模拟的请求网络的数据;
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (mParams[0]){
                    case "normal":
                        callback.onSuccess("根据参数"+mParams[0]+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();//隐藏进度条
            }
        },2000);
    }





}
