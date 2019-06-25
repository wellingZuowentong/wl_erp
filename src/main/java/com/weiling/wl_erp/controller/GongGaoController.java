package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.GongGao;
import com.weiling.wl_erp.service.GongGaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/25
 */
@Controller
public class GongGaoController {
    @Autowired
    private GongGaoService gongGaoService;

    @RequestMapping("findAllGongGao")
    @ResponseBody
    public List<GongGao> findAllGongGao(){
        return gongGaoService.findAllGongGao();
    }

    @RequestMapping("findGongGaoById")
    @ResponseBody
    public GongGao findGongGaoById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        return gongGaoService.findGongGaoById(id);
    }


}
