package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.ChuKu;
import com.weiling.wl_erp.bean.User;
import com.weiling.wl_erp.service.ChuKuService;
import com.weiling.wl_erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/10
 * 出库实现类
 */
@Controller
public class ChuKuController {
    @Autowired
    private ChuKuService chuKuService;

    /*查询所有出库列表*/
    @RequestMapping("findAllChuKu")
    @ResponseBody
    public List<ChuKu> findAllChuKu(){
        return chuKuService.findAllChuKu();
    }








}
