package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.Product;
import com.weiling.wl_erp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/11
 * 商品类
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

/**
*作者：王怀朋
*参数：
*功能：添加商品
*/
    @RequestMapping("/insertProduct")
    @ResponseBody
    public int insertProduct(HttpServletRequest request){
        String pname = request.getParameter("pname");
        String price = request.getParameter("inprice");
        BigDecimal inprice = new BigDecimal(request.getParameter("inprice"));
        String scid = request.getParameter("scid");
        Integer cid = null;
        if(scid!=null&&!scid.equals("")){
            cid = Integer.parseInt(scid);
        }
        Product product = new Product();
        product.setPname(pname);
        product.setInprice(inprice);
        product.setCid(cid);
        return productService.insertProduct(product);
    }

   /* @RequestMapping("/findAllProductByCid")
    @ResponseBody
    public List<Product> findAllProductByCid(HttpServletRequest request){
        String scid = request.getParameter("cid");
        Integer cid =
    }*/


















}
