package com.atxiaohu.vip.service;

import com.atxiaohu.vip.mapper.UserMapper;
import com.atxiaohu.vip.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date 2023/4/21
 * @Author XiaoHu
 * @Description
 **/
@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

   public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    public List<User> getAllUser(){
        return userMapper.selectUsers();
    }

}
