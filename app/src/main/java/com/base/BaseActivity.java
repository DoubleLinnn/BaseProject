package com.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


import butterknife.ButterKnife;

/**
 * Activity 基类
 *
 * @param <T>
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {
    protected T mPresenter;
    protected Context mContext;
    protected String[] tags;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeStatusBar();
        setContentView(provideContentViewId());
        mContext = this;
        ButterKnife.bind(this);
        initPresenter();
    }

    /**
     * 去掉状态栏
     */
    public void removeStatusBar() {
        if (removeStatusBarBoolean()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        mPresenter.removeView();
        destory();
        super.onDestroy();
    }

    /**
     * 布局
     *
     * @return
     */
    protected abstract int provideContentViewId();

    /**
     * 初始化 presenter层
     */
    protected abstract void initPresenter();

    /**
     * 是否隐藏状态栏
     * true 隐藏 fasle 不隐藏
     *
     * @return
     */
    protected abstract boolean removeStatusBarBoolean();

    protected abstract void destory();
}
