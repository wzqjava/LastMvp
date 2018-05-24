package com.cj.caojun.lastmvp.view.interfaces;

/**
 * Created by caojun on 2017/10/16.
 */

public interface IMainView<T> extends IMvpView{

    void onSuccess(T t);
    void onError(int errCode,String errMessage);
}
