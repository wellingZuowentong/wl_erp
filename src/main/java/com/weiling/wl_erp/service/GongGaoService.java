package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.GongGao;
import com.weiling.wl_erp.mapper.GongGaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/25
 */
@Service
public class GongGaoService {
    @Autowired
    private GongGaoMapper gongGaoMapper;

    public int insertGG(GongGao gongGao){
        return gongGaoMapper.insertGG(gongGao);
    }
    public List<GongGao> findAllGongGao(){
        return gongGaoMapper.findAllGongGao();
    }
    public GongGao findGongGaoById(Integer id){
        return gongGaoMapper.findGongGaoById(id);
    }
    public int delGongGaoById(Integer id){
        return gongGaoMapper.delGongGaoById(id);
    }
}
