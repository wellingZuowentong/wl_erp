package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.RuKu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 入库基本信息
 */
@Mapper
public interface RuKuMapper {
    public int insertRuKu(RuKu ruKu);
    public List<RuKu> findAllRuKu();
    public KuCun findRuKuById(Integer id);
    public int updateRuKuById(RuKu ruKu);
    public List<RuKu> findRuKuByName(@Param("pname") String pname, @Param("cname") String cname);
    public int deleteRuKuById(Integer id);


}
