package com.net.converter;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.net.IHelper;
import com.util.LoggerUtils;

import org.json.JSONException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import retrofit2.HttpException;

/**
 * 作者： Administrator on 2017/12/28 16:48.
 * 邮箱：995472572@qq.com
 * 微信：15910472268
 * 说明: 回调的基类
 */

public abstract class SubscribeCallBackHelper<T> implements Subscriber<T> {

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
//        LoggerUtils.e("SubscribeCallBackHelper.onNext",t.toString());
        if (t != null)
            onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        LoggerUtils.e("SubscribeCallBackHelper.onError", e.getClass().getName());
        //在这里做全局的错误处理
        try {
            if (e instanceof HttpException ||
                    e instanceof ConnectException ||
                    e instanceof SocketTimeoutException ||
                    e instanceof TimeoutException ||
                    e instanceof UnknownHostException ||
                    e instanceof NoRouteToHostException) {
                //网络错误
                onFailure(IHelper.NETWORK_ERROR, "服务器连接失败");
            } else if (e instanceof JsonParseException
                    || e instanceof JSONException
                    || e instanceof JsonSyntaxException
                    || e instanceof ParseException) {
                //数据解析错误
                onFailure(IHelper.PARSE_ERROR, "数据解析错误");
            } else if (e instanceof ApiException) {
                ApiException apiException = (ApiException) e;
                //自定义的ApiException
                onFailure(apiException.getErrCode(), apiException.getErrorMsg());
            } else if (e instanceof javax.net.ssl.SSLException) {
                onFailure(IHelper.SSL_ERROR, "证书验证失败");
            } else if (e instanceof NullPointerException){
                onFailure(IHelper.UNKNOWN, "提交异常");
            }else {
                onFailure(IHelper.UNKNOWN, "未知错误");
            }
        } catch (Exception e1) {
            LoggerUtils.e("SubscribeCallBackHelper.catch", e1.toString());
            onFailure(IHelper.UNKNOWN, "未知错误");
        }
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);

    public abstract void onFailure(int status, String msg);

}
