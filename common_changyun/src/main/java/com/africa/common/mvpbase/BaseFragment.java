package com.africa.common.mvpbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseFragment<T extends BasePresenter, M extends BaseModel> extends Fragment implements BaseView {
  protected T mPresenter;
  private M mModel;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mPresenter = getT(this, 0);
    mModel = getT(this, 1);
    mPresenter.attachModelView(mModel, this);
  }

  @Override
  public void showToast(String msg) {
    Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mPresenter.onDettach();
    mPresenter.dispose();
  }

  //通过反射获取实例
  public <K> K getT(Object o, int i) {
    try {
      Type genericSuperclass = o.getClass().getGenericSuperclass();
      ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
      Class<K> kClass = (Class<K>) genericSuperclass1.getActualTypeArguments()[i];
      return kClass.newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
