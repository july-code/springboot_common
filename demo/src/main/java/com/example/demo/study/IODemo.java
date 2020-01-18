package com.example.demo.study;

import com.example.demo.utils.XlsUtils;
import com.hankcs.hanlp.HanLP;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IODemo {
    public static void main(String[] args) {
//        demo1();
        demo2();
//        demo3();
    }

    private static void demo3() {
        System.out.println(HanLP.convertToTraditionalChinese("用笔记本电脑写程序"));
        System.out.println(HanLP.convertToSimplifiedChinese("「以後等妳當上皇后，就能買士多啤梨慶祝了」"));
    }

    private static void demo2() {
        List<Map<String, Object>> list = XlsUtils.getDatasList("D:\\xxx.xlsx");

        Map<String ,Object> map = new HashMap<>();
        map = list.get(1);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        for(Iterator it2 = list.iterator(); it2.hasNext();){
//            System.out.println(it2.next());
        }

        /*for (Map<String, Object> s:list) {
            System.out.println(s);
        }*/

       /* for (int i = 0; i < list.size(); i++) {
            System.out.println("list("+i+")="+list.get(i));
        }*/
    }

    private static void demo1() {
        File file = new File("D:\\project_30s_inforone\\common\\datas\\导入字典.xlsx");
        System.out.println(file.exists());
    }
}
