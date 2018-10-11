package com.net.apiservice;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.net.api.IBaseApi;
import com.net.converter.ResponseConverterFactory;
import com.util.LoggerUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * 作者： Administrator on 2017/12/28 16:25.
 * 邮箱：995472572@qq.com
 * 微信：15910472268
 * 说明: 接口管理类
 */

public class ResquestManager {
    private static final String TAG=ResquestManager.class.getName();
    private static final long MILLISECONDS=5000L;
    private IHomeApiService iHomeApiService;
    private static class SendCodeHelper {
        private static final ResquestManager INSTANCE = new ResquestManager();
    }

    private ResquestManager() {
    }

    public static final ResquestManager getInstance() {
        return SendCodeHelper.INSTANCE;
    }

    private static final OkHttpClient okHttpClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .connectTimeout(MILLISECONDS, TimeUnit.MILLISECONDS)//设置连接超时 时
//                    .addInterceptor(httpLoggingInterceptor)
                .build();
        return  okClient;
    }


    /**
     * Home
     *
     * @return
     */
    public IHomeApiService getIHomeApiService() {
        if (iHomeApiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(IBaseApi.NET_BASE_MAIN)
                    .client(okHttpClient())
                    .addConverterFactory(ResponseConverterFactory.create())//自定义解析器
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            iHomeApiService = retrofit.create(IHomeApiService.class);
        }
        return iHomeApiService;
    }

    /**
     * get 请求
     * @param url
     * @return
     */
    public Call productDetailsCall(String url) {
        //1.okhttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2构造Request,
        //builder.get()代表的是get请求，url方法里面放的参数是一个网络地址
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(url).build();
        //3将Request封装成call
        return okHttpClient.newCall(request);
    }

    /**
     * delete 请求方式
     * @param url
     * @param bodyString
     * @return
     */
    public Call deleteCallRequest(String url, String bodyString){
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        LoggerUtils.d(TAG,"url="+url);
        LoggerUtils.d(TAG,"bodyString="+bodyString);
        //创建RequestBody对象，将参数按照指定的MediaType封装
        RequestBody requestBody = RequestBody.create(mediaType,bodyString);
        Request.Builder builder = new Request.Builder();
        Request request = builder.delete(requestBody).url(url).build();
        return okHttpClient.newCall(request);
    }

    /**
     * post 请求
     * @param url
     * @param bodyString
     * @return
     */
    public Call postCallRequest(String url, String bodyString){
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        LoggerUtils.d(TAG,"url="+url);
        LoggerUtils.d(TAG,"bodyString="+bodyString);
        //创建RequestBody对象，将参数按照指定的MediaType封装
        RequestBody requestBody = RequestBody.create(mediaType,bodyString);
        Request.Builder builder = new Request.Builder();
        Request request = builder.post(requestBody).url(url).build();
        return okHttpClient.newCall(request);
    }

    /**
     * post 请求
     * @param url
     * @param formBody
     * @return
     */
    public Call postRequest(String url, FormBody formBody){
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        LoggerUtils.d(TAG,"url="+url);
        LoggerUtils.d(TAG,"formBody="+formBody.toString());
        //创建RequestBody对象，将参数按照指定的MediaType封装
        Request.Builder builder = new Request.Builder();
        Request request = builder.post(formBody).url(url).build();
        return okHttpClient.newCall(request);
    }
}
