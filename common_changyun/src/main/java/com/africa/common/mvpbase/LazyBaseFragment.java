package com.africa.common.mvpbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * 用于 viewpager+fragment  懒加载
 *
 * @author changyun
 */
public abstract class LazyBaseFragment extends Fragment {

  // Fragment的View加载完毕的标记
  private boolean isViewCreated;
  // Fragment对用户可见的标记
  private boolean isUIVisible;
  private boolean isVisibleToUser;

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initView(view);
    isViewCreated = true;
		/*  由于 setUserVisibleHint 先于 onCreateView 和 onViewCreated ，
            所以第一页显示时会 回调 setUserVisibleHint触发lazyLoad();
            但是由于isViewCreated 为false 所以不进行加载
		    所以 下面语句用于 第一页加载 。 由于其他页面 getUserVisibleHint 为false
            所以不会影响其他页面的 懒加载*/
    if (getUserVisibleHint()) {
      loadData();
      isViewCreated = false;
      isUIVisible = false;
    }
  }

  protected abstract void loadData();

  protected abstract void initView(View view);

  private void lazyLoad() {
		/* 这里进行双重标记判断,是因为setUserVisibleHint会多次回调,
           并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,
           才加载数据*/
    if (isViewCreated && isUIVisible) {
      loadData();
      // 数据加载完毕,恢复标记,防止重复加载
      isViewCreated = false;
      isUIVisible = false;
    }
  }

  @Override
  public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    this.isVisibleToUser = isVisibleToUser;
    if (isVisibleToUser) {
      isUIVisible = true;
      lazyLoad();
    } else {
      isUIVisible = false;
    }
  }

}