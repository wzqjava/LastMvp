package com.wzq.mvp_retrofit.model.http;

import com.apkfuns.logutils.LogUtils;
import com.wzq.mvp_retrofit.base.BaseModel;
import com.wzq.mvp_retrofit.base.IMvpCallback;
import com.wzq.mvp_retrofit.model.bean.Translation1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by WangZhiQiang on 2018/5/23.
 */

public class RetrofitPostModel  extends BaseModel{
    @Override
    public void execute(final IMvpCallback iMvpCallbackImpl) {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequest_Interface request =  retrofit.create(GetRequest_Interface.class);

        Call<Translation1> call = request.postCall(mParams[0]);
        call.enqueue(new Callback<Translation1>() {
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                LogUtils.e(response.body());
                LogUtils.e(response.body().getTranslateResult().get(0).get(0).getTgt());
                iMvpCallbackImpl.onSuccess(response);
                iMvpCallbackImpl.onComplete();//隐藏进度条
            }

            @Override
            public void onFailure(Call<Translation1> call, Throwable t) {
                System.out.println("请求失败");
                LogUtils.e( t.getMessage());

            }
        });



    }


}
