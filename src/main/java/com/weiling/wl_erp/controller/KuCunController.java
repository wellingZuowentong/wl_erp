package com.weiling.wl_erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.RuKu;
import com.weiling.wl_erp.bean.ShangPin;
import com.weiling.wl_erp.service.KuCunService;
import com.weiling.wl_erp.service.ShangPinService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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

    /*根据ID修改库存表*/
    @RequestMapping("updateKuCunById")
    @ResponseBody
    public int updateKuCunById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        BigDecimal inprice = new BigDecimal(request.getParameter("inprice"));
        BigDecimal outprice = new BigDecimal(request.getParameter("outprice"));
        BigDecimal sellprice = new BigDecimal(request.getParameter("sellprice"));
        String guige = request.getParameter("guige");
        String beizhu = request.getParameter("beizhu");
        KuCun kuCun = kuCunService.findKuCunById(id);
        kuCun.setPname(pname);
        kuCun.setCname(cname);
        kuCun.setInprice(inprice);
        kuCun.setOutprice(outprice);
        kuCun.setSellprice(sellprice);
        kuCun.setGuige(guige);
        kuCun.setBeizhu(beizhu);
        return kuCunService.updateKuCunById(kuCun);
    }

    /*根据ID删除库存*/
    @RequestMapping("deleteKuCunById")
    @ResponseBody
    public int deleteKuCunById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));

        return kuCunService.deleteKuCunById(id);
    }

    /*根据库存ID添加预售商品表*/
    @RequestMapping("addShangPin")
    @ResponseBody
    public List<KuCun> addShangPin(Integer id,Integer sellnum,String beizhu){
        KuCun kuCun = kuCunService.findKuCunById(id);
        kuCun.setVnum(kuCun.getVnum()+kuCun.getSellnum()-sellnum);
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


    /*分页查询所有库存表*/
    @RequestMapping("/getAllKuCun")
    @ResponseBody
    public PageInfo<KuCun> getAllKuCun(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<KuCun> list = kuCunService.findAllKuCun();
        PageInfo<KuCun> pageInfo = new PageInfo<KuCun>(list);
        return pageInfo;
    }




}
