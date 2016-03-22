package com.oracleoaec.entity;


import java.sql.Date;

/**
 * Created by Administrator on 2016/3/4.
 */
public class Oders
{
    int id;
    int consigneeId;
    Date shopped_date;
    String status;
    String description;

    public Oders(int id, int consigneeId, Date date, String status, String description) {
    }

    public Oders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(int consigneeId) {
        this.consigneeId = consigneeId;
    }

    public Date getShopped_date() {
        return shopped_date;
    }

    public void setShopped_date(Date shopped_date) {
        this.shopped_date = shopped_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Oders{" +
                "id=" + id +
                ", consigneeId=" + consigneeId +
                ", shopped_date=" + shopped_date +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
