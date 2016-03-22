package com.oracleoaec.service;


import com.oracleoaec.entity.Oders;
import com.oracleoaec.entity.OrdersItem;

import java.util.List;

/**
 * Created by Administrator on 2016/3/4.
 */
public interface IOders
{
    public int saveOders(Oders oders);
    public int saveOders_item(OrdersItem ordersItem);
    public List<Oders> findAllOders();
}
