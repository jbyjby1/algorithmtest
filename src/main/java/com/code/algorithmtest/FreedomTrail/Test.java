package com.code.algorithmtest.FreedomTrail;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ClassName Test
 * Description TODO
 *
 * @Date 2020/11/25 19:00
 * Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        String result = test.go();
        System.out.println(result);
    }

    public String go(){
        String testStr = "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"usercode\": \"erhjehr\",\n" +
                "      \"user_code\": \"gdggfgerer\"\n" +
                "    },{\n" +
                "      \"usercode\": \"erhjehr\",\n" +
                "      \"user_code\": \"usercode\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Map<String, String> map = new HashMap<String, String>(){{
            put("usercode", "user_code");
            put("user_code", "aaa");
        }};

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()){
            String uuid = UUID.randomUUID().toString();
            map1.put("\"" + entry.getKey() + "\":", uuid);
            map2.put(uuid, "\"" + entry.getValue() + "\":");
        }
        testStr = mapping(testStr, map1);
        testStr = mapping(testStr, map2);
        return testStr;
    }

    public String mapping(String ori, Map<String, String> map){
        String result = ori;
        for (Map.Entry<String, String> entry : map.entrySet()){
            result = result.replaceAll(entry.getKey(), entry.getValue());
        }
        return result;
    }

}
