package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.Back;
import com.weiling.wl_erp.mapper.BackMapper;
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
public class BackService {
    @Autowired
    private BackMapper backMapper;


    public int insertBack(Back back){
        return backMapper.insertBack(back);
    }

    public int deleteBack(Integer id){
        return backMapper.deleteBack(id);
    }

    public int updateBack(Back back){
        return backMapper.updateBack(back);
    }

    public List<Back> getAllBack(String pname,String cname,Date starttime,Date overtime){
         return backMapper.getAllBack(pname,cname,starttime,overtime);
    }

    public List<Back> findBackByPnameCname(String pname,String cname,String guige){

        return backMapper.findBackByPnameCname(pname,cname,guige);
    }

    public int updateBackName(@Param("pname")String pname, @Param("cname")String cname,@Param("odpname")String odpname, @Param("odcname")String odcname){
        return backMapper.updateBackName(pname,cname,odpname,odcname);
    }

    public Back findBackById(Integer id){
        return backMapper.findBackById(id);
    }
}
