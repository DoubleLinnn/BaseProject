package com.base;

/**
 * 作者： 文智敏 on 2018/3/18 17:03.
 * 邮箱：995472572@qq.com
 * 微信：15910472268
 * 说明: view 层 接口回调基类
 */

public interface IBaseRequestView extends IBaseView {
    /**
     * 加载中
     */
    void requestLoad();

    /**
     * 请求成功返回实体数据
     * @param object 返回的数据
     */
    void requestSuccess(Object object);

    /**
     * 请求失败
     * @param status 状态码
     * @param errorMsg 错误信息输出
     */
    void requestFailure(int status, String errorMsg);
}
