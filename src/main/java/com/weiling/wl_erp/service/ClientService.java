package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.Client;
import com.weiling.wl_erp.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/11
 */
@Service
public class ClientService {
    @Autowired
    private ClientMapper clientMapper;

    public int insertClient(Client client){
        return clientMapper.insertClient(client);
    }

    public List<Client> findAllClient(){

        return clientMapper.findAllClient();
    }

    public Client findClientById(Integer id){

        return clientMapper.findClientById(id);
    }
}
