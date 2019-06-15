package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.*;
import com.weiling.wl_erp.service.*;
import com.weiling.wl_erp.util.DateUtil;
import com.weiling.wl_erp.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者:左文统
 * 日期:2019/6/12
 * 功能:Excel测试controller
 * */
@RestController
public class TestExcelController {
    @Autowired
    private SellService sellService;
    @Autowired
    private RuKuService ruKuService;
    @Autowired
    private KuCunService kuCunService;
    @Autowired
    private ChuKuService chuKuService;
    @Autowired
    private ShangPinService shangPinService;

    @RequestMapping(value = "/excelsell", method = RequestMethod.GET)
    public void excelsell(HttpServletResponse response, HttpServletRequest request) throws Exception {
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


        ExcelData data = new ExcelData();
        data.setName("销售表");
        List<String> titles1 = new ArrayList();
        titles1.add("商品名");
        titles1.add("厂家");
        titles1.add("销售数量");
        titles1.add("售价");
        titles1.add("规格");
        titles1.add("销售总价");
        titles1.add("销售人");
        titles1.add("销售时间");
        titles1.add("状态");
        titles1.add("备注");
        data.setTitles(titles1);

        List<List<Object>> rows = new ArrayList();
        List<Sell> list = sellService.findAllSell(pname,cname,starttime,overtime);
        for(Sell sell:list) {
            List<Object> row = new ArrayList();
            row.add(sell.getPname());
            row.add(sell.getCname());
            row.add(sell.getOksell());
            row.add(sell.getSellprice());
            row.add(sell.getGuige());
            row.add(sell.getAllprice());
            row.add(sell.getSelluser());
            row.add(DateUtil.formatNormalDateString(sell.getSelltime()));
            if(sell.getZhuangtai()==0){
                row.add("未出库");
            }
            if(sell.getZhuangtai()==1){
                row.add("已出库");
            }
            if(sell.getZhuangtai()==2){
                row.add("被驳回");
            }

            row.add(sell.getBeizhu());
            rows.add(row);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName = fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

    @RequestMapping(value = "/excelruku", method = RequestMethod.GET)
    public void excelruku(HttpServletResponse response, HttpServletRequest request) throws Exception {
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


        ExcelData data = new ExcelData();
        data.setName("入库表");
        List<String> titles1 = new ArrayList();
        titles1.add("商品名");
        titles1.add("厂家");
        titles1.add("进货价");
        titles1.add("出库价");
        titles1.add("销售价");
        titles1.add("入库数量");
        titles1.add("规格");
        titles1.add("入库时间");
        titles1.add("入库人");
        titles1.add("备注");
        data.setTitles(titles1);

        List<List<Object>> rows = new ArrayList();
        List<RuKu> list = ruKuService.findAllRuKu(pname,cname,starttime,overtime);
        for(RuKu ruKu:list) {
            List<Object> row = new ArrayList();
            row.add(ruKu.getPname());
            row.add(ruKu.getCname());
            row.add(ruKu.getInprice());
            row.add(ruKu.getOutprice());
            row.add(ruKu.getSellprice());
            row.add(ruKu.getVnum());
            row.add(ruKu.getGuige());
            row.add(DateUtil.formatNormalDateString(ruKu.getRukutime()));
            row.add(ruKu.getUsername());
            row.add(ruKu.getBeizhu());
            rows.add(row);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName = fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

    @RequestMapping(value = "/excelchuku", method = RequestMethod.GET)
    public void excelchuku(HttpServletResponse response, HttpServletRequest request) throws Exception {
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


        ExcelData data = new ExcelData();
        data.setName("出库表");
        List<String> titles1 = new ArrayList();
        titles1.add("商品名");
        titles1.add("厂家");
        titles1.add("出库数量");
        titles1.add("出库单价");
        titles1.add("规格");
        titles1.add("出库总价");
        titles1.add("出库人");
        titles1.add("出库时间");
        titles1.add("备注");
        data.setTitles(titles1);

        List<List<Object>> rows = new ArrayList();
        List<ChuKu> list = chuKuService.findAllChuKu(pname,cname,starttime,overtime);
        for(ChuKu chuKu:list) {
            List<Object> row = new ArrayList();
            row.add(chuKu.getPname());
            row.add(chuKu.getCname());
            row.add(chuKu.getOutnum());
            row.add(chuKu.getOutprice());
            row.add(chuKu.getGuige());
            row.add(chuKu.getOutallprice());
            row.add(chuKu.getOutuser());
            row.add(DateUtil.formatNormalDateString(chuKu.getOuttime()));
            row.add(chuKu.getBeizhu());
            rows.add(row);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName = fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

    @RequestMapping(value = "/excelshangpin", method = RequestMethod.GET)
    public void excelshangpin(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        ExcelData data = new ExcelData();
        data.setName("商品表");
        List<String> titles1 = new ArrayList();
        titles1.add("商品名");
        titles1.add("厂家");
        titles1.add("价格");
        titles1.add("预售数量");
        titles1.add("规格");
        titles1.add("备注");
        data.setTitles(titles1);

        List<List<Object>> rows = new ArrayList();
        List<ShangPin> list = shangPinService.findAllShangPin(pname,cname);
        for(ShangPin shangPin:list) {
            List<Object> row = new ArrayList();
            row.add(shangPin.getPname());
            row.add(shangPin.getCname());
            row.add(shangPin.getSellprice());
            row.add(shangPin.getSellnum());
            row.add(shangPin.getGuige());
            row.add(shangPin.getBeizhu());
            rows.add(row);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName = fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

    @RequestMapping(value = "/excelkucun", method = RequestMethod.GET)
    public void excelkucun(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String pname = request.getParameter("pname");
        String cname = request.getParameter("cname");
        ExcelData data = new ExcelData();
        data.setName("库存表");
        List<String> titles1 = new ArrayList();
        titles1.add("商品名");
        titles1.add("厂家");
        titles1.add("进货价");
        titles1.add("出库价");
        titles1.add("销售价");
        titles1.add("库存数量");
        titles1.add("预售数量");
        titles1.add("规格");
        titles1.add("备注");
        data.setTitles(titles1);

        List<List<Object>> rows = new ArrayList();
        List<KuCun> list = kuCunService.findAllKuCun(pname,cname);
        for(KuCun kuCun:list) {
            List<Object> row = new ArrayList();
            row.add(kuCun.getPname());
            row.add(kuCun.getCname());
            row.add(kuCun.getInprice());
            row.add(kuCun.getOutprice());
            row.add(kuCun.getSellprice());
            row.add(kuCun.getVnum());
            row.add(kuCun.getSellnum());
            row.add(kuCun.getGuige());
            row.add(kuCun.getBeizhu());
            rows.add(row);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName = fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

}
