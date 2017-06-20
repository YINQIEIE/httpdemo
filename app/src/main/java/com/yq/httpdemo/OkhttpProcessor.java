package com.yq.httpdemo;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yinqi on 2017/6/20.
 */

public class OkhttpProcessor implements IHttpProcessor {

    private final OkHttpClient client;

    private final Handler handler;

    public OkhttpProcessor(OkHttpClient client) {

        this.client = client;

        handler = new Handler();

    }

    @Override
    public void post(String url, Map<String, Object> params, final HttpCallback callback) {

        FormBody.Builder bodyBuilder = new FormBody.Builder();

        if (null != params) {//生成表单参数

            for (Map.Entry<String, Object> entry : params.entrySet())

                bodyBuilder.add(entry.getKey(), String.valueOf(entry.getValue()));

//            for (String key : params.keySet())
//
//                bodyBuilder.add(key, String.valueOf(params.get(key)));

        }

        FormBody body = bodyBuilder.build();

        final Request request = new Request.Builder().url(url).post(body).build();

        client.newCall(request).enqueue(new MyCallback(callback));

    }

    @Override
    public void get(String url, Map<String, Object> params, HttpCallback callback) {

        Request request = new Request.Builder().url(url).get().build();

        client.newCall(request).enqueue(new MyCallback(callback));

    }

    /**
     * 请求回调
     */
    private class MyCallback implements Callback {

        private HttpCallback callback;

        public MyCallback(HttpCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onFailure(Call call, final IOException e) {

            handler.post(new Runnable() {
                @Override
                public void run() {

                    callback.onFailure(e.getMessage());

                }
            });

        }

        @Override
        public void onResponse(Call call, final Response response) throws IOException {

//            callback.onSuccess(response.body().string());

            handler.post(new Runnable() {
                @Override
                public void run() {

                    try {

                        if (response.isSuccessful())

                            callback.onSuccess(response.body().string());

                        else

                            callback.onFailure(response.toString());

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                }
            });


        }
    }


}
