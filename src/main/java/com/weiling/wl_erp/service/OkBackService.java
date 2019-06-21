package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.Back;
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
    private BackService backService;


    public int insertBack(Back back){
        return backService.insertBack(back);
    }

    public int deleteBack(Integer id){
        return backService.deleteBack(id);
    }

    public int updateBack(Back back){
        return backService.updateBack(back);
    }

    public List<Back> getAllBack(String pname,String cname,Date starttime,Date overtime){
        return backService.getAllBack(pname,cname,starttime,overtime);
    }

    public Back findBackByPnameCname(String pname,String cname){

        return backService.findBackByPnameCname(pname,cname);
    }

    public int updateBackName(@Param("pname")String pname, @Param("cname")String cname,@Param("odpname")String odpname, @Param("odcname")String odcname){
        return backService.updateBackName(pname,cname,odpname,odcname);
    }

    public Back findBackById(Integer id){
        return backService.findBackById(id);
    }
}
