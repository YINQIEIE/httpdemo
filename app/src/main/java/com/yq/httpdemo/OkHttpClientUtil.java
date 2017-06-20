package com.yq.httpdemo;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;

/**
 * Created by yinqi on 2017/6/12.
 */

public class OkHttpClientUtil {

    private OkHttpClientUtil() {
    }

    private static OkHttpClient client = null;

    private static OkHttpClient.Builder builder = null;

    /**
     * 单例 获取client对象
     *
     * @return
     */
    public static OkHttpClient getClient() {

        if (client == null) {

            if (builder == null) {

                builder = new OkHttpClient.Builder();
            }

//            InputStream inputStream = new ByteArrayInputStream(key.getBytes());

            InputStream is = new Buffer().write(key.getBytes()).inputStream();

            HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(new InputStream[]{is}, null, null);

            builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager).hostnameVerifier(new HostnameVerifier() {

                @Override
                public boolean verify(String hostname, SSLSession session) {

                    return true;
                }
            });

            //okhttp日志打印
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new OkHttpLogger());

            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            builder.addNetworkInterceptor(logInterceptor);

            client = builder.connectTimeout(20, TimeUnit.SECONDS)

                    .readTimeout(20, TimeUnit.SECONDS)

                    .build();

        }

        return client;

    }

    /**
     * 日志打印类
     */
    private static class OkHttpLogger implements HttpLoggingInterceptor.Logger {

        @Override
        public void log(String message) {

            System.out.println("message = [" + message + "]");

//            Log.i("requestBody", message);

        }

    }

    private static final String key = "-----BEGIN CERTIFICATE-----\n" +
            "MIICgzCCAewCCQDwh6nTcp2MHjANBgkqhkiG9w0BAQUFADCBhTELMAkGA1UEBhMCQ04xCzAJBgNV\n" +
            "BAgMAlNIMQswCQYDVQQHDAJTSDEMMAoGA1UECgwDWVFMMRAwDgYDVQQLDAdJVCBEZXB0MRUwEwYD\n" +
            "VQQDDAwxOTIuMTY4LjEuNTExJTAjBgkqhkiG9w0BCQEWFmRhaXl1bnRhbzEyMjZAc2luYS5jb20w\n" +
            "HhcNMTYxMjIwMDMzODUxWhcNMTcxMjIwMDMzODUxWjCBhTELMAkGA1UEBhMCQ04xCzAJBgNVBAgM\n" +
            "AlNIMQswCQYDVQQHDAJTSDEMMAoGA1UECgwDWVFMMRAwDgYDVQQLDAdJVCBEZXB0MRUwEwYDVQQD\n" +
            "DAwxOTIuMTY4LjEuNTExJTAjBgkqhkiG9w0BCQEWFmRhaXl1bnRhbzEyMjZAc2luYS5jb20wgZ8w\n" +
            "DQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBALvsk8aWKbh003CGuHwwBAMoizZSUzJWIeEV1bKOtdYK\n" +
            "naIir7MTSGG5ivtuwUUCi/+HLWecaR1Qn7U4y6ZYVzN/ID9EE7CIXYW3Bn5BSHKxNoGxpnb1uYVl\n" +
            "rBHA6I3nFFmHsGt6tyEJhj/tTzmRo2gaukLmmo3Vuz0G+vZPe6WZAgMBAAEwDQYJKoZIhvcNAQEF\n" +
            "BQADgYEAUracAafWgDQy48qyWBQgM5BmtNZt32KSE5hgn2UCfOm1SNNLvXXZrm23x90Q9HmNM2wR\n" +
            "ruaiQitGBVGC+WSMZKdCkFJ5bc7MmUDo4RaLF+QzchnKUGjuOEI75eQR9nBMAlVV1m+HqJoCyEGn\n" +
            "BilNfdUP4TVvb8mNZ3t52S3+H4M=\n" +
            "-----END CERTIFICATE-----";

}
