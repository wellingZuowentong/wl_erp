package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.Back;
import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.service.BackService;
import com.weiling.wl_erp.service.KuCunService;
import com.weiling.wl_erp.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

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
        String order = request.getParameter("order");
        Sell sell = sellService.findSellByOrder(order);
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
        back.setOrder(order);
        back.setBackuser(backuser);
        back.setBeizhu(beizhu);
        sell.setOksell(sell.getOksell()-backnum);
        sell.setOverprice(sell.getOverprice().subtract(backprice));
        KuCun kuCun = kuCunService.findKuCunByName(pname,cname);
        if(kuCun==null){
            return 2;
        }
        kuCun.setVnum(kuCun.getVnum()+backnum);
        kuCunService.updateKuCunById(kuCun);
        backService.insertBack(back);
        sellService.updateSellById(sell);
        return 3;
    }

}
