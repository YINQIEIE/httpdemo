package com.yq.httpdemo;

import java.io.Serializable;

/**
 * Created by yiqile-21 on 2016/5/30.
 */
public class ReturnMessage<T> implements Serializable {

    private static final long serialVersionUID = 3510307496537809026L;

    private String resultcode;//状态码

    private String message;//状态描述：成功/失败

    private T obj;//obj对应内容

    public ReturnMessage() {
    }

    public ReturnMessage(String resultcode, String message, T obj) {

        this.resultcode = resultcode;

        this.message = message;

        this.obj = obj;

    }

    public String getResultcode() {

        return resultcode;
    }

    public String getMessage() {

        return message;
    }

    public T getObj() {

        return obj;

    }

    public void setResultcode(String resultcode) {

        this.resultcode = resultcode;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public void setObj(T obj) {

        this.obj = obj;

    }

    @Override
    public String toString() {
        return "ReturnMessage{" +
                "resultcode='" + resultcode + '\'' +
                ", message='" + message + '\'' +
                ", obj=" + obj +
                '}';
    }
}
