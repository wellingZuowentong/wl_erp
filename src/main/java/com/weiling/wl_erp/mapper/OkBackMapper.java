package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.Back;
import com.weiling.wl_erp.bean.OkBack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/21
 */
@Mapper
public interface OkBackMapper {
    public int insertOkBack(OkBack okBack);
    public int deleteOkBack(Integer id);
    public int updateOkBack(OkBack okBack);
    public List<OkBack> getAllOkBack(@Param("pname") String pname, @Param("cname") String cname, @Param("starttime") Date starttime, @Param("overtime") Date overtime);
    public List<OkBack> findOkBackByPnameCname(@Param("pname") String pname, @Param("cname") String cname);
    public int updateOkBackName(@Param("pname") String pname, @Param("cname") String cname, @Param("odpname") String odpname, @Param("odcname") String odcname);
    public OkBack findOkBackById(Integer id);
}
