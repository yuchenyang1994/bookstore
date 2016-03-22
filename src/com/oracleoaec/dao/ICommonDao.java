package com.oracleoaec.dao;

import com.oracleoaec.entity.Consigness;
import com.oracleoaec.entity.accounts;

import java.util.List;


/**
 * Created by Administrator on 2016/2/29.
 */
public interface ICommonDao<T>
{
    public int save(T obj);//添加数据
    public int delete(int id);//根据id删除
    public int delete(T obj);//根据对象来删除
    public int update(T obj);//修改对象
    public List<T> findAll();//查询查询所有对象
    public T findById(int id);//根据id进行查询
    public T findByName(String name);//根据对象来查询
    public T findByObject(T obj);//根据对象来查询
    public List<T> findObjectById(int id);//根据id来进行查询
    public T findByNameAndPassowrd(String name,String password);

}
