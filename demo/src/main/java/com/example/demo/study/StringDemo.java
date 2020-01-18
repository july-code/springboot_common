package com.example.demo.study;

import com.example.demo.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
/**
 insert into staff_position (uuid, country, department, job_title, personnel, lasttime)
 values('JAjACJKJ8GS2JsOjEd1Bkw==', '中华民国', '民主进步党', 'chairperson', '卓荣泰', now())，('iq8XjMkglZ9okNBdWKagiw==', '中华民国', '中国国民党', 'chairperson', '吴敦义', now()),
 ('P4KbxALbljwHlLwVs6D49w==', '中华民国', '无党团结联盟', 'chairperson', '林炳坤', now())

 select * from staff_position

 update staff_position set uuid = 'n1LFXTGMeyFF97wc0vbp/g==' where personnel = '邱威杰'

 update staff_position set country = '台湾', job_title = '主席'
 * */
//        demo1();
//        System.out.println(CommonUtils.EncoderByMd5("汤化龙台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("范云台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("宋楚瑜台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("黎元洪台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("悟觉妙天禅师台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("叶宪修台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("邱显智台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("卓荣泰台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("吴敦义台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("林炳坤台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("邱威杰台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("李登辉台湾主席"));
//        System.out.println(CommonUtils.EncoderByMd5("卡西姆苏莱曼尼伊朗指挥官"));
//        System.out.println(CommonUtils.EncoderByMd5("伊斯梅尔贾尼伊朗指挥官"));
//        System.out.println(CommonUtils.EncoderByMd5("威廉格特尼美国舰队司令官"));
        System.out.println(CommonUtils.EncoderByMd5("美国装备高新技术：卫星定位测向、电视转播技术、计算机信息处理技术、网络技术、信号模拟、失真技术、声像技术、语言模拟技术、虚拟现实技术、激光技术、现代仿声、仿形技术和隐形技术"));
        System.out.println(CommonUtils.EncoderByMd5("美国技术传统心理战手段：战地广播、高音喇叭、传单、漂流瓶、热气球"));
        System.out.println(CommonUtils.EncoderByMd5("美国理论政治心理战、经济心理战、外交心理战、文化心理战、心理学原理"));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

    }

    private static void demo1() {
        String str1 = "asdfghjkl";

        System.out.println(System.identityHashCode(str1));

        str1="qwerty"+str1;

        System.out.println(System.identityHashCode(str1));

        String string = " ";
        System.out.println(string==null);
        System.out.println(string.length());


        System.out.println(StringUtils.isEmpty(string));

        System.out.println(StringUtils.isBlank(string));
    }
}
