package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.User;
import com.weiling.wl_erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/10
 * 用户校验类
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
    *作者：王怀朋
    *参数：
    *功能：校验用户名与密码
    */
    @RequestMapping("/checkNamePass")
    public String checkNamePass(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        System.out.println("1111");
        return username+",.."+password;
    }
























    @RequestMapping(value="/ceshi")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAllUser();
    }

}
