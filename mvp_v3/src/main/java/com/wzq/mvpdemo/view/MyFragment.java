package com.wzq.mvpdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wzq.mvpdemo.R;
import com.wzq.mvpdemo.base.BaseFragment;
import com.wzq.mvpdemo.base.IMvpView;
import com.wzq.mvpdemo.presenter.MvpPresenter;

/**
 * author:Created by WangZhiQiang on 2018/5/19.
 */

public class MyFragment extends BaseFragment implements IMvpView{

    private MvpPresenter mvpPresenter;
    private TextView text;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mvpPresenter = new MvpPresenter();
        mvpPresenter.attachView(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvpPresenter.getData("normal");
            }
        });


    }



    @Override
    public int getContentViewId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        text = (TextView) mRootView.findViewById(R.id.text);
        btn = (Button) mRootView.findViewById(R.id.btn);


    }

    @Override
    public void showFailureMessage(String msg) {

    }


    @Override
    public void showData(String data) {
        Log.e("wzq",data);
        text.setText(data);
    }
}
