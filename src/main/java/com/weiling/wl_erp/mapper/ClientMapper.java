package com.weiling.wl_erp.mapper;

import com.weiling.wl_erp.bean.Client;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/11
 */
@Mapper
public interface ClientMapper {
    public int insertClient(Client client);
    public List<Client> findAllClient();
    public Client findClientById(Integer id);
}
