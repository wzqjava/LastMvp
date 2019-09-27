package com.africa.common.mvpbase;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {

    protected M model;
    private V view;
    private WeakReference<V> mViewRef;

    private CompositeDisposable mCompositeDisposable;

    /**
     * 需要将disposable 添加到 mCompositeDisposable，用于页面销毁时取消 任务防止内存泄漏
     */
    public void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    public void dispose() {
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    void attachModelView(M pModel, V pView) {
        this.model = pModel;
        mViewRef = new WeakReference<>(pView);
    }

    boolean isAttach() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * @return 由于页面关闭回收，在子类调用时可能返回空，所以在调用处需要加判空
     */
    protected V getView() {
        if (isAttach()) {
            return mViewRef.get();
        } else {
            return null;
        }
    }

    public void onDettach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
