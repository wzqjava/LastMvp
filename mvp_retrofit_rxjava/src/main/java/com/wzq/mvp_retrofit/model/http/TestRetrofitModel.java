package com.wzq.mvp_retrofit.model.http;

import android.os.Handler;

import com.wzq.mvp_retrofit.base.BaseModel;
import com.wzq.mvp_retrofit.base.IMvpCallback;
import com.wzq.mvp_retrofit.model.bean.Translation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * author:Created by WangZhiQiang on 2018/5/18.
 * 模拟的请求网络的数据;
 */


public class TestRetrofitModel extends BaseModel<String> {

    @Override
    public void execute(final IMvpCallback<String> iMvpCallbackImpl) {
        /**
            模拟的请求网络的数据;
         */
//        getData(iMvpCallbackImpl);

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        //对 发送请求 进行封装
        Call<Translation> call = request.getCall();

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // 步骤7：处理返回的数据结果
                response.body().show();
                System.out.println("连接成功");
                iMvpCallbackImpl.onSuccess("根据参数"+mParams[0]+"的请求网络数据成功");
                iMvpCallbackImpl.onComplete();//隐藏进度条
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                System.out.println("连接失败");
                iMvpCallbackImpl.onFailure("请求失败：参数有误");
                iMvpCallbackImpl.onComplete();//隐藏进度条
            }
        });

    }

    private void getData(final IMvpCallback<String> iMvpCallbackImpl) {

                new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (mParams[0]){
                    case "normal":
                        iMvpCallbackImpl.onSuccess("根据参数"+mParams[0]+"的请求网络数据成功");
                        break;
                    case "failure":
                        iMvpCallbackImpl.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        iMvpCallbackImpl.onError();
                        break;
                }
                iMvpCallbackImpl.onComplete();//隐藏进度条
            }
        },2000);
    }
}


