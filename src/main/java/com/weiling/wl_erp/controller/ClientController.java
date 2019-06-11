package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.Client;
import com.weiling.wl_erp.mapper.ClientMapper;
import com.weiling.wl_erp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/11
 * 增加用户，查询所有用户，查询单个用户
 */
@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    /*查询所有客户*/
    @RequestMapping("/findAllClient")
    @ResponseBody
    public List<Client> findAllClient(){
        List<Client> list = clientService.findAllClient();
        return list;
    }

    /*查询单个客户*/
    @RequestMapping("/findClientById")
    @ResponseBody
    public Client findClientById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        return clientService.findClientById(id);
    }

    /*新增客户*/
    @RequestMapping("/insertClient")
    @ResponseBody
    public int insertClient(HttpServletRequest request){
        String cname=request.getParameter("cname");
        String phone=request.getParameter("phone");
        Client client = new Client();
        client.setCname(cname);
        client.setPhone(phone);
        if(cname!=null&&!cname.equals("")){
            return clientService.insertClient(client);
        }
        return 0;
    }































}
