package com.zhiyun.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VarToMapList {

    /**
     * 字符串解析
     * 字符串取key值
     * @param a
     */
    public static List<String> varToKey(String a) {
        List<String> keys = new ArrayList<>();
        List<String> maps = Arrays.asList(a.split("},"));
        if (CollectionUtils.isNotEmpty(maps)) {
            for (String map : maps) {
                String nl = "a" + map + "b";
                if (!nl.equals("ab")) {
                    if (!map.endsWith("}")) {
                        map += "}";
                    }
                    Map jo = JSON.parseObject(map);
                    String c = String.valueOf(jo.get("prop"));
                    keys.add(c);
                }

            }
        }
        return keys;
    }
}