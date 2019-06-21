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

   @RequestMapping("findAllSellAndBack")
   @ResponseBody
   public List<SellAndBack> findAllSellAndBack(){
       return sellAndBackService.findAllSellAndBack();
   }

}
