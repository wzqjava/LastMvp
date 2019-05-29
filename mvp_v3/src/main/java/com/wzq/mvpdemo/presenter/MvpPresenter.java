package com.wzq.mvpdemo.presenter;

import com.wzq.mvpdemo.base.BasePresenter;
import com.wzq.mvpdemo.base.DataModel;
import com.wzq.mvpdemo.base.IMvpView;
import com.wzq.mvpdemo.base.MvpCallback;
import com.wzq.mvpdemo.base.Token;

/**
 * author:Created by WangZhiQiang on 2018/5/18.
 * 业务逻辑
 * Presenter 为业务处理层，既能调用UI逻辑，又能请求数据，该层为纯Java类，不涉及任何Android API。
 * Presenter类是具体的逻辑业务处理类，该类为纯Java类，不包含任何Android API，负责请求数据，并对数据请求的反馈进行处理。
 * Presenter类的构造方法中有一个View接口的参数，是为了能够通过View接口通知Activity进行更新界面等操作。
 */

public class MvpPresenter extends BasePresenter<IMvpView> {

    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    public void getData(String params) {
        //显示正在加载进度条
        getView().showLoading();
        // 调用Model请求数据
        DataModel   //model层的顶级分发类;
                .request(Token.API_USER_DATA)   //利用反射获得对应Model对象的引用,运行时这个是MvpModel;
                .params(params) //添加请求参数;
                .execute(new MvpCallback<String>() {

                    @Override
                    public void onSuccess(String data) {
                        getView().showData(data);
                    }

                    @Override
                    public void onFailure(String msg) {
                        //调用view接口提示失败信息
                        getView().showFailureMessage(msg);
                    }

                    @Override
                    public void onError() {
                        //调用view接口提示请求异常
                        getView().showErrorMessage();
                    }

                    @Override
                    public void onComplete() {
                        // 隐藏正在加载进度条
                        getView().hideLoading();
                    }
                });
    }
}
