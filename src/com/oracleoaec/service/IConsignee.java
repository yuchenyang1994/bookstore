package com.oracleoaec.service;

import com.oracleoaec.entity.Consigness;

import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
public interface IConsignee
{
    public int saveConsignees(Consigness consigness);
    public List<Consigness> findConsigneesByid(int id);
    public int deleteConsignees(int id);
    public Consigness findconnByid(int id);
}
