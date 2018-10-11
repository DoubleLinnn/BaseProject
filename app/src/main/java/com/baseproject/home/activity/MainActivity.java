package com.baseproject.home.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.base.BaseActivity;
import com.baseproject.R;
import com.baseproject.home.mvp.presenter.MaPresenter;
import com.baseproject.home.mvp.view.IMaView;
import com.rxtool.RxToast;
import com.util.LoggerUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MaPresenter> implements IMaView {

    @Bind(R.id.text_view)
    TextView textView;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new MaPresenter(this);
        mPresenter.init();
    }

    @Override
    protected boolean removeStatusBarBoolean() {
        return false;
    }

    @Override
    protected void destory() {

    }

    @Override
    public void requestTwoSuccess(Object object) {

    }

    @Override
    public void requestTwoFailure(int statrs, String errorMsg) {

    }

    @Override
    public void requestLoad() {

    }

    @Override
    public void requestSuccess(Object object) {

    }

    @Override
    public void requestFailure(int status, String errorMsg) {

    }

    @OnClick(R.id.text_view)
    public void onViewClicked(){
        RxToast.success("mvp封装成功...");
    }
}