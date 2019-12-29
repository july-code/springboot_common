package com.example.demo.query;

import lombok.Data;

@Data
public class UserQuery {
    private Integer id;
    private String userName;
    private String passWord;
    private boolean showPassword;

}
