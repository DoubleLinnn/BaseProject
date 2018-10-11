package com.baseproject.home.helper;

import com.base.IBaseListener;

/**
 * Created by DoubleLinnn on 2018/10/11.
 */
public interface IMaLinsenter extends IBaseListener{

    void requestTwoSuccess(Object object);

    void requestTwoFailure(int statrs,String errorMsg);

}
