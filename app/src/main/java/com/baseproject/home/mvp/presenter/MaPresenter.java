package com.baseproject.home.mvp.presenter;

import com.base.BasePresenter;
import com.baseproject.home.helper.IMaLinsenter;
import com.baseproject.home.mvp.impl.MaModelImpl;
import com.baseproject.home.mvp.model.IMaModel;
import com.baseproject.home.mvp.view.IMaView;

import java.util.Map;

/**
 * Created by DoubleLinnn on 2018/10/11.
 */
public class MaPresenter extends BasePresenter<IMaView> implements IMaModel,IMaLinsenter {

    private MaModelImpl model;
    public MaPresenter(IMaView mView) {
        super(mView);
        model = new MaModelImpl(this);
    }

    @Override
    protected void removeView() {
        mView = null;
    }

    @Override
    public void requestTwoSuccess(Object object) {
        mView.requestTwoSuccess(object);
    }

    @Override
    public void requestTwoFailure(int statrs, String errorMsg) {
        mView.requestTwoFailure(statrs, errorMsg);
    }

    @Override
    public void requestSuccess(Object object) {
        mView.requestSuccess(object);
    }

    @Override
    public void requestFailure(int status, String errorMsg) {
        mView.requestFailure(status, errorMsg);
    }

    @Override
    public void requestOne(Map<String, String> maps) {
        model.requestOne(maps);
    }

    @Override
    public void requestTwo(Map<String, String> maps) {
        model.requestTwo(maps);
    }
}
