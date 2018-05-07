package com.joy.java.util.lang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONUtils {

    private static ObjectMapper objmap = new ObjectMapper();

    /**
     * json转为List类型
     *
     * @return
     */
    public static List<Map<String, Object>> jsonToList(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> list = mapper.readValue(json, List.class);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Bean对象转JSON
     *
     * @param object
     * @param dataFormatString
     * @return
     */
    public static String beanToJson(Object object, String dataFormatString) {
        if (object != null) {
            if (MyStringUtil.isEmpty(dataFormatString)) {
                return JSONObject.toJSONString(object);
            }
            return JSON.toJSONStringWithDateFormat(object, dataFormatString);
        } else {
            return null;
        }
    }

    /**
     * Bean对象转JSON
     *
     * @param object
     * @return
     */
    public static String beanToJson(Object object) {
        if (object != null) {
            return JSON.toJSONString(object);
        } else {
            return null;
        }
    }
    public static String toJsonObject(Object object) {
        if (object != null) {
            return JSON.toJSONString(object, SerializerFeature.WriteNullStringAsEmpty);
        } else {
            return null;
        }
    }

    /**
     * String转JSON字符串
     *
     * @param key
     * @param value
     * @return
     */
    public static String stringToJsonByFastjson(String key, String value) {
        if (MyStringUtil.isEmpty(key) || MyStringUtil.isEmpty(value)) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>(16);
        map.put(key, value);
        return beanToJson(map, null);
    }

    /**
     * 将json字符串转换成对象
     *
     * @param json
     * @param clazz
     * @return
     */
    public static Object jsonToBean(String json, Object clazz) {
        if (MyStringUtil.isEmpty(json) || clazz == null) {
            return null;
        }
        return JSON.parseObject(json, clazz.getClass());
    }

    /**
     * json转为实体对象--使用的是jackson包转换工具
     *
     * @param <T>
     * @param t
     * @param json
     * @return
     */
    public static <T> T jsonToObject(Class<T> t, String json) {
        String content = json;
        try {
            T t1 = objmap.readValue(content, t);
            return t1;
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /***
     * 将将对象转换为传入类型的对象
     * @param
     * @param object
     * @param beanClass
     * @return
     */
    public static <T> T toBean(Object object, Class<T> beanClass)
    {
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(object);
        return (T) net.sf.json.JSONObject.toBean(jsonObject, beanClass);
    }


    /**
     * json字符串转map
     *
     * @param json
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> jsonToMap(String json) {
        if (MyStringUtil.isEmpty(json)) {
            return null;
        }
        return JSON.parseObject(json, Map.class);
    }

    /**
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> fromJsonArray(String json, Class<T> clazz) throws Exception {
        List<T> lst = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            lst.add(new Gson().fromJson(elem, clazz));
        }
        return lst;
    }

}
