package com.cj.caojun.lastmvp.view.interfaces;

/**
 * Created by caojun on 2017/10/16.
 */

public interface ILoginView<T> extends IMvpView {

    void loginSuccess(T str);
    void loginFailed();
}
