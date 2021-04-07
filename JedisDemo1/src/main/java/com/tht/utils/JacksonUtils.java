package com.tht.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tht.pojo.Goods;

import java.util.List;

/**
 * @ClassName : com.tht.utils.JacksonUtils
 * @Description : 描述
 * Author : space
 * CreatedDate 2021-04-06 18:17:43
 */
public class JacksonUtils {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static String objToString(Object obj){
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static <T> T strToObject(String str, Class<T> t){
        try {
            return mapper.readValue(str,t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
