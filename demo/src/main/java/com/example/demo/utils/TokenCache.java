package com.example.demo.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenCache {

    @Autowired
    private CacheManager ehcacheManager;
//    CacheManager ehcacheManager = CacheManager.create("./src/main/resources/ehcache.xml");
    public void put(String token, String name) {
        Cache cache = ehcacheManager.getCache("token");

        Element element = new Element(token, name);
        cache.put(element);
    }

    public String findByValue(String username) {
        Cache cache = ehcacheManager.getCache("token");
        List<String> keys = cache.getKeys();
        for (String key : keys) {
            Element el = cache.get(key);
            if (el != null && el.getObjectValue().equals(username)) {
                return key;
            }
        }

        return null;
    }

    public boolean isExists(String token) {
        Cache cache = ehcacheManager.getCache("token");

        Element element = cache.get(token);
        return (element == null) ? false : true;
    }

    public void clear(String token) {
        Cache cache = ehcacheManager.getCache("token");
        cache.remove(token);
    }
}
