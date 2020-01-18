package com.example.demo.common;

import java.io.File;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class Main {
    public static void main(String[] args) {
        JsonUtil jsonUtil = new JsonUtil();
        File file = new File("D:\\demo\\src\\main\\resources\\politicsB1800000_12406.json");
        String jsonStr = jsonUtil.readJsonFile(file);
        JSONArray jsonArray = (JSONArray) JSON.parse(jsonStr);
        System.out.println(jsonArray);
    }
}
