package com.cj.caojun.lastmvp.view.activity;


import android.os.Bundle;
import android.util.Log;

import com.cj.caojun.lastmvp.R;
import com.cj.caojun.lastmvp.modle.bean.Project;
import com.cj.caojun.lastmvp.modle.bean.Student;
import com.cj.caojun.lastmvp.presenter.MainPresenter;
import com.cj.caojun.lastmvp.view.customview.MyViewGroup;
import com.cj.caojun.lastmvp.view.interfaces.IMainView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements IMainView {

    private MainPresenter mainPresenter;
    private ArrayList<Student> stus;
    private MyViewGroup myViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // testRxjava();
        //testRxjava2();
    }

    private void testRxjava2() {
        stus = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setName("s" + i);
            ArrayList<Project> pros = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                Project p = new Project();
                p.setName(student.getName() + " == project" + j);
                pros.add(p);
            }
            student.setProjects(pros);
            stus.add(student);
        }


        Observable.create(new ObservableOnSubscribe<Student>() {
            @Override
            public void subscribe(ObservableEmitter<Student> emitter) throws Exception {
                for (int i = 0; i < stus.size(); i++) {
                    emitter.onNext(stus.get(i));
                }
            }
        }).flatMap(new Function<Student, ObservableSource<Project>>() {
            @Override
            public ObservableSource<Project> apply(Student student) throws Exception {
                return Observable.fromIterable(student.getProjects()).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<Project>() {
            @Override
            public void accept(Project s) throws Exception {
                Log.d("myMessage", s.getName());
            }
        });

    }

    private void testRxjava() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d("myMessage", "Observable thread is : " + Thread.currentThread().getName());
                Log.d("myMessage", "emit 1");
                emitter.onNext(1);
            }
        });

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d("myMessage", "Observer thread is :" + Thread.currentThread().getName());
                Log.d("myMessage", "onNext: " + integer);
            }
        };

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);


    }

    @Override
    void initView() {
        myViewGroup = findViewById(R.id.myViewGroup);

    }

    @Override
    void initData() {
        //new
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);

        HashMap<String, String> map = new HashMap();
        map.put("userName", "cjcj321");
        map.put("userPassword", "123456");
        map.put("userPhone", "18611620301");
        map.put("userSex", "男");

        mainPresenter.loadDataFromServer(map);

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(int errCode, String errMessage) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.dettachView();
    }
}
