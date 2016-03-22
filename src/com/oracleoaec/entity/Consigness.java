package com.oracleoaec.entity;

/**
 * Created by Administrator on 2016/3/3.
 */
public class Consigness
{
    private int id;//收获人id
    private int account_id;//账户id
    private String full_name;//全名
    private String tel;//电话
    private String province;//省
    private String city;//城市
    private String extra;//详细地址
    private accounts accounts;//account对象

    public Consigness() {
    }

    public Consigness(int account_id, String full_name, String tel, String province, String city, String extra) {
        this.account_id = account_id;
        this.full_name = full_name;
        this.tel = tel;
        this.province = province;
        this.city = city;
        this.extra = extra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id ;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(accounts accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Consigness{" +
                "id=" + id +
                ", account_id=" + account_id +
                ", full_name='" + full_name + '\'' +
                ", tel='" + tel + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
