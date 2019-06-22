package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.Back;
import com.weiling.wl_erp.bean.SellAndBack;
import com.weiling.wl_erp.mapper.BackMapper;
import com.weiling.wl_erp.mapper.SellAndBackMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/21
 */
@Service
public class SellAndBackService {
    @Autowired
    private SellAndBackMapper sellAndBackMapper;

    public List<SellAndBack> findAllSellAndBack(String pname,String cname,Date starttime,Date overtime){
        return sellAndBackMapper.findAllSellAndBack(pname,cname,starttime,overtime);
    }

}
