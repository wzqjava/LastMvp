package com.cj.caojun.lastmvp.presenter;

import android.util.Log;

import com.cj.caojun.lastmvp.application.Constans;
import com.cj.caojun.lastmvp.modle.bean.Register;
import com.cj.caojun.lastmvp.modle.http.IonNet;
import com.cj.caojun.lastmvp.modle.http.OkHttpUtilsForPost;
import com.cj.caojun.lastmvp.view.interfaces.IMainView;
import com.cj.caojun.lastmvp.view.interfaces.IMvpView;

import java.util.HashMap;

/**
 * Created by caojun on 2017/10/16.
 */

public class MainPresenter extends BasePresenter<IMainView> implements IonNet<Register> {

    public MainPresenter() {
        httpUtilsForPost.onCallBack(this);
    }



    public void loadDataFromServer(HashMap<String,String> params) {
        httpUtilsForPost.doPost(Constans.BASE_URL+Constans.REGIST,params, Register.class);

    }

    @Override
    public void onSuccess(Register register) {
        Log.e("myMessage","code == "+register.getCode());
    }
}
