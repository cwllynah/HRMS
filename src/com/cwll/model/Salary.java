package com.cwll.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cwll on 2018/1/26.
 */
public class Salary implements Serializable {
    private int sid;
    private double basic;
    private double bonus;
    private double social;
    private double reward;
    private double punish;
    private double totalsal;
    private Date starttime;
    private Date accounttime;
    private Employee employeeid;

    public Salary() {
    }

    public Salary(int sid, double basic, double bonus, double social, double reward, double punish, double totalsal, Date starttime, Date accounttime, Employee employeeid) {
        this.sid = sid;
        this.basic = basic;
        this.bonus = bonus;
        this.social = social;
        this.reward = reward;
        this.punish = punish;
        this.totalsal = totalsal;
        this.starttime = starttime;
        this.accounttime = accounttime;
        this.employeeid = employeeid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSocial() {
        return social;
    }

    public void setSocial(double social) {
        this.social = social;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getPunish() {
        return punish;
    }

    public void setPunish(double punish) {
        this.punish = punish;
    }

    public double getTotalsal() {
        return totalsal;
    }

    public void setTotalsal(double totalsal) {
        this.totalsal = totalsal;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getAccounttime() {
        return accounttime;
    }

    public void setAccounttime(Date accounttime) {
        this.accounttime = accounttime;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "sid=" + sid +
                ", basic=" + basic +
                ", bonus=" + bonus +
                ", social=" + social +
                ", reward=" + reward +
                ", punish=" + punish +
                ", totalsal=" + totalsal +
                ", starttime=" + starttime +
                ", accounttime=" + accounttime +
                ", employeeid=" + employeeid +
                '}';
    }
}
