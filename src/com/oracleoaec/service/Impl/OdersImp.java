package com.oracleoaec.service.Impl;

import com.oracleoaec.dao.DaoFactory;
import com.oracleoaec.entity.Oders;
import com.oracleoaec.entity.OrdersItem;
import com.oracleoaec.service.IOders;

import java.util.List;

/**
 * Created by Administrator on 2016/3/4.
 */
public class OdersImp implements IOders
{

    @Override
    public int saveOders(Oders oders)
    {
        return DaoFactory.getInstance("OderDao").save(oders);
    }

    @Override
    public int saveOders_item(OrdersItem ordersItem) {
        return DaoFactory.getInstance("OderitemDao").save(ordersItem);
    }

    @Override
    public List<Oders> findAllOders() {
        return DaoFactory.getInstance("OderDao").findAll();
    }
}
