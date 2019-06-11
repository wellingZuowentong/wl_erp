package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/11
 */
@Mapper
public interface ProductMapper {
    public int insertProduct(Product product);
    public List<Product> findAllProductByCid(Integer cid);
    public List<Product> findAllProduct();
    public Product findProductById(Integer id);
}
