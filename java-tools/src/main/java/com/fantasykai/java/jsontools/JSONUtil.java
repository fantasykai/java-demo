package com.fantasykai.java.jsontools;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2017/11/10 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class JSONUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * java对象转json
     *
     * @param o
     * @returnØ
     */
    public static String toJSON(Object o) {
        String json = null;
        try {
            objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            // 过滤map中的null值
            objectMapper.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);
            json = objectMapper.writeValueAsString(o);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * json字符转java对象
     *
     * @param t
     * @return
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(json, clazz);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

}
