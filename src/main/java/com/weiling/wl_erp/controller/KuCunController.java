package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.ShangPin;
import com.weiling.wl_erp.service.KuCunService;
import com.weiling.wl_erp.service.ShangPinService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /*查询所有库存列表*/
    @RequestMapping("findAllKuCun")
    @ResponseBody
    public List<KuCun> findAllKuCun(){
        return kuCunService.findAllKuCun();
    }

    /*根据ID查询库存*/
    @RequestMapping("findKuCunById")
    @ResponseBody
    public KuCun findKuCunById(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("id"));
        return kuCunService.findKuCunById(id);
    }

    /*根据ID修改库存*/
    @RequestMapping("updateKuCunById")
    @ResponseBody
    public int updateKuCunById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer sellnum = Integer.parseInt(request.getParameter("sellnum"));
        KuCun kuCun = kuCunService.findKuCunById(id);
        kuCun.setSellnum(sellnum);
        return kuCunService.updateKuCunById(kuCun);
    }

    /*根据ID删除库存*/
    @RequestMapping("deleteKuCunById")
    @ResponseBody
    public int deleteKuCunById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));

        return kuCunService.deleteKuCunById(id);
    }

    /*根据库存ID添加商品表*/
    @RequestMapping("addShangPin")
    @ResponseBody
    public List<KuCun> addShangPin(Integer id,Integer sellnum,String beizhu){
        KuCun kuCun = kuCunService.findKuCunById(id);
        kuCun.setVnum(kuCun.getVnum()-sellnum);
        kuCun.setSellnum(sellnum);
        kuCunService.updateKuCunById(kuCun);
        ShangPin shangPin = new ShangPin();
        shangPin.setCname(kuCun.getCname());
        shangPin.setPname(kuCun.getPname());
        shangPin.setSellnum(kuCun.getSellnum());
        shangPin.setGuige(kuCun.getGuige());
        shangPin.setSellprice(kuCun.getSellprice());
        shangPin.setBeizhu(beizhu);
        ShangPin newshangpin = shangPinService.findShangPinByName(shangPin.getPname(),shangPin.getCname());
        if(newshangpin!=null){
            newshangpin.setSellnum(kuCun.getSellnum());
            newshangpin.setBeizhu(beizhu);
            shangPinService.updateShangPinById(newshangpin);
        }else {
            shangPinService.insertShangPin(shangPin);
        }
        return kuCunService.findAllKuCun();
    }







}
