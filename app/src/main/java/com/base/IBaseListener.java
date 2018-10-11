package com.base;

/**
 * 作者： 文智敏 on 2018/3/18 17:00.
 * 邮箱：995472572@qq.com
 * 微信：15910472268
 * 说明: 请求服务器的监听接口回调
 */

public interface IBaseListener {
    /**
     * 请求成功
     * @param object 返回数据类型
     */
    void requestSuccess(Object object);

    /**
     * 请求失败
     * @param status 错误类型状态码
     * @param errorMsg 错误信息
     */
    void requestFailure(int status, String errorMsg);
}
