package com.cwll.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cwll on 2018/1/26.
 */
public class Check implements Serializable {
    private int id;
    private Date starttime;
    private Date endtime;
    private int gowork_state;
    private int upwork_state;
    private Employee employeeid;

    public Check() {
    }

    public Check(int id, Date starttime, Date endtime, int gowork_state, int upwork_state, Employee employeeid) {
        this.id = id;
        this.starttime = starttime;
        this.endtime = endtime;
        this.gowork_state = gowork_state;
        this.upwork_state = upwork_state;
        this.employeeid = employeeid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getGowork_state() {
        return gowork_state;
    }

    public void setGowork_state(int gowork_state) {
        this.gowork_state = gowork_state;
    }

    public int getUpwork_state() {
        return upwork_state;
    }

    public void setUpwork_state(int upwork_state) {
        this.upwork_state = upwork_state;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Check checkon = (Check) o;

        if (id != checkon.id) return false;
        if (gowork_state != checkon.gowork_state) return false;
        if (upwork_state != checkon.upwork_state) return false;
        if (employeeid != checkon.employeeid) return false;
        if (starttime != null ? !starttime.equals(checkon.starttime) : checkon.starttime != null) return false;
        return endtime != null ? endtime.equals(checkon.endtime) : checkon.endtime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + gowork_state;
        result = 31 * result + upwork_state;
        result = 31 * result + employeeid.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Checkon{" +
                "id=" + id +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", gowork_state=" + gowork_state +
                ", upwork_state=" + upwork_state +
                ", employeeid=" + employeeid +
                '}';
    }
}

