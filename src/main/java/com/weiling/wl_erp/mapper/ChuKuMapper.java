package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.ChuKu;
import com.weiling.wl_erp.bean.KuCun;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 出库基本信息
 */
@Mapper
public interface ChuKuMapper {
    public int insertChuKu(ChuKu chuKu);
    public List<ChuKu> findAllChuKu(@Param("pname")String pname, @Param("cname")String cname, @Param("starttime") Date starttime, @Param("overtime")Date overtime);
    public ChuKu findChuKuById(Integer id);
    public int updateChuKuById(ChuKu chuKu);
    public ChuKu findChuKuByName(@Param("pname") String pname, @Param("cname") String cname,@Param("guige") String guige);
    public int deleteChuKuById(Integer id);
    public int updateChuKuName(@Param("pname")String pname, @Param("cname")String cname,@Param("odpname")String odpname, @Param("odcname")String odcname);
}
