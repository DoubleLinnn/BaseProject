package com.net.apiservice;

import com.net.api.IHomeApi;


import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 作者： 文智敏 on 2018/3/18 17:51.
 * 邮箱：995472572@qq.com
 * 微信：15910472268
 * 说明:
 */

public interface IHomeApiService {

    /**
     * 首页
     * @return
     */
    @POST(IHomeApi.URL_BASE)
    @FormUrlEncoded
    Flowable<HttpResult> requestHome(@FieldMap Map<String, String> maps);
}
