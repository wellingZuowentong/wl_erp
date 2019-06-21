package com.weiling.wl_erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiling.wl_erp.bean.Back;
import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.OkBack;
import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.service.BackService;
import com.weiling.wl_erp.service.KuCunService;
import com.weiling.wl_erp.service.OkBackService;
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
public class OkBackController {
    @Autowired
    private BackService backService;
    @Autowired
    private SellService sellService;
    @Autowired
    private KuCunService kuCunService;
    @Autowired
    private OkBackService okBackService;

    @RequestMapping("insertBack")
    @ResponseBody
    public int insertBack(HttpServletRequest request){
        String okBackUser = request.getParameter("okBackUser");
        String beizhu = request.getParameter("beizhu");
       Integer id = Integer.parseInt(request.getParameter("id"));
       Back back = backService.findBackById(id);
       back.setZhuangtai(1);
       backService.updateBack(back);
       OkBack okBack = new OkBack();
       okBack.setPname(back.getPname());
       okBack.setCname(back.getCname());
       okBack.setBacknum(back.getBacknum());
       okBack.setBackprice(back.getBackprice());
       okBack.setBacktime(new Date());
       okBack.setBackuser(okBackUser);
       okBack.setBeizhu(beizhu);
        KuCun kuCun = kuCunService.findKuCunByName(back.getPname(),back.getCname());
        kuCun.setVnum(back.getBacknum()+kuCun.getVnum());
        kuCunService.updateKuCunById(kuCun);
        return okBackService.insertOkBack(okBack);
    }

    /*分页查询所有退货*/
    @RequestMapping("/getAllOkBack")
    @ResponseBody
    public PageInfo<OkBack> getAllOkBack(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpServletRequest request) throws ParseException {
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
        List<OkBack> list = okBackService.getAllOkBack(pname,cname,starttime,overtime);
        PageInfo<OkBack> pageInfo = new PageInfo<OkBack>(list);
        return pageInfo;
    }

}
