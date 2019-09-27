package com.wzq.mvp_retrofit.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.wzq.mvp_retrofit.R;
import com.wzq.mvp_retrofit.base.BaseFragment;
import com.wzq.mvp_retrofit.base.IMvpView;
import com.wzq.mvp_retrofit.presenter.RetrofitPostPresenter;
import com.wzq.mvp_retrofit.presenter.TestRetrofitPresenter;


/**
 * author:Created by WangZhiQiang on 2018/5/19.
 */

public class HomeFragment extends BaseFragment implements IMvpView {

    private TestRetrofitPresenter testRetrofitPresenter;
    private TextView text;
    private Button btn,btn2;
    private RetrofitPostPresenter retrofitPostPresenter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        text = mRootView.findViewById(R.id.text);
        btn =  mRootView.findViewById(R.id.btn);
        btn2 =  mRootView.findViewById(R.id.btn2);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testRetrofitPresenter = new TestRetrofitPresenter();
        retrofitPostPresenter = new RetrofitPostPresenter();
        testRetrofitPresenter.attachView(this);
        retrofitPostPresenter.attachView(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 用retrofit请求网络
                 *   步骤1：添加Retrofit库的依赖
                     步骤2：创建 接收服务器返回数据 的类
                     步骤3：创建 用于描述网络请求 的接口
                     步骤4：创建 Retrofit 实例
                     步骤5：创建 网络请求接口实例 并 配置网络请求参数
                     步骤6：发送网络请求（采用最常用的异步方式）
                 */
                testRetrofitPresenter.getData("normal");  //测试假数据;

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可以去到数据,javabean不对,会crash;
//                retrofitPostPresenter.getData("i love you");
            }
        });

    }

    private void requestRetrofitPost() {


    }






    @Override
    public void showFailureMessage(String msg) {

    }


    @Override
    public void showData(String data) {
        LogUtils.e(data);
        text.setText(data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        testRetrofitPresenter.detachView();
        retrofitPostPresenter.detachView();
    }
}
