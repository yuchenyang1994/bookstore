package com.oracleoaec.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/2/29.
 */
public class accounts implements Serializable
{
    private int id;
    private String account;
    private String password;
    private String mail;

    public accounts() {
    }

    public accounts(int id, String account, String password, String mail) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "accounts{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

}
