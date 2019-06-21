package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.Back;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/21
 */
@Mapper
public interface BackMapper {
    public int insertBack(Back back);
    public int deleteBack(Integer id);
    public int updateBack(Back back);
    public List<Back> getAllBack(@Param("pname")String pname, @Param("cname")String cname, @Param("starttime") Date starttime, @Param("overtime")Date overtime);
    public List<Back> findBackByPnameCname(@Param("pname")String pname, @Param("cname")String cname);
    public int updateBackName(@Param("pname")String pname, @Param("cname")String cname,@Param("odpname")String odpname, @Param("odcname")String odcname);
    public Back findBackById(Integer id);
}
