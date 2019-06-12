package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.ShangPin;
import com.weiling.wl_erp.service.ShangPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 商品信息
 */
@Controller
public class ShangPinController {
    @Autowired
    private ShangPinService shangPinService;


   /* @RequestMapping("insertShangPin")
    @ResponseBody
    public int insertShangPin(){

    }*/
   /*查询所有商品列表*/
   @RequestMapping("/findAllShangPin")
   @ResponseBody
    public List<ShangPin> findAllShangPin(){
       return shangPinService.findAllShangPin();
    }
    /*根据ID查询商品*/
    @RequestMapping("/findShangPinById")
    @ResponseBody
    public ShangPin findShangPinById(HttpServletRequest request){
       Integer id=Integer.parseInt(request.getParameter("id"));
       return shangPinService.findShangPinById(id);
    }

    /*根据ID修改商品*/
    @RequestMapping("/updateShangPinById")
    @ResponseBody
    public int updateShangPinById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer sellnum = Integer.parseInt(request.getParameter("sellnum"));
        ShangPin shangpin = shangPinService.findShangPinById(id);
        shangpin.setSellnum(sellnum);
        return shangPinService.updateShangPinById(shangpin);
    }

    /*根据ID删除商品*/
    @RequestMapping("/deleteShangPinById")
    @ResponseBody
    public int deleteShangPinById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));

        return shangPinService.deleteShangPinById(id);
    }

    /*根据商品名和厂家名查找商品*/
    @RequestMapping("/findShangPinByName")
    @ResponseBody
    public ShangPin findShangPinByName(String pname,String cname){
        return shangPinService.findShangPinByName(pname,cname);
    }

    /*出售商品*/
    @RequestMapping("/saleShangPinById")
    @ResponseBody
    public List<ShangPin> saleShangPinById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer sellnum = Integer.parseInt(request.getParameter("salenum"));
        ShangPin shangpin = shangPinService.findShangPinById(id);
        shangpin.setSellnum(shangpin.getSellnum()-sellnum);
        shangPinService.updateShangPinById(shangpin);
        return shangPinService.findAllShangPin();
    }












}
