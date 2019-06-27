package com.weiling.wl_erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.RuKu;
import com.weiling.wl_erp.bean.ShangPin;
import com.weiling.wl_erp.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 库存信息
 */
@Controller
public class KuCunController {
    @Autowired
    private KuCunService kuCunService;
    @Autowired
    private ShangPinService shangPinService;
    @Autowired
    private SellService sellService;
    @Autowired
    private ChuKuService chuKuService;
    @Autowired
    private RuKuService ruKuService;

    /*查询所有库存列表*/
   /* @RequestMapping("findAllKuCun")
    @ResponseBody
    public List<KuCun> findAllKuCun(){
        return kuCunService.findAllKuCun();
    }*/

    /*根据ID查询库存*/
    @RequestMapping("findKuCunById")
    @ResponseBody
    public KuCun findKuCunById(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("id"));
        return kuCunService.findKuCunById(id);
    }

    /*根据ID修改库存表*/
    @RequestMapping("updateKuCunById")
    @ResponseBody
    @Transactional
    public  Map<String,String> updateKuCunById(HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        BigDecimal inprice = new BigDecimal(request.getParameter("inprice"));
        BigDecimal outprice = new BigDecimal(request.getParameter("outprice"));
        BigDecimal sellprice = new BigDecimal(request.getParameter("sellprice"));
        String guige = request.getParameter("guige");
        String beizhu = request.getParameter("beizhu");
        KuCun kuCun = kuCunService.findKuCunById(id);
        if(kuCun!=null) {
            String odpname = kuCun.getPname();
            String odcname = kuCun.getCname();
            kuCun.setPname(pname);
            kuCun.setCname(cname);
            kuCun.setInprice(inprice);
            kuCun.setOutprice(outprice);
            kuCun.setSellprice(sellprice);
            kuCun.setGuige(guige);
            kuCun.setBeizhu(beizhu);
            kuCunService.updateKuCunById(kuCun);
            ShangPin shangpin = shangPinService.findShangPinByName(odpname, odcname);
            if(shangpin!=null){
                shangpin.setPname(pname);
                shangpin.setCname(cname);
                shangpin.setSellprice(sellprice);
            }
            chuKuService.updateChuKuName(pname, cname, odpname, odcname);
            ruKuService.updateRuKuName(pname, cname, odpname, odcname);
            sellService.updateSellName(pname, cname, odpname, odcname);
            shangPinService.updateShangPinById(shangpin);
            map.put("code","1");
            return map;
        }
        map.put("code","2");
        return map;

    }

    /*根据ID删除库存*/
    @RequestMapping("deleteKuCunById")
    @ResponseBody
    @Transactional
    public int deleteKuCunById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        KuCun kuCun = kuCunService.findKuCunById(id);
        if(kuCun!=null) {
            String pname = kuCun.getPname();
            String cname = kuCun.getCname();
            ShangPin shangPin = shangPinService.findShangPinByName(pname, cname);
            if (shangPin != null) {
                Integer sid = shangPin.getId();
                shangPinService.deleteShangPinById(sid);
            }
            return kuCunService.deleteKuCunById(id);

        }
        return 0;
    }

    /*根据库存ID添加预售商品表*/
    @RequestMapping("addShangPin")
    @ResponseBody
    @Transactional
    public Map<String,String> addShangPin(Integer id, Integer sellnum, String beizhu){
        Map<String,String> map = new HashMap<>();
        KuCun kuCun = kuCunService.findKuCunById(id);
        if(kuCun!=null) {
            int notout = sellService.findSellByZhuangtai(kuCun.getPname(), kuCun.getCname());
            kuCun.setVnum(kuCun.getVnum() + kuCun.getSellnum() - sellnum);
            kuCun.setSellnum(sellnum);
            kuCunService.updateKuCunById(kuCun);
            ShangPin shangPin = new ShangPin();
            shangPin.setCname(kuCun.getCname());
            shangPin.setPname(kuCun.getPname());
            shangPin.setSellnum(kuCun.getSellnum());
            shangPin.setGuige(kuCun.getGuige());
            shangPin.setSellprice(kuCun.getSellprice());
            shangPin.setBeizhu(beizhu);
            ShangPin newshangpin = shangPinService.findShangPinByName(shangPin.getPname(), shangPin.getCname());
            if (newshangpin != null) {
                newshangpin.setSellnum(kuCun.getSellnum());
                newshangpin.setBeizhu(beizhu);
                shangPinService.updateShangPinById(newshangpin);
            } else {
                shangPinService.insertShangPin(shangPin);
            }
           map.put("code","1");
            return map;
        }
        map.put("code","2");
        return map;
    }


    /*分页查询所有库存表*/
    @RequestMapping("/getAllKuCun")
    @ResponseBody
    public PageInfo<KuCun> getAllKuCun(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,HttpServletRequest request){
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        PageHelper.startPage(pageNum,10);
        List<KuCun> list = kuCunService.findAllKuCun(pname,cname);
        PageInfo<KuCun> pageInfo = new PageInfo<KuCun>(list);
        return pageInfo;
    }




}
