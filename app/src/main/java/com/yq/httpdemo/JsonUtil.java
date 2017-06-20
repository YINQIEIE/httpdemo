package com.yq.httpdemo;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by yiqile-21 on 2016/5/30.
 */
public class JsonUtil<Result> {

    private static Gson gson = null;

    /**
     * 初始化gson对象
     *
     * @return
     */
    public static Gson getGson() {

        if (gson == null) {

            GsonBuilder builder = new GsonBuilder();

            builder.setDateFormat("yyyy-MM-dd");

            builder.registerTypeAdapter(Date.class, new DateSerializer());

            builder.registerTypeAdapter(Timestamp.class, new StampSerializer());

            gson = builder.serializeNulls().create();
        }

        return gson;

    }

    /**
     * 时间戳序列化
     */
    static class StampSerializer implements JsonSerializer<Timestamp>, JsonDeserializer<Timestamp> {

        @Override
        public JsonElement serialize(Timestamp src, Type typeOfSrc, JsonSerializationContext context) {

            return new JsonPrimitive(src.getTime());

        }

        @Override
        public Timestamp deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            return new Timestamp(json.getAsLong());

        }
    }

    /**
     * 时间戳序列化
     */
    static class DateSerializer implements JsonSerializer<Date>, JsonDeserializer<Date> {

        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {

            return new JsonPrimitive(src.getTime());

        }

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            return new Date(json.getAsLong());

        }
    }

    /**
     * obj为Map
     *
     * @param messaage
     * @return
     */

    public static ReturnMessage<Map<String, String>> getReturnMsgMap(String messaage) {

        if (TextUtils.isEmpty(messaage)) {

            return null;

        }

        TypeToken typeToken = new TypeToken<ReturnMessage<Map<String, String>>>() {
        };

        ReturnMessage<Map<String, String>> returnObj = getGson().fromJson(messaage, typeToken.getType());

        return returnObj;
    }


    public static <T> ReturnMessage<T> getReturnMsgByT(String messaage, TypeToken type) {

        if (TextUtils.isEmpty(messaage)) {

            return null;

        }

        ReturnMessage<T> returnObj = getGson().fromJson(messaage, type.getType());

        return returnObj;
    }

    /**
     * 直接传入ReturnMessage<T>可以 T只能是具体的类，不能再用泛型代替
     *
     * @param messaage
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T getReturnMsgByT1(String messaage, TypeToken type) {

        if (TextUtils.isEmpty(messaage)) {

            return null;

        }

        T returnObj = getGson().fromJson(messaage, type.getType());

        return returnObj;
    }

}
