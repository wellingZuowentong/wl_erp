package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.ChuKu;
import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.mapper.ChuKuMapper;
import com.weiling.wl_erp.mapper.KuCunMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 出库相关信息
 */
@Service
public class ChuKuService {
    @Autowired
    private ChuKuMapper chuKuMapper;

    public int insertChuKu(ChuKu chuKu){
        return chuKuMapper.insertChuKu(chuKu);
    }
   public List<ChuKu> findAllChuKu(String pname, String cname, Date starttime, Date overtime){
        return chuKuMapper.findAllChuKu(pname,cname,starttime,overtime);
    }
    public KuCun findChuKuById(Integer id){
        return chuKuMapper.findChuKuById(id);
    }
    public int updateChuKuById(ChuKu chuKu){
        return chuKuMapper.updateChuKuById(chuKu);
    }
    public KuCun findChuKuByName(String pname,String cname){
        return chuKuMapper.findChuKuByName(pname,cname);
    }
    public int deleteChuKuById(Integer id){
        return chuKuMapper.deleteChuKuById(id);
    }






























}
