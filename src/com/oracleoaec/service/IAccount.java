package com.oracleoaec.service;

import com.oracleoaec.entity.accounts;

import java.util.List;

/**
 * Created by Administrator on 2016/2/29.
 */
public interface IAccount{
    public int saveAccount(accounts accounts);
    public Object findAccountByPassword(String name,String password);
    public accounts findAccountByname(String name);
}
