package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.ShangPin;
import com.weiling.wl_erp.mapper.ShangPinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 商品相关信息
 */
@Service
public class ShangPinService {
    @Autowired
    private ShangPinMapper shangPinMapper;

    public int insertShangPin(ShangPin shangPin){
        return shangPinMapper.insertShangPin(shangPin);
    }

    public List<ShangPin> findAllShangPin(String pname,String cname){

        return shangPinMapper.findAllShangPin(pname,cname);
    }

    public ShangPin findShangPinById(Integer id){
        return shangPinMapper.findShangPinById(id);
    }

    public int updateShangPinById(ShangPin shangPin){
        return shangPinMapper.updateShangPinById(shangPin);

    }

    public ShangPin findShangPinByName(String pname,String cname,String guige){
        return shangPinMapper.findShangPinByName(pname,cname,guige);
    }

    public int deleteShangPinById(Integer id){
        return shangPinMapper.deleteShangPinById(id);
    }






























}
