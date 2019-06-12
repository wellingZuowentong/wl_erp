package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.RuKu;
import com.weiling.wl_erp.mapper.KuCunMapper;
import com.weiling.wl_erp.mapper.RuKuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 入库相关信息
 */
@Service
public class RuKuService {
    @Autowired
    private RuKuMapper ruKuMapper;

    public int insertRuKu(RuKu ruKu){
        return ruKuMapper.insertRuKu(ruKu);
    }

    public List<RuKu> findAllRuKu(){
        return ruKuMapper.findAllRuKu();
    }

    public KuCun findRuKuById(Integer id){
        return ruKuMapper.findRuKuById(id);
    }

    public int updateRuKuById(RuKu ruKu){
        return ruKuMapper.updateRuKuById(ruKu);
    }

    public List<RuKu> findRuKuByName(String pname,String cname){
        return ruKuMapper.findRuKuByName(pname,cname);
    }

    public int deleteRuKuById(Integer id){
        return ruKuMapper.deleteRuKuById(id);
    }





























}
