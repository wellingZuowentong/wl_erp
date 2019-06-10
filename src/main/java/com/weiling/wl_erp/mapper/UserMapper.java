package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/10
 */
@Mapper
public interface UserMapper {
    public List<User> findAllUser();
}
