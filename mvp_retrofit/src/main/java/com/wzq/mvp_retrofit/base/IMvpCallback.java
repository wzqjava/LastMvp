package com.wzq.mvp_retrofit.base;

/**
 * author:Created by WangZhiQiang on 2018/5/18.
 * Callback 中定义了请求数据时反馈的各种状态：成功、失败、异常等。
 *
 * Callback接口中的onSuccess()方法需要根据请求数据类型的不同设置为不同类型的参数，
 * 所以每当有新的数据类型都需要新建一个Callback，解决方法是引入泛型的概念，
 * 用调用者去定义具体想要接收的数据类型：
 */

public interface IMvpCallback<T> {
    /**
     * 数据请求成功
     * @param t 请求到的数据
     */
    void onSuccess(T t);
    /**
     *  使用网络API接口请求方式时，虽然已经请求成功但是由
     *  于{@code msg}的原因无法正常返回数据。
     */
    void onFailure(String msg);
    /**
     * 请求数据失败，指在请求网络API接口请求方式时，出现无法联网、
     * 缺少权限，内存泄露等原因导致无法连接到请求数据源。
     */
    void onError();
    /**
     * 当请求数据结束时，无论请求结果是成功，失败或是抛出异常都会执行此方法给用户做处理，通常做网络
     * 请求时可以在此处隐藏“正在加载”的等待控件
     */
    void onComplete();
}
