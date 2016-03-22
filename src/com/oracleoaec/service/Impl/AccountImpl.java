package com.oracleoaec.service.Impl;

import com.oracleoaec.dao.DaoFactory;
import com.oracleoaec.entity.accounts;
import com.oracleoaec.service.IAccount;

import java.util.List;

/**
 * Created by Administrator on 2016/2/29.
 */
public class AccountImpl implements IAccount
{
    @Override
    public int saveAccount(accounts accounts) {
        int i = DaoFactory.getInstance("accountDao").save(accounts);
        return i;
    }

    @Override
    public accounts findAccountByPassword(String name, String password) {
        return  (accounts) DaoFactory.getInstance("accountDao").findByNameAndPassowrd(name,password);
    }


    @Override
    public accounts findAccountByname(String name) {
        return (accounts) DaoFactory.getInstance("accountDao").findByName(name);
    }

}
