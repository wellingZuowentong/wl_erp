package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.mapper.KuCunMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 库存相关信息
 */
@Service
public class KuCunService {
    @Autowired
    private KuCunMapper kuCunMapper;

    public int insertKuCun(KuCun kuCun){
        return kuCunMapper.insertKuCun(kuCun);
    }

    public List<KuCun> findAllKuCun(String pname,String cname){
        return kuCunMapper.findAllKuCun(pname,cname);
    }

    public KuCun findKuCunById(Integer id){
        return kuCunMapper.findKuCunById(id);
    }

    public int updateKuCunById(KuCun KuCun){
        return kuCunMapper.updateKuCunById(KuCun);

    }

    public KuCun findKuCunByName(String pname,String cname,String guige){
        return kuCunMapper.findKuCunByName(pname,cname,guige);
    }

    public int deleteKuCunById(Integer id){
        return kuCunMapper.deleteKuCunById(id);
    }






























}
