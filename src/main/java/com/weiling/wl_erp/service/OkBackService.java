package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.Back;
import com.weiling.wl_erp.bean.OkBack;
import com.weiling.wl_erp.mapper.OkBackMapper;
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
public class OkBackService {
    @Autowired
    private OkBackMapper okMapper;


    public int insertOkBack(OkBack okBack){
        return okMapper.insertOkBack(okBack);
    }

    public int deleteOkBack(Integer id){
        return okMapper.deleteOkBack(id);
    }

    public int updateOkBack(OkBack okBack){
        return okMapper.updateOkBack(okBack);
    }

    public List<OkBack> getAllOkBack(String pname,String cname,Date starttime,Date overtime){
        return okMapper.getAllOkBack(pname,cname,starttime,overtime);
    }

    public List<OkBack> findOkBackByPnameCname(String pname,String cname){

        return okMapper.findOkBackByPnameCname(pname,cname);
    }

    public int updateOkBackName(@Param("pname")String pname, @Param("cname")String cname,@Param("odpname")String odpname, @Param("odcname")String odcname){
        return okMapper.updateOkBackName(pname,cname,odpname,odcname);
    }

    public OkBack findOkBackById(Integer id){
        return okMapper.findOkBackById(id);
    }
}
