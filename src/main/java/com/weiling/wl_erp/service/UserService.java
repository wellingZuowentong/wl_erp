package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.User;
import com.weiling.wl_erp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/10
 */
@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }

    public User checkNamePass(User user){
        return userMapper.checkNamePass(user);
    }

    public int changePass(User user){
        return userMapper.changePass(user);
    }
    public int changeZhuangtai(User user){
        return userMapper.changeZhuangtai(user);
    }
    public User findUserById(Integer id){
        return userMapper.findUserById(id);
    }
}
