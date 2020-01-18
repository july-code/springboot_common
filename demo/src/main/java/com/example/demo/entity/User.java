package com.example.demo.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
    private String token;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
