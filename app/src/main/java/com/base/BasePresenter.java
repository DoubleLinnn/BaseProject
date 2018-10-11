package com.base;

/**
 * 作者： 文智敏 on 2017/11/8 23:06.
 * 邮箱：995472572@qq.com
 * 微信：15910472268
 * 说明: Presenter中间层
 */

public abstract class BasePresenter<T extends IBaseView> {
    protected T mView;

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public void init() {
        if (mView != null) mView.init();
    }

    protected abstract void removeView();

}
