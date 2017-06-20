package com.yq.httpdemo;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by yinqi on 2017/6/20.
 */

public abstract class HttpCallback1<Result> implements HttpCallback {

    ReturnMessage<Result> returnMessage;

    @Override
    public void onSuccess(String response) {

//        Class<?> clazz = analysisClass(this);

        returnMessage = JsonUtil.getReturnMsgByT1(response, new TypeToken<ReturnMessage<MainActivity.MemberGuessInfo>>() {
        });

        Result result = returnMessage.getObj();

        onSuccess(result);

    }

    public abstract void onSuccess(Result result);


    public static Class<?> analysisClass(Object obj) {

        Type genType = obj.getClass().getGenericSuperclass();

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        return (Class<?>) params[0];

    }


}
