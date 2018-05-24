package com.wzq.mvpdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wzq.mvpdemo.presenter.MvpPresenter;
import com.wzq.mvpdemo.R;
import com.wzq.mvpdemo.base.BaseActivity;
import com.wzq.mvpdemo.base.IMvpView;

/**
 * UI 逻辑的处理
 * 上图中 IView 和 Callback 都是以接口的形式存在的
 */
public class MainActivity extends BaseActivity implements IMvpView {

    TextView text;
    MvpPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);

        //初始化Presenter
        presenter = new MvpPresenter();
        presenter.attachView(this);
    }
    // button 点击事件调用方法
    public void getData(View view){
        presenter.getData("normal");
    }
    // button 点击事件调用方法
    public void getDataForFailure(View view){
        presenter.getData("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(View view){
        presenter.getData("error");
    }

    public void goMyActivity(View view){
        startActivity(new Intent(this,MyActivity.class));
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        text.setText(msg);
    }



}