package com.oracleoaec.service.Impl;

import com.oracleoaec.dao.DaoFactory;
import com.oracleoaec.entity.Consigness;
import com.oracleoaec.service.IConsignee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
public class ConsigneesImp implements IConsignee
{


    @Override
    public int saveConsignees(Consigness consigness)
    {
        return DaoFactory.getInstance("ConsigneesDaoImp").save(consigness);
    }

    @Override
    public List<Consigness> findConsigneesByid(int id)
    {
        return DaoFactory.getInstance("ConsigneesDaoImp").findObjectById(id);
    }

    @Override
    public int deleteConsignees(int id) {
        return DaoFactory.getInstance("ConsigneesDaoImp").delete(id);
    }

    @Override
    public Consigness findconnByid(int id) {
        return (Consigness) DaoFactory.getInstance("ConsigneesDaoImp").findById(id);
    }
}
