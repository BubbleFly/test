package com.mongo.utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.OutputStream;

/**
 * Json转化工具，可以实现java对象和json字符串之间的互相转化
 */
public class JsonUtils {

    static ObjectMapper objectMapper = new ObjectMapper();//把bean转换成json

    /**
     * java 对象转换为json 存入流中
     */
    public static String toJson(Object obj) {
        String s = "";
        try {
            s = objectMapper.writeValueAsString(obj);
            System.out.println("user转变为json:"+s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * java 对象转换为json 存入流中
     */
    public static void toJson(Object obj, OutputStream out) {
        try {
            objectMapper.writeValue(out, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * json 转为java对象
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void fromJson(String json, Object obj, Class valueType) {
        try {
            obj = objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * json 转为java对象
     */
    @SuppressWarnings("rawtypes")
    public static void fromJson(String json, Object obj, TypeReference valueTypeRef) {
        try {
            obj = objectMapper.readValue(json, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * json 转为java对象
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Object fromJson(String json, Class valueType) {
        Object obj = null;
        try {
            obj = objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * json 转为java对象
     */
    @SuppressWarnings({ "rawtypes", "hiding" })
    public static <Object> Object fromJson(String json, TypeReference valueTypeRef) {
        Object obj = null;
        try {
            obj = objectMapper.readValue(json, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
