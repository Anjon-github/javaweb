package com.xhm.web.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JackJsonUtils {

    static ObjectMapper objectMapper;

    public static <T> T fromJson(String content, Class<T> valueType){
        if(objectMapper == null){
            objectMapper = new ObjectMapper();
        }
        try{
            return objectMapper.readValue(content, valueType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String toJson(Object object){
        if(objectMapper == null){
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
