package com.baseproject.home.mvp.impl;

import com.baseproject.home.helper.IMaLinsenter;
import com.baseproject.home.mvp.model.IMaModel;
import com.net.apiservice.HttpResult;
import com.net.apiservice.ResquestManager;
import com.net.converter.SubscribeCallBackHelper;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DoubleLinnn on 2018/10/11.
 */
public class MaModelImpl implements IMaModel{

    private IMaLinsenter listener;
    public MaModelImpl(IMaLinsenter l){
        this.listener=l;
    }

    @Override
    public void requestOne(Map<String, String> maps) {
        Flowable<HttpResult> call = ResquestManager.getInstance().getIHomeApiService().requestHome(maps);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SubscribeCallBackHelper<HttpResult>() {
                    @Override
                    public void onSuccess(HttpResult object) {
                        listener.requestSuccess(object);
                    }

                    @Override
                    public void onFailure(int status, String msg) {
                        listener.requestFailure(status, msg!=null?msg:"请求错误");
                    }
                });
    }

    @Override
    public void requestTwo(Map<String, String> maps) {
        Flowable<HttpResult> call = ResquestManager.getInstance().getIHomeApiService().requestHome(maps);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SubscribeCallBackHelper<HttpResult>() {
                    @Override
                    public void onSuccess(HttpResult object) {
                        listener.requestTwoSuccess(object);
                    }

                    @Override
                    public void onFailure(int status, String msg) {
                        listener.requestTwoFailure(status, msg!=null?msg:"请求错误");
                    }
                });
    }
}
