package com.cj.caojun.lastmvp.presenter;

import com.cj.caojun.lastmvp.modle.http.OkHttpUtilsForPost;
import com.cj.caojun.lastmvp.view.interfaces.IMvpView;

/**
 * Created by caojun on 2017/10/16.
 */

public class BasePresenter<H extends IMvpView> {
    public final OkHttpUtilsForPost httpUtilsForPost;

    public BasePresenter() {
        httpUtilsForPost = OkHttpUtilsForPost.getInstance();
    }

    private H mh;

    public void attachView(H h) {
        //IMainView view = MainActivity
        this.mh = h;
    }

    public void dettachView() {
        this.mh = null;
    }
}
