package com.yq.httpdemo;

import java.util.Map;

/**
 * Created by yinqi on 2017/6/20.
 */

public interface IHttpProcessor {

    void post(String url, Map<String, Object> params, HttpCallback callback);

    void get(String url, Map<String, Object> params, HttpCallback callback);

}
