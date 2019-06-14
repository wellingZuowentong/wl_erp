package com.weiling.wl_erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.bean.ShangPin;
import com.weiling.wl_erp.service.SellService;
import com.weiling.wl_erp.service.ShangPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
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
    @Autowired
    private SellService sellService;

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
        BigDecimal sellprice = new BigDecimal(request.getParameter("sellprice"));
        String beizhu = request.getParameter("beizhu");
        System.out.println(beizhu+"!!!!!!!!!!!!!@@@@@@@@@@@@@@@");
        ShangPin shangpin = shangPinService.findShangPinById(id);
        shangpin.setSellprice(sellprice);
        shangpin.setBeizhu(beizhu);
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
    @RequestMapping(value = "/findShangPinByName",method = RequestMethod.GET)
    @ResponseBody
    public ShangPin findShangPinByName(String pname, String cname){
            return shangPinService.findShangPinByName(pname,cname);
    }

    /*出售商品*/
    @RequestMapping("/saleShangPinById")
    @ResponseBody
    public List<ShangPin> saleShangPinById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        Integer oksell = Integer.parseInt(request.getParameter("oksell"));
        BigDecimal sellprice = new BigDecimal(request.getParameter("sellprice"));
        String guige = request.getParameter("guige");
        BigDecimal allprice = new BigDecimal(request.getParameter("allprice"));
        String jiage = request.getParameter("overprice");
        if(jiage==null||jiage.equals("")){
            jiage = request.getParameter("allprice");
        }
        BigDecimal overprice = new BigDecimal(jiage);
        String selluser = request.getParameter("selluser");
        String beizhu = request.getParameter("beizhu");
        Sell sell =new Sell();
        sell.setPname(pname);
        sell.setCname(cname);
        sell.setOksell(oksell);
        sell.setSellprice(sellprice);
        sell.setGuige(guige);
        sell.setAllprice(allprice);
        sell.setOverprice(overprice);
        sell.setSelluser(selluser);
        sell.setSelltime(new Date());
        sell.setZhuangtai(0);
        sell.setBeizhu(beizhu);
        sellService.insertSell(sell);
        ShangPin shangpin = shangPinService.findShangPinById(id);
        shangpin.setSellnum(shangpin.getSellnum()-oksell);
        shangPinService.updateShangPinById(shangpin);
        return shangPinService.findAllShangPin();
    }
    /**
     * 商品分页功能
     * 作者:左文统
     * 时间:2019/6/14
     * */
    @RequestMapping("/getAllShangPin")
    @ResponseBody
    public PageInfo<ShangPin> getAllPerson(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<ShangPin> list = shangPinService.findAllShangPin();
        PageInfo<ShangPin> pageInfo = new PageInfo<ShangPin>(list);
        return pageInfo;
    }












}
