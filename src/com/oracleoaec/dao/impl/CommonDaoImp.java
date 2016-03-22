package com.oracleoaec.dao.impl;

import com.oracleoaec.dao.ICommonDao;
import com.oracleoaec.entity.Consigness;
import com.oracleoaec.entity.accounts;

import java.util.List;

/**
 * Created by Administrator on 2016/2/29.
 */
public class CommonDaoImp<T> implements ICommonDao<T> {


    @Override
    public int save(T obj) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(T obj) {
        return 0;
    }

    @Override
    public int update(T obj) {
        return 0;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(int id) {
        return null;
    }

    @Override
    public T findByName(String name) {
        return null;
    }

    @Override
    public T findByObject(T obj) {
        return null;
    }

    @Override
    public List<T> findObjectById(int id) {
        return null;
    }

    @Override
    public T findByNameAndPassowrd(String name, String password) {
        return null;
    }
}
