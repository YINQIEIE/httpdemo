package com.yq.httpdemo;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by yinqi on 2017/6/20.
 */

public abstract class HttpCallback1<T extends ReturnMessage<Result>, Result> implements HttpCallback {


    @Override
    public void onSuccess(String response) {

//        Class<?> clazz = analysisClass(this);

        T result = JsonUtil.getReturnMsgByT1(response, new TypeToken<T>() {
        });

        onSuccess(result);

    }

    public abstract void onSuccess(T result);


    public static Class<?> analysisClass(Object obj) {

        Type genType = obj.getClass().getGenericSuperclass();

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        return (Class<?>) params[0];

    }


}
