package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public User sel(int id);

    public List<User> getUserByName(String userName);

    public List<User> selectAll();

    User login(String userName,String passWord);

    int register(User user);
}
