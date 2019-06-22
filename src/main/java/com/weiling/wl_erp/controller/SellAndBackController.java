package com.weiling.wl_erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiling.wl_erp.bean.Back;
import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.bean.SellAndBack;
import com.weiling.wl_erp.service.BackService;
import com.weiling.wl_erp.service.KuCunService;
import com.weiling.wl_erp.service.SellAndBackService;
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
public class SellAndBackController {
   @Autowired
    private SellAndBackService sellAndBackService;
    /*分页查询所有销售表*/
    @RequestMapping("/getAllSellAndBack")
    @ResponseBody
    public  PageInfo<SellAndBack> getAllShangPin(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,HttpServletRequest request) throws ParseException {
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
        List<SellAndBack> list = sellAndBackService.findAllSellAndBack(pname,cname,starttime,overtime);
        PageInfo<SellAndBack> pageInfo = new PageInfo<SellAndBack>(list);
        return pageInfo;
    }


}
