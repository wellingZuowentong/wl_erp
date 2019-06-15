package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.ShangPin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 库存基本信息
 */
@Mapper
public interface KuCunMapper {
    public int insertKuCun(KuCun kuCun);
    public List<KuCun> findAllKuCun(@Param("pname")String pname, @Param("cname")String cname);
    public KuCun findKuCunById(Integer id);
    public int updateKuCunById(KuCun kuCun);
    public KuCun findKuCunByName(@Param("pname") String pname, @Param("cname") String cname);
    public int deleteKuCunById(Integer id);


}
