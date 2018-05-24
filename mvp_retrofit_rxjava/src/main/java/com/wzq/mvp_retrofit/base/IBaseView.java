package com.wzq.mvp_retrofit.base;

import android.content.Context;

/**
 * author:Created by WangZhiQiang on 2018/5/19.
 */

public interface IBaseView {
    /**
     * 显示正在加载进度框
     */
    void showLoading(String msg);
    /**
     * 显示正在加载进度框
     */
    void showLoading();
    /**
     * 隐藏正在加载进度框
     */
    void hideLoading();
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */

    /**
     * 当数据请求失败后，调用此接口提示
     * @param msg 失败原因
     */
    void showFailureMessage(String msg);

    /**
     * 当数据请求异常，调用此接口提示
     */
    void showErrorMessage();

    /**
     * 获取上下文
     * @return 上下文
     */
    Context getContext();

    /**
     * 显示提示
     * @param msg
     */
    void showToast(String msg);

}
