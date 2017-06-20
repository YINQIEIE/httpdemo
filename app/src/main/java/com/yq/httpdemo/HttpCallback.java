package com.yq.httpdemo;

/**
 * Created by yinqi on 2017/6/20.
 */

public interface HttpCallback {

    void onSuccess(String body);

    void onFailure(String e);
}
