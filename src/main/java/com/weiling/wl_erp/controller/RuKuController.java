/*
package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.RuKu;
import com.weiling.wl_erp.bean.ShangPin;
import com.weiling.wl_erp.service.KuCunService;
import com.weiling.wl_erp.service.RuKuService;
import com.weiling.wl_erp.service.ShangPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

*/
/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 入库信息
 *//*

@Controller
public class RuKuController {
    @Autowired
    private RuKuService ruKuService;
    @Autowired
    private KuCunService kuCunService;


    */
/*添加库存*//*

    @RequestMapping("insertRuKu")
    @ResponseBody
    public int insertRuKu(HttpServletRequest request){
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        BigDecimal inprice = new BigDecimal(request.getParameter("inprice"));
        BigDecimal outprice = new BigDecimal(request.getParameter("outprice"));
        BigDecimal sellprice = new BigDecimal(request.getParameter("sellprice"));
        Integer vnum = Integer.parseInt(request.getParameter(""));
        String guige = request.getParameter("guige");
        Date rukutime = new Date();
        String username = request.getParameter("username");
        String beizhu = request.getParameter("beizhu");
        RuKu ruKu = new RuKu();


    }

    */
/*查询所有入库列表*//*

    @RequestMapping("findAllRuKu")
    @ResponseBody
    public List<RuKu> findAllRuKu(){
        return ruKuService.findAllRuKu();
    }

    */
/*根据ID查询入库信息*//*

    @RequestMapping("findRuKuById")
    @ResponseBody
    public KuCun findKuCunById(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("id"));
        return ruKuService.findRuKuById(id);
    }

    */
/*根据ID修改入库信息*//*

    @RequestMapping("updateRuKuById")
    @ResponseBody
    public int updateRuKuById(HttpServletRequest request){
        return 1;
    }

    */
/*根据ID删除库存*//*

    @RequestMapping("deleteRuKuById")
    @ResponseBody
    public int deleteKuCunById(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        return ruKuService.deleteRuKuById(id);
    }

   */
/* *//*
*/
/*根据入库ID添加库存表*//*
*/
/*
    @RequestMapping("addKuCun")
    @ResponseBody
   public int addKuCun(){

    }*//*








}
*/
