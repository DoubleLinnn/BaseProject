package com.net.apiservice;


import java.io.Serializable;

/**
 *  返回数据类型
 */

public class HttpResult<T> implements Serializable{
    private static final long serialVersionUID=System.currentTimeMillis();
    public int code;
    private String msg;
    private T content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public T getData() {
        return content;
    }

    public void setData(T data) {
        this.content = data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }
}
