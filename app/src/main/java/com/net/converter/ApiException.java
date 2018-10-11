package com.net.converter;

/**
 * @describe: 捕获服务器约定的错误类型
 */
public class ApiException extends RuntimeException {
    private int errCode;
    private String errorMsg;

    public ApiException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
        this.errorMsg=msg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
