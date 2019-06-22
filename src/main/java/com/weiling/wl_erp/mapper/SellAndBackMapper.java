package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.Back;
import com.weiling.wl_erp.bean.SellAndBack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/21
 */
@Mapper
public interface SellAndBackMapper {
   public List<SellAndBack> findAllSellAndBack(@Param("pname")String pname, @Param("cname")String cname, @Param("starttime") Date starttime, @Param("overtime")Date overtime);
}
