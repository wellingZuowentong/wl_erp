package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.bean.ShangPin;
import com.weiling.wl_erp.mapper.SellMapper;
import com.weiling.wl_erp.service.KuCunService;
import com.weiling.wl_erp.service.SellService;
import com.weiling.wl_erp.service.ShangPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/13
 * 销售信息
 */
@Controller
public class SellController {
    @Autowired
    private SellService sellService;
    @Autowired
    private ShangPinService shangPinService;
    @Autowired
    private KuCunService kuCunService;

    /*新增销售表*/
   /* @RequestMapping("insertSell")
    @ResponseBody
    public int insertSell(HttpServletRequest request){
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        Integer oksell = Integer.parseInt(request.getParameter("oksell"));
        BigDecimal sellprice = new BigDecimal(request.getParameter("sellprice"));
        String guige = request.getParameter("guige");
        BigDecimal allprice = new BigDecimal(request.getParameter("allprice"));
        BigDecimal overprice = new BigDecimal(request.getParameter("overprice"));
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
        sell.setZhuangtai(0);
        sell.setBeizhu(beizhu);
        return sellService.insertSell(sell);
    }*/

    /*查询所有销售表*/
    @RequestMapping("findAllSell")
    @ResponseBody
    public List<Sell> findAllSell(){
        return sellService.findAllSell();
    }

    /*根据销售ID查询销售*/
    @RequestMapping("findSellById")
    @ResponseBody
    public Sell findSellById(Integer id){
        return sellService.findSellById(id);
    }

    /*修改销售状态并修改库存状态*/
    /*还未实现出库表生成！！！！！！！！！！！！！！！！！！！！！！！！！！！*/
    @RequestMapping("updateZhuangTai")
    @ResponseBody
    public int updateZhuangTai(Integer id,Integer zhuangtai){
        Sell sell = sellService.findSellById(id);
        String pname = sell.getPname();
        String cname = sell.getCname();
        KuCun kuCun = kuCunService.findKuCunByName(pname,cname);
        kuCun.setSellnum(kuCun.getSellnum()-sell.getOksell());
        kuCunService.updateKuCunById(kuCun);
        return sellService.updateZhuangTai(id,zhuangtai);
    }

    /*修改销售信息*/
    @RequestMapping("updateSellById")
    @ResponseBody
    public int updateSellById(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("id"));
        Sell oldSell = sellService.findSellById(id);
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        Integer oksell = Integer.parseInt(request.getParameter("oksell"));
        BigDecimal sellprice = new BigDecimal(request.getParameter("sellprice"));
        String guige = request.getParameter("guige");
        BigDecimal allprice = new BigDecimal(request.getParameter("allprice"));
        BigDecimal overprice = new BigDecimal(request.getParameter("overprice"));
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
        sell.setBeizhu(beizhu);
        if(oldSell.getOksell()!=oksell){
            Integer newoksell = oldSell.getOksell()-oksell;
            ShangPin shangPin = shangPinService.findShangPinByName(pname,cname);
            shangPin.setSellnum(shangPin.getSellnum()+newoksell);
            shangPinService.updateShangPinById(shangPin);
        }
        return sellService.updateSellById(sell);
    }

















}
