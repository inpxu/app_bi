package test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testtt {
    public static void main(String[] args) {
        List<String> ss = new ArrayList<>();
        ss.add("authTime != '111'");
        ss.add("createTime like concat('%' ,2 , '%')");
//        System.out.println(ss);
//        System.out.println(JSON.parseArray(JSON.toJSONString(ss)));
        Map<String, Object> paramMap = new HashMap<String, Object>();
        for (Object o : JSON.parseArray(JSON.toJSONString(ss))) {
//            System.out.println(o);
            String ob = String.valueOf(o);
            String before = ob.substring(0, ob.indexOf(" "));
            String after = ob.replaceFirst(before, "").replace(" ", "");
            paramMap.put(before, after);
            System.out.println(paramMap);

        }

    }
}