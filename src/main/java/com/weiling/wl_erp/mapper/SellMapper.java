package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.Sell;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/13
 * 销售信息
 */
@Mapper
public interface SellMapper {
    public int insertSell(Sell sell);
    public List<Sell> findAllSell(@Param("pname")String pname, @Param("cname")String cname,@Param("starttime")Date starttime,@Param("overtime")Date overtime);
    public Sell findSellById(Integer id);
    public List<Sell> findSellByName(@Param("pname")String pname, @Param("cname")String cname);
    public int updateZhuangTai(@Param("id")Integer id,@Param("zhuangtai")Integer zhuangtai);
    public int updateSellById(Sell sell);
    public Integer findSellByZhuangtai(@Param("pname")String pname, @Param("cname")String cname);
    public int updateSellName(@Param("pname")String pname, @Param("cname")String cname,@Param("odpname")String odpname, @Param("odcname")String odcname);
}
