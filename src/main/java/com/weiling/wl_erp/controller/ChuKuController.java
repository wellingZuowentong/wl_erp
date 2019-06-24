package com.weiling.wl_erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiling.wl_erp.bean.ChuKu;
import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.User;
import com.weiling.wl_erp.service.ChuKuService;
import com.weiling.wl_erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/10
 * 出库实现类
 */
@Controller
public class ChuKuController {
    @Autowired
    private ChuKuService chuKuService;

    /*查询所有出库列表*/
    /*@RequestMapping("findAllChuKu")
    @ResponseBody
    public List<ChuKu> findAllChuKu(){
        return chuKuService.findAllChuKu();
    }*/

    /*分页查询所有出库信息*/
    @RequestMapping("/getAllChuKu")
    @ResponseBody
    public PageInfo<ChuKu> getAllChuKu(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,HttpServletRequest request) throws ParseException {
        Date starttime=null;
        Date overtime=null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        String time = request.getParameter("starttime");
        String otime = request.getParameter("overtime");
        if(time!=null&&time!=""){
            starttime = formatter.parse(time+" 00:00:01");
        }

        if(otime!=null&&otime!=""){
            overtime = formatter.parse(otime+" 23:59:59");
        }else{
            overtime =new Date();
        }
        PageHelper.startPage(pageNum,5);
        List<ChuKu> list = chuKuService.findAllChuKu(pname,cname,starttime,overtime);
        PageInfo<ChuKu> pageInfo = new PageInfo<ChuKu>(list);
        return pageInfo;
    }






}
