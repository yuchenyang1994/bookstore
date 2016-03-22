package com.oracleoaec.dao;

import com.oracleoaec.dao.impl.*;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/2/29.
 */
public class DaoFactory {
    private static HashMap<String, ICommonDao> map = new HashMap<String, ICommonDao>();

    public static ICommonDao getInstance(String name) {
        ICommonDao dao = null;
        if (name.equals("accountDao")) {
            if (map.get(name) == null) {
                dao = new accountDaoImp();
                map.put(name, dao);
            } else {
                dao = map.get("accountDao");
            }
        } else if (name.equals("bookDao")) {
            if (map.get(name) == null) {
                dao = new BookDaoImp();
                map.put(name, dao);
            } else {
                dao = map.get("bookDao");
            }
        } else if (name.equals("bookChapterDao")) {
            if (map.get(name) == null) {
                dao = new BookChapter_id();
                map.put(name, dao);
            } else {
                dao = map.get("ConsigneesDaoImp");
            }
        } else if (name.equals("ConsigneesDaoImp")) {
            if (map.get(name) == null) {
                dao = new ConsignessDaoImp();
                map.put(name, dao);
            } else {
                dao = map.get("ConsigneesDaoImp");
            }
        } else if (name.equals("OderDao")) {
            if (map.get(name) == null) {
                dao = new OdersDao();
                map.put(name, dao);
            } else {
                dao = map.get("OderDao");
            }

        } else if (name.equals("OderitemDao")) {
            if (map.get(name) == null) {
                dao = new OrdersItemDao();
                map.put(name, dao);
            } else {
                dao = map.get("OderitemDao");
            }
        }
        return dao;
    }
}