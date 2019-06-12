package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.ShangPin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 */
@Mapper
public interface ShangPinMapper {
    public int insertShangPin(ShangPin shangPin);
    public List<ShangPin> findAllShangPin();
    public ShangPin findShangPinById(Integer id);
    public int updateShangPinById(ShangPin shangPin);
    public ShangPin findShangPinByName(@Param("pname")String pname,@Param("cname")String cname);
    public int deleteShangPinById(Integer id);


}
