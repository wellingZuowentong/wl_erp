package com.weiling.wl_erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiling.wl_erp.bean.Back;
import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.RuKu;
import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.service.BackService;
import com.weiling.wl_erp.service.KuCunService;
import com.weiling.wl_erp.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/21
 */
@Controller
public class BackController {
    @Autowired
    private BackService backService;
    @Autowired
    private SellService sellService;
    @Autowired
    private KuCunService kuCunService;

    @RequestMapping("insertBack")
    @ResponseBody
    public int insertBack(HttpServletRequest request){
        String ordercode = request.getParameter("ordercode");
        Sell sell = sellService.findSellByOrder(ordercode);
        if(sell==null){
            return 0;
        }
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        String sbacknum = request.getParameter("backnum");
        String sbackprice = request.getParameter("backprice");
        BigDecimal backprice = new BigDecimal(sbackprice==null?"0":sbackprice);
        Integer backnum = Integer.parseInt(sbacknum==null?"0":sbacknum);
        if(backnum>sell.getOksell()){
            return 1;
        }
        String backuser = request.getParameter("backuser");
        String beizhu = request.getParameter("beizhu");
        Date backtime = new Date();
        Back back = new Back();
        back.setPname(pname);
        back.setCname(cname);
        back.setBacknum(backnum);
        back.setBackprice(backprice);
        back.setBacktime(backtime);
        back.setOrdercode(ordercode);
        back.setBackuser(backuser);
        back.setZhuangtai(0);
        back.setBeizhu(beizhu);
        backService.insertBack(back);
        return 2;
    }

    /*分页查询所有退货*/
    @RequestMapping("/getAllBack")
    @ResponseBody
    public PageInfo<Back> getAllRuKu(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpServletRequest request) throws ParseException {
        Date starttime=null;
        Date overtime=null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        String time = request.getParameter("starttime");
        String otime = request.getParameter("overtime");
        if(time!=null&&time!=""){
            starttime = formatter.parse(time);
        }

        if(otime!=null&&otime!=""){
            overtime = formatter.parse(otime);
        }else{
            overtime =new Date();
        }

        PageHelper.startPage(pageNum,5);
        List<Back> list = backService.getAllBack(pname,cname,starttime,overtime);
        PageInfo<Back> pageInfo = new PageInfo<Back>(list);
        return pageInfo;
    }

}
