package com.africa.common.mvpbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.africa.common.widget.CommonToast;

import java.lang.reflect.ParameterizedType;

public class BaseActivity<T extends BasePresenter, M extends BaseModel> extends AppCompatActivity implements BaseView {

  protected T mPresenter;
  private M mModel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (mPresenter == null) {
      mPresenter = getT(this, 0);
    }
    mModel = getT(this, 1);
    mPresenter.attachModelView(mModel, this);
  }

  @Override
  public void showToast(String msg) {
    CommonToast.normarlStyle(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mPresenter.onDettach();
    mPresenter.dispose();
  }

  //通过反射获取实例
  private <T> T getT(Object o, int i) {
    try {
      Class childClass = getChildClass(o.getClass());
      return ((Class<T>) ((ParameterizedType) (childClass.getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private Class getChildClass(Class aClass) {
    Class superclass = aClass.getSuperclass();
    if (superclass != null) {
      if (superclass.isAssignableFrom(BaseActivity.class)) {
        return aClass;
      } else {
        return getChildClass(superclass);
      }
    }
    return null;
  }
}
