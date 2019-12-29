package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.RestResponse;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    public List<User> selectAll();

    public User sel(int id);

    public RestResponse login(String userName, String passWord) throws UnsupportedEncodingException;

    public int register(User user);
}
