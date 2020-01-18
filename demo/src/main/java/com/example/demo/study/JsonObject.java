package com.example.demo.study;



//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonObject {
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("name","json");

        map.put("bool",Boolean.TRUE);

        map.put("int",new Integer(1));

        map.put("arr",new String[]{"a","b"});

        String json = JSON.toJSONString(map);

        JSONObject jsonObject = JSONObject.parseObject(json);

       // JSONArray jsonArray =jsonObject.getJSONArray("jsonObject");

        System.out.println("jsonobject :"+jsonObject);

        System.out.println(jsonObject.getJSONObject("int"));

       // System.out.println("jsonArray :"+jsonArray);
    }
}
