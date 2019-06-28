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
import java.math.BigDecimal;
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
    @Autowired
    private BackService backService;
    @Autowired
    private SellAndBackService sellAndBackService;
    @Autowired
    private OkBackService okBackService;

    @RequestMapping(value = "/excelsell", method = RequestMethod.GET)
    public void excelsell(HttpServletResponse response, HttpServletRequest request) throws Exception {
        BigDecimal yzongjia = new BigDecimal("0");
        BigDecimal wzongjia = new BigDecimal("0");
        Integer yout = 0;
        Integer wout = 0;
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


        ExcelData data = new ExcelData();
        data.setName("销售表");
        List<String> titles1 = new ArrayList();
        titles1.add("商品名");
        titles1.add("厂家");
        titles1.add("销售数量");
        titles1.add("售价");
        titles1.add("规格");
        titles1.add("销售总价");
        titles1.add("实售总价");
        titles1.add("销售人");
        titles1.add("销售时间");
        titles1.add("状态");
        titles1.add("备注");
        data.setTitles(titles1);

        List<List<Object>> rows = new ArrayList();

        String allid = request.getParameter("allid");
        List<Sell> allSell = new ArrayList<>();
        if(allid!=null&&allid!="") {
            String[] newid = allid.split(",");
            for (String cid : newid) {
                Integer id = Integer.parseInt(cid);
                Sell osell = sellService.findSellById(id);
                allSell.add(osell);
            }
            for (Sell sell : allSell) {
                List<Object> row = new ArrayList();
                row.add(sell.getPname());
                row.add(sell.getCname());
                row.add(sell.getOksell());
                row.add(sell.getSellprice());
                row.add(sell.getGuige());
                row.add(sell.getAllprice());
                row.add(sell.getOverprice());
                row.add(sell.getSelluser());
                row.add(DateUtil.formatNormalDateString(sell.getSelltime()));
                if (sell.getZhuangtai() == 0) {
                    wzongjia = wzongjia.add(sell.getOverprice());
                    wout = wout + sell.getOksell();
                    row.add("未出库");
                }
                if (sell.getZhuangtai() == 1) {
                    yzongjia = yzongjia.add(sell.getOverprice());
                    yout = yout + sell.getOksell();
                    row.add("已出库");
                }
                if (sell.getZhuangtai() == 2) {
                    row.add("被驳回");
                }

                row.add(sell.getBeizhu());
                rows.add(row);
            }
            List<Object> row1 = new ArrayList<>();
            row1.add("合计:");
            List<Object> row2 = new ArrayList<>();
            row2.add("未出库数量");
            row2.add(wout);
            row2.add("未出库总价");
            row2.add(wzongjia);
            List<Object> row3 = new ArrayList<>();
            row3.add("已出库数量");
            row3.add(yout);
            row3.add("已出库总价");
            row3.add(yzongjia);
            rows.add(row1);
            rows.add(row2);
            rows.add(row3);

        }else {
            List<Sell> list = sellService.findAllSell(pname, cname, starttime, overtime);
            for (Sell sell : list) {
                List<Object> row = new ArrayList();
                row.add(sell.getPname());
                row.add(sell.getCname());
                row.add(sell.getOksell());
                row.add(sell.getSellprice());
                row.add(sell.getGuige());
                row.add(sell.getAllprice());
                row.add(sell.getOverprice());
                row.add(sell.getSelluser());
                row.add(DateUtil.formatNormalDateString(sell.getSelltime()));
                if (sell.getZhuangtai() == 0) {
                    wzongjia = wzongjia.add(sell.getOverprice());
                    wout = wout + sell.getOksell();
                    row.add("未出库");
                }
                if (sell.getZhuangtai() == 1) {
                    yzongjia = yzongjia.add(sell.getOverprice());
                    yout = yout + sell.getOksell();
                    row.add("已出库");
                }
                if (sell.getZhuangtai() == 2) {
                    row.add("被驳回");
                }

                row.add(sell.getBeizhu());
                rows.add(row);
            }
            List<Object> row1 = new ArrayList<>();
            row1.add("合计:");
            List<Object> row2 = new ArrayList<>();
            row2.add("未出库数量");
            row2.add(wout);
            row2.add("未出库总价");
            row2.add(wzongjia);
            List<Object> row3 = new ArrayList<>();
            row3.add("已出库数量");
            row3.add(yout);
            row3.add("已出库总价");
            row3.add(yzongjia);
            rows.add(row1);
            rows.add(row2);
            rows.add(row3);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("MMddHHmmss");
        String fileName = "销售表"+fdate.format(new Date()) + ".xls";

        ExcelUtils.exportExcel(response, fileName, data);
    }

    @RequestMapping(value = "/excelruku", method = RequestMethod.GET)
    public void excelruku(HttpServletResponse response, HttpServletRequest request) throws Exception {
        BigDecimal zongjinjia = new BigDecimal("0");
        BigDecimal zongchujia = new BigDecimal("0");
        BigDecimal zongmaijia = new BigDecimal("0");
        Integer zongshuliang = 0;
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
        String allid = request.getParameter("allid");
        List<RuKu> allRuKu= new ArrayList<>();
        if(allid!=null&&allid!="") {
            String[] newid = allid.split(",");
            for (String cid : newid) {
                Integer id = Integer.parseInt(cid);
                RuKu oruku = ruKuService.findRuKuById(id);
                allRuKu.add(oruku);
            }
            for (RuKu ruKu : allRuKu) {
                List<Object> row = new ArrayList();
                zongjinjia = zongjinjia.add(ruKu.getInprice().multiply(new BigDecimal(ruKu.getVnum())));
                zongchujia = zongchujia.add(ruKu.getOutprice().multiply(new BigDecimal(ruKu.getVnum())));
                zongmaijia = zongmaijia.add(ruKu.getSellprice().multiply(new BigDecimal(ruKu.getVnum())));
                zongshuliang = zongshuliang + ruKu.getVnum();
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
            List<Object> row1 = new ArrayList<>();
            row1.add("合计：");
            List<Object> row2 = new ArrayList<>();
            row2.add("总进货价：");
            row2.add(zongjinjia);
            row2.add("总出库价：");
            row2.add(zongchujia);
            row2.add("总销售价：");
            row2.add(zongmaijia);
            row2.add("进货总数量：");
            row2.add(zongshuliang);
            rows.add(row1);
            rows.add(row2);
        }else {
            List<RuKu> list = ruKuService.findAllRuKu(pname, cname, starttime, overtime);
            for (RuKu ruKu : list) {
                List<Object> row = new ArrayList();
                zongjinjia = zongjinjia.add(ruKu.getInprice().multiply(new BigDecimal(ruKu.getVnum())));
                zongchujia = zongchujia.add(ruKu.getOutprice().multiply(new BigDecimal(ruKu.getVnum())));
                zongmaijia = zongmaijia.add(ruKu.getSellprice().multiply(new BigDecimal(ruKu.getVnum())));
                zongshuliang = zongshuliang + ruKu.getVnum();
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
            List<Object> row1 = new ArrayList<>();
            row1.add("合计：");
            List<Object> row2 = new ArrayList<>();
            row2.add("总进货价：");
            row2.add(zongjinjia);
            row2.add("总出库价：");
            row2.add(zongchujia);
            row2.add("总销售价：");
            row2.add(zongmaijia);
            row2.add("进货总数量：");
            row2.add(zongshuliang);
            rows.add(row1);
            rows.add(row2);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("MMddHHmmss");
        String fileName = "入库表"+fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

    @RequestMapping(value = "/excelchuku", method = RequestMethod.GET)
    public void excelchuku(HttpServletResponse response, HttpServletRequest request) throws Exception {
        Integer zongnum = 0;
        BigDecimal zongjia = new BigDecimal("0");
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
        String allid = request.getParameter("allid");
        List<ChuKu> allChuKu= new ArrayList<>();
        if(allid!=null&&allid!="") {
            String[] newid = allid.split(",");
            for (String cid : newid) {
                Integer id = Integer.parseInt(cid);
                ChuKu ochuku = chuKuService.findChuKuById(id);
                allChuKu.add(ochuku);
            }
            for (ChuKu chuKu : allChuKu) {
                List<Object> row = new ArrayList();
                zongnum = zongnum + chuKu.getOutnum();
                zongjia = zongjia.add(chuKu.getOutallprice());
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
            List<Object> row1 = new ArrayList<>();
            row1.add("合计：");
            List<Object> row2 = new ArrayList<>();
            row2.add("总出库数量：");
            row2.add(zongnum);
            row2.add("出库总价：");
            row2.add(zongjia);
            rows.add(row1);
            rows.add(row2);
        }else {
            List<ChuKu> list = chuKuService.findAllChuKu(pname, cname, starttime, overtime);
            for (ChuKu chuKu : list) {
                List<Object> row = new ArrayList();
                zongnum = zongnum + chuKu.getOutnum();
                zongjia = zongjia.add(chuKu.getOutallprice());
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
            List<Object> row1 = new ArrayList<>();
            row1.add("合计：");
            List<Object> row2 = new ArrayList<>();
            row2.add("总出库数量：");
            row2.add(zongnum);
            row2.add("出库总价：");
            row2.add(zongjia);
            rows.add(row1);
            rows.add(row2);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("MMddHHmmss");
        String fileName = "出库表"+fdate.format(new Date()) + ".xls";
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
        String allid = request.getParameter("allid");
        List<ShangPin> allShangPin= new ArrayList<>();
        if(allid!=null&&allid!="") {
            String[] newid = allid.split(",");
            for (String cid : newid) {
                Integer id = Integer.parseInt(cid);
                ShangPin oShangPin = shangPinService.findShangPinById(id);
                allShangPin.add(oShangPin);
            }
            for (ShangPin shangPin : allShangPin) {
                List<Object> row = new ArrayList();
                row.add(shangPin.getPname());
                row.add(shangPin.getCname());
                row.add(shangPin.getSellprice());
                row.add(shangPin.getSellnum());
                row.add(shangPin.getGuige());
                row.add(shangPin.getBeizhu());
                rows.add(row);
            }
        }else {
            List<ShangPin> list = shangPinService.findAllShangPin(pname, cname);
            for (ShangPin shangPin : list) {
                List<Object> row = new ArrayList();
                row.add(shangPin.getPname());
                row.add(shangPin.getCname());
                row.add(shangPin.getSellprice());
                row.add(shangPin.getSellnum());
                row.add(shangPin.getGuige());
                row.add(shangPin.getBeizhu());
                rows.add(row);
            }
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("MMddHHmmss");
        String fileName = "商品表"+fdate.format(new Date()) + ".xls";
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

        String allid = request.getParameter("allid");
        List<KuCun> allKuCun = new ArrayList<>();
        if(allid!=null&&allid!="") {
            String[] newid = allid.split(",");
            for (String cid : newid) {
                Integer id = Integer.parseInt(cid);
                KuCun okuCun = kuCunService.findKuCunById(id);
                allKuCun.add(okuCun);
            }
            for(KuCun kuCun:allKuCun) {
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
        }else {
            List<KuCun> list = kuCunService.findAllKuCun(pname, cname);
            for (KuCun kuCun : list) {
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
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("MMddHHmmss");
        String fileName = "库存表"+fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }
    @RequestMapping(value = "/excelBack", method = RequestMethod.GET)
    public void excelBack(HttpServletResponse response, HttpServletRequest request) throws Exception {

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


        ExcelData data = new ExcelData();
        data.setName("退货表");
        List<String> titles1 = new ArrayList();
        titles1.add("订单编号");
        titles1.add("商品名");
        titles1.add("厂家");
        titles1.add("退货数量");
        titles1.add("退货总价");
        titles1.add("退货人");
        titles1.add("退货时间");
        titles1.add("备注");
        data.setTitles(titles1);

        List<List<Object>> rows = new ArrayList();
        String allid = request.getParameter("allid");
        List<Back> allBack= new ArrayList<>();
        if(allid!=null&&allid!="") {
            String[] newid = allid.split(",");
            for (String cid : newid) {
                Integer id = Integer.parseInt(cid);
                Back oBack = backService.findBackById(id);
                allBack.add(oBack);
            }
            Integer num = 0;
            BigDecimal price = new BigDecimal("0");
            for (Back back : allBack) {
                List<Object> row = new ArrayList();
                row.add(back.getOrdercode());
                row.add(back.getPname());
                row.add(back.getCname());
                row.add(back.getBacknum());
                num = num + back.getBacknum();
                row.add(back.getBackprice());
                price = price.add(back.getBackprice());
                row.add(back.getBackuser());
                row.add(DateUtil.formatNormalDateString(back.getBacktime()));
                row.add(back.getBeizhu());
                rows.add(row);
            }
            List<Object> row1 = new ArrayList<>();
            row1.add("合计：");
            List<Object> row2 = new ArrayList<>();
            row2.add("总退货数量：");
            row2.add(num);
            row2.add("总退货价：");
            row2.add(price);
            rows.add(row1);
            rows.add(row2);
        }else {
            List<Back> list = backService.getAllBack(pname, cname, starttime, overtime);
            Integer num = 0;
            BigDecimal price = new BigDecimal("0");
            for (Back back : list) {
                List<Object> row = new ArrayList();
                row.add(back.getOrdercode());
                row.add(back.getPname());
                row.add(back.getCname());
                row.add(back.getBacknum());
                num = num + back.getBacknum();
                row.add(back.getBackprice());
                price = price.add(back.getBackprice());
                row.add(back.getBackuser());
                row.add(DateUtil.formatNormalDateString(back.getBacktime()));
                row.add(back.getBeizhu());
                rows.add(row);
            }
            List<Object> row1 = new ArrayList<>();
            row1.add("合计：");
            List<Object> row2 = new ArrayList<>();
            row2.add("总退货数量：");
            row2.add(num);
            row2.add("总退货价：");
            row2.add(price);
            rows.add(row1);
            rows.add(row2);
        }
        data.setRows(rows);
        SimpleDateFormat fdate = new SimpleDateFormat("MMddHHmmss");
        String fileName = "待退货表"+fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

    @RequestMapping(value = "/excelokBack", method = RequestMethod.GET)
    public void excelokBack(HttpServletResponse response, HttpServletRequest request) throws Exception {

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


        ExcelData data = new ExcelData();
        data.setName("退货表");
        List<String> titles1 = new ArrayList();
        titles1.add("订单编号");
        titles1.add("商品名");
        titles1.add("厂家");
        titles1.add("退货数量");
        titles1.add("退货总价");
        titles1.add("退货人");
        titles1.add("退货时间");
        titles1.add("备注");
        data.setTitles(titles1);

        List<List<Object>> rows = new ArrayList();
        String allid = request.getParameter("allid");
        List<OkBack> allOkBack= new ArrayList<>();
        if(allid!=null&&allid!="") {
            String[] newid = allid.split(",");
            for (String cid : newid) {
                Integer id = Integer.parseInt(cid);
                OkBack oBack =okBackService.findOkBackById(id);
                allOkBack.add(oBack);
            }
            Integer num = 0;
            BigDecimal price = new BigDecimal("0");
            for (OkBack back : allOkBack) {
                List<Object> row = new ArrayList();
                row.add(back.getOrdercode());
                row.add(back.getPname());
                row.add(back.getCname());
                row.add(back.getBacknum());
                num = num + back.getBacknum();
                row.add(back.getBackprice());
                price = price.add(back.getBackprice());
                row.add(back.getBackuser());
                row.add(DateUtil.formatNormalDateString(back.getBacktime()));
                row.add(back.getBeizhu());
                rows.add(row);
            }
            List<Object> row1 = new ArrayList<>();
            row1.add("合计：");
            List<Object> row2 = new ArrayList<>();
            row2.add("总退货数量：");
            row2.add(num);
            row2.add("总退货价：");
            row2.add(price);
            rows.add(row1);
            rows.add(row2);
        }else {
            List<OkBack> list =okBackService.getAllOkBack(pname, cname, starttime, overtime);
            Integer num = 0;
            BigDecimal price = new BigDecimal("0");
            for (OkBack back : list) {
                List<Object> row = new ArrayList();
                row.add(back.getOrdercode());
                row.add(back.getPname());
                row.add(back.getCname());
                row.add(back.getBacknum());
                num = num + back.getBacknum();
                row.add(back.getBackprice());
                price = price.add(back.getBackprice());
                row.add(back.getBackuser());
                row.add(DateUtil.formatNormalDateString(back.getBacktime()));
                row.add(back.getBeizhu());
                rows.add(row);
            }
            List<Object> row1 = new ArrayList<>();
            row1.add("合计：");
            List<Object> row2 = new ArrayList<>();
            row2.add("总退货数量：");
            row2.add(num);
            row2.add("总退货价：");
            row2.add(price);
            rows.add(row1);
            rows.add(row2);
        }
        data.setRows(rows);
        SimpleDateFormat fdate = new SimpleDateFormat("MMddHHmmss");
        String fileName = "退货表"+fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }


    @RequestMapping(value = "/excelSellAndBack", method = RequestMethod.GET)
    public void excelSellAndBack(HttpServletResponse response, HttpServletRequest request) throws Exception {
        Integer xshj=0;
        Integer thhi=0;
        BigDecimal xszj = new BigDecimal("0");
        BigDecimal thzj = new BigDecimal("0");
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
        ExcelData data = new ExcelData();
        data.setName("销售退货表");
        List<String> titles1 = new ArrayList();
        titles1.add("订单编号");
        titles1.add("商品名");
        titles1.add("厂家");
        titles1.add("销售数量");
        titles1.add("销售总价");
        titles1.add("销售人");
        titles1.add("销售时间");
        titles1.add("退货数量");
        titles1.add("退货总价");
        titles1.add("退货人");
        titles1.add("退货时间");
        data.setTitles(titles1);
        List<List<Object>> rows = new ArrayList();
        List<SellAndBack> list = sellAndBackService.findAllSellAndBack(pname,cname,starttime,overtime);
        BigDecimal price = new BigDecimal("0");
        for(SellAndBack sellAndBack:list) {
            List<OkBack> list1 = sellAndBack.getBacklist();
            List<Object> row = new ArrayList();
            row.add(sellAndBack.getOrdercode());
            row.add(sellAndBack.getPname());
            row.add(sellAndBack.getCname());
            row.add(sellAndBack.getOksell());
            xshj = xshj+sellAndBack.getOksell();
            row.add(sellAndBack.getOverprice());
            xszj = xszj.add(sellAndBack.getOverprice());
            row.add(sellAndBack.getSelluser());
            row.add(DateUtil.formatNormalDateString(sellAndBack.getSelltime()));
            if(list1.size()>0){
            for(int i=0;i<1;i++){
                row.add(list1.get(i).getBacknum());
                thhi = thhi+list1.get(i).getBacknum();
            }}else {
                row.add("");
            }
            if(list1.size()>0){
            for(int i=0;i<1;i++){
                row.add(list1.get(i).getBackprice());
                thzj = thzj.add(list1.get(i).getBackprice());
            }}else {
                row.add("");
            }
            if(list1.size()>0){
            for(int i=0;i<1;i++){
                row.add(list1.get(i).getBackuser());
            }}else {
                row.add("");
            }
            if(list1.size()>0){
            for(int i=0;i<1;i++){
                row.add(DateUtil.formatNormalDateString(list1.get(i).getBacktime()));
            }}else {
                row.add("");
            }
            rows.add(row);
            if(list1.size()>1){
            for(int i=1;i<list1.size();i++){
                List<Object> row1= new ArrayList();
                row1.add("");
                row1.add("");
                row1.add("");
                row1.add("");
                row1.add("");
                row1.add("");
                row1.add("");
                row1.add(list1.get(i).getBacknum());
                thhi = thhi+list1.get(i).getBacknum();
                row1.add(list1.get(i).getBackprice());
                thzj = thzj.add(list1.get(i).getBackprice());
                row1.add(list1.get(i).getBackuser());
                row1.add(DateUtil.formatNormalDateString(list1.get(i).getBacktime()));
                rows.add(row1);
            }}
        }
        List<Object> row2 = new ArrayList<>();
        row2.add("销售合计：");
        row2.add("销售数量：");
        row2.add(xshj);
        row2.add("销售总价：");
        row2.add(xszj);
        List<Object> row3 = new ArrayList<>();
        row3.add("退货合计：");
        row3.add("退货数量：");
        row3.add(thhi);
        row3.add("退货总价：");
        row3.add(thzj);
        List<Object> row4 = new ArrayList<>();
        row4.add("总合计：");
        row4.add("销售数量：");
        row4.add(xshj-thhi);
        row4.add("销售总价：");
        row4.add(xszj.subtract(thzj));
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);

        data.setRows(rows);
        SimpleDateFormat fdate = new SimpleDateFormat("MMddHHmmss");
        String fileName = "销售退货表"+fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }





}
