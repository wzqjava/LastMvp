package com.wzq.mvp_retrofit.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wzq.mvp_retrofit.R;
import com.wzq.mvp_retrofit.base.BaseFragment;
import com.wzq.mvp_retrofit.base.IMvpView;
import com.wzq.mvp_retrofit.presenter.TestRetrofitPresenter;


/**
 * author:Created by WangZhiQiang on 2018/5/19.
 */

public class NotificationFragment extends BaseFragment implements IMvpView {

    private TestRetrofitPresenter testRetrofitPresenter;
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

        testRetrofitPresenter = new TestRetrofitPresenter();
        testRetrofitPresenter.attachView(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofitPresenter.getData("normal");
            }
        });

    }



    @Override
    public int getContentViewId() {
        return R.layout.fragment_home;
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
