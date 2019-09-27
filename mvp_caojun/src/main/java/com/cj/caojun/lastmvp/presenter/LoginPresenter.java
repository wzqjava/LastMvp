package com.cj.caojun.lastmvp.presenter;

import android.util.Log;

import com.cj.caojun.lastmvp.application.Constans;
import com.cj.caojun.lastmvp.modle.bean.LoginBean;
import com.cj.caojun.lastmvp.modle.bean.Register;
import com.cj.caojun.lastmvp.modle.http.IonNet;
import com.cj.caojun.lastmvp.modle.http.OkHttpUtilsForPost;
import com.cj.caojun.lastmvp.view.interfaces.ILoginView;

import java.util.HashMap;

/**
 * Created by caojun on 2017/10/16.
 */

public class LoginPresenter extends BasePresenter<ILoginView> implements IonNet<LoginBean> {


    public LoginPresenter() {
        httpUtilsForPost.onCallBack(this);
    }

    public void userLogin(HashMap<String,String> params) {
        httpUtilsForPost.doPost(Constans.BASE_URL+Constans.LOGIN,params, LoginBean.class);

    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        //Log.e("myMessage","user == "+loginBean.getUser().getUserPhone());
    }
}
