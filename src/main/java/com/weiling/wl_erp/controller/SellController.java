package com.weiling.wl_erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiling.wl_erp.bean.ChuKu;
import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.bean.ShangPin;
import com.weiling.wl_erp.mapper.SellMapper;
import com.weiling.wl_erp.service.ChuKuService;
import com.weiling.wl_erp.service.KuCunService;
import com.weiling.wl_erp.service.SellService;
import com.weiling.wl_erp.service.ShangPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
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
    @Autowired
    private ChuKuService chuKuService;

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

    /*销售驳回操作*/
    @RequestMapping("backsell")
    @ResponseBody
    public int backsell(Integer id,String outuser,String beizhu){
        Sell sell = sellService.findSellById(id);
        sell.setZhuangtai(2);
        sellService.updateSellById(sell);
        ShangPin shangPin = shangPinService.findShangPinByName(sell.getPname(),sell.getCname());
        shangPin.setSellnum(shangPin.getSellnum()+sell.getOksell());
        return shangPinService.updateShangPinById(shangPin);
    }


    /*销售出库操作*/
    @RequestMapping("outsell")
    @ResponseBody
    public int outsell(Integer id,String outuser,String beizhu){
        Sell sell = sellService.findSellById(id);
        String pname = sell.getPname();
        String cname = sell.getCname();
        KuCun kuCun = kuCunService.findKuCunByName(pname,cname);
        kuCun.setSellnum(kuCun.getSellnum()-sell.getOksell());
        kuCunService.updateKuCunById(kuCun);
        ChuKu chuKu = new ChuKu();
        chuKu.setPname(pname);
        chuKu.setCname(cname);
        chuKu.setOutnum(sell.getOksell());
        chuKu.setOutprice(sell.getSellprice());
        chuKu.setOutallprice(sell.getOverprice());
        chuKu.setGuige(sell.getGuige());
        chuKu.setOutuser(outuser);
        chuKu.setOuttime(new Date());
        chuKu.setBeizhu(beizhu);
        chuKuService.insertChuKu(chuKu);
        return sellService.updateZhuangTai(id,1);
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

    /*分页查询所有销售表*/
    @RequestMapping("/getAllSell")
    @ResponseBody
    public PageInfo<Sell> getAllShangPin(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Sell> list = sellService.findAllSell();
        PageInfo<Sell> pageInfo = new PageInfo<Sell>(list);
        return pageInfo;
    }
















}
