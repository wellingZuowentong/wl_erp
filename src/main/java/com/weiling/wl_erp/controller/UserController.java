package com.weiling.wl_erp.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.weiling.wl_erp.bean.User;
import com.weiling.wl_erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    *参数：username,password
    *功能：校验用户名与密码
    */
    @RequestMapping("/checkNamePass")
    public String checkNamePass(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user=new User();
        user.setName(username);
        user.setPassword(password);
        User user1=userService.checkNamePass(user);
        if(user1!=null){
            session.setAttribute("username",user1);
            return "index.html";
        }
        return "error.html";
    }
    /*查询登陆人验证权限*/
    @RequestMapping("/checkqx")
    @ResponseBody
    public User checkqx(HttpSession session){
        User user = (User)session.getAttribute("username");
        return user;
    }

    @RequestMapping(value="/ceshi")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAllUser();
    }

}
