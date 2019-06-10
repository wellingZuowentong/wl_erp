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
}
