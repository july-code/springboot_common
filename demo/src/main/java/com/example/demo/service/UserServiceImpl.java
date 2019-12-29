package com.example.demo.service;

import com.example.demo.constant.ErrorCode;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.RestResponse;
import com.example.demo.utils.TokenCache;
import com.example.demo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenCache tokenCache;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User sel(int id) {
        return userMapper.sel(id);
    }

    @Override
    public RestResponse login(String userName, String passWord) throws UnsupportedEncodingException {
        RestResponse restResponse = new RestResponse(ErrorCode.Error);

        User user = getUserByName(userName);
        if(user == null){
            restResponse.setErrorCode(ErrorCode.UserNotExists);
        }else if (!user.getPassWord().equals(passWord)){
            restResponse.setErrorCode(ErrorCode.UserPwdError);
        }else {
            String key;
            if ((key = tokenCache.findByValue(userName)) != null){
                tokenCache.clear(key);
            }
            String token = tokenUtil.createToken(userName,user.getRealName());
            Map<String ,Object> result = new HashMap<String ,Object>();
            result.put("token",token);
            result.put("name",user.getUserName());

            restResponse.setErrorCode(ErrorCode.NoError);
            restResponse.setData(result);
            tokenCache.put(token,userName);
        }
        return restResponse;
    }

    public User getUserByName(String userName){
        List<User> list = userMapper.getUserByName(userName);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

}
