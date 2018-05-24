package com.wzq.mvp_retrofit.view.activity;

import android.app.FragmentManager;
import android.os.Bundle;

import com.wzq.mvp_retrofit.R;
import com.wzq.mvp_retrofit.base.BaseActivity;
import com.wzq.mvp_retrofit.base.IMvpView;
import com.wzq.mvp_retrofit.view.fragment.MyFragment;


/**
 * author:Created by WangZhiQiang on 2018/5/19.
 */

public class MyActivity extends BaseActivity implements IMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fl);
        MyFragment myFragment = new MyFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl,myFragment).commit();

    }


    @Override
    public void showData(String data) {

    }
}
