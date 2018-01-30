package com.cwll.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cwll on 2018/1/26.
 */
public class RwAndPh implements Serializable {
    private int rpid;
    private double money;
    private Date rptime;
    private String cause;
    private Employee employeeid;

    public RwAndPh() {
    }

    public RwAndPh(int rpid, double money, Date rptime, String cause, Employee employeeid) {
        this.rpid = rpid;
        this.money = money;
        this.rptime = rptime;
        this.cause = cause;
        this.employeeid = employeeid;
    }

    public int getRpid() {
        return rpid;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getRptime() {
        return rptime;
    }

    public void setRptime(Date rptime) {
        this.rptime = rptime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public String toString() {
        return "RwAndPh{" +
                "rpid=" + rpid +
                ", money=" + money +
                ", rptime=" + rptime +
                ", cause='" + cause + '\'' +
                ", employeeid=" + employeeid +
                '}';
    }
}

