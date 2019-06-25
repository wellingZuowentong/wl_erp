package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.GongGao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/25
 */
@Mapper
public interface GongGaoMapper {
    public int insertGG(GongGao gongGao);
    public List<GongGao> findAllGongGao();
    public GongGao findGongGaoById(Integer id);
    public int delGongGaoById(Integer id);
}
