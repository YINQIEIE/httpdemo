package com.yq.httpdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yinqi on 2017/6/20.
 */

public class HttpService implements IHttpProcessor {

    private static HttpService service;

    private static IHttpProcessor mHttpProcessor;

    private Map<String, Object> params;

    private HttpService() {

        params = new HashMap<>();

    }

    /**
     * 单例模式获取service
     *
     * @return
     */
    public static HttpService getServiceInstance() {

        if (null == service) {

            synchronized (HttpService.class) {

                if (null == service) {

                    service = new HttpService();
                }
            }
        }

        return service;

    }

    public static void init(IHttpProcessor httpProcessor) {

        mHttpProcessor = httpProcessor;

    }

    @Override
    public void post(String url, Map<String, Object> params, HttpCallback callback) {

        mHttpProcessor.post(url, params, callback);

    }

    @Override
    public void get(String url, Map<String, Object> params, HttpCallback callback) {

        mHttpProcessor.get(url, params, callback);

    }
}
