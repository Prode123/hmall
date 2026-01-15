package com.hmall.common.desensitize;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author LiTong(Prode)
 * @Data 2026/01/15 11:53
 */
@Component
public class LogJsonUtil {

    private static ObjectMapper objectMapper;

    public LogJsonUtil(ObjectMapper objectMapper) {
        LogJsonUtil.objectMapper = objectMapper;
    }

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            return String.valueOf(obj);
        }
    }
}
