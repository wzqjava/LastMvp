package com.wzq.mvp_retrofit.presenter;

import com.apkfuns.logutils.LogUtils;
import com.wzq.mvp_retrofit.base.BasePresenter;
import com.wzq.mvp_retrofit.base.DataModelReflex;
import com.wzq.mvp_retrofit.base.DataModelToken;
import com.wzq.mvp_retrofit.base.IMvpCallback;
import com.wzq.mvp_retrofit.base.IMvpView;
import com.wzq.mvp_retrofit.model.bean.Translation1;

/**
 * author:Created by WangZhiQiang on 2018/5/23.
 */

public class RetrofitPostPresenter extends BasePresenter<IMvpView>{


    public void getData(String param) {
        getView().showLoading();
        DataModelReflex
                .request(DataModelToken.API_RETROFIT_POST)
                .params(param)
                .execute(new IMvpCallback<Translation1>() {
                    @Override
                    public void onSuccess(Translation1 o) {
//                        getView().showData(o);
                        LogUtils.e(o);
                    }

                    @Override
                    public void onFailure(String msg) {

                    }

                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
