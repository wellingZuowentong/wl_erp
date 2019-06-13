package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.mapper.SellMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/13
 * 销售信息
 */
@Service
public class SellService {
    @Autowired
    private SellMapper sellMapper;

    public int insertSell(Sell sell){
        return sellMapper.insertSell(sell);
    }
    public List<Sell> findAllSell(){
        return sellMapper.findAllSell();
    }
    public Sell findSellById(Integer id){
        return sellMapper.findSellById(id);
    }
    public List<Sell> findByNameAndTime(String pname,String cname,Date starttime,Date overtime){
        return sellMapper.findByNameAndTime(pname,cname,starttime,overtime);
    }
    public int updateZhuangTai(Integer id,Integer zhuangtai){
        return sellMapper.updateZhuangTai(id,zhuangtai);
    }
    public int updateSellById(Sell sell){
        return sellMapper.updateSellById(sell);
    }
}
