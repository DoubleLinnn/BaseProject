package com.baseproject.home.mvp.view;

import com.base.IBaseRequestView;

/**
 * Created by DoubleLinnn on 2018/10/11.
 */
public interface IMaView extends IBaseRequestView{

    void requestTwoSuccess(Object object);

    void requestTwoFailure(int statrs,String errorMsg);

}
