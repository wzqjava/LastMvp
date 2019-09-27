package com.cj.caojun.lastmvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cj.caojun.lastmvp.R;
import com.cj.caojun.lastmvp.modle.bean.LoginBean;
import com.cj.caojun.lastmvp.presenter.LoginPresenter;
import com.cj.caojun.lastmvp.test.Example;
import com.cj.caojun.lastmvp.view.interfaces.ILoginView;

import java.util.HashMap;

/**
 * Created by caojun on 2017/10/16.
 */

public class LoginActivity extends BaseActivity implements ILoginView<LoginBean>{


    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Example ex=new Example();
        //Example ex 时,把 ex 引用放在栈空间， 当new Example 时 ,
        //在堆空间生成一个对象 并且 ex 指向它 ，没有任何属性值，因为你没有写构造函数
        ex.change(ex.str,ex.ch);
        // 调用 方法 ，看方法分析！

        System.out.print(ex.str+"and");
        System.out.print(ex.ch);
        Log.e("myMessage",""+ex.str+" and "+ex.ch[0]);
    }

    @Override
    void initView() {

    }

    @Override
    void initData() {

        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);


        HashMap<String,String> loginMap = new HashMap<>();
        loginMap.put("userPassword","123456");
        loginMap.put("userPhone","18611620301");
        loginPresenter.userLogin(loginMap);

    }

    @Override
    public void loginSuccess(LoginBean str) {

    }

    @Override
    public void loginFailed() {

    }
}
