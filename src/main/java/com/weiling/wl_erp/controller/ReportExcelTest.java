package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.Product;
import com.weiling.wl_erp.bean.User;
import com.weiling.wl_erp.service.UserService;
import com.weiling.wl_erp.util.ReportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Controller
public class ReportExcelTest extends HttpServlet {
    @Autowired
    private UserService userService;
    @RequestMapping("excel")
    @ResponseBody
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<User> list = new ArrayList<>();
        for (int i = 0;i<60000;i++){
            //组装测试数据
            User user = new User();
            user.setName("wang");
            user.setPassword("123");
            list.add(user);
            /*for (User user1:list){
                System.out.println(user1.getName());
            }*/
        }
        ReportExcel reportExcel = new ReportExcel();
        System.out.println(list.size());
        reportExcel.excelReport(list,"测试",Product.class,1,response,request);
    }
}
