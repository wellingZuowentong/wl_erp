package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.Product;
import com.weiling.wl_erp.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/11
 */
@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public int insertProduct(Product product){
        return productMapper.insertProduct(product);
    }

    public List<Product> findAllProductByCid(Integer cid){
        return productMapper.findAllProductByCid(cid);
    }

    public List<Product> findAllProduct(){
        return productMapper.findAllProduct();
    }

    public Product findProductById(Integer id){
        return productMapper.findProductById(id);
    }


}
