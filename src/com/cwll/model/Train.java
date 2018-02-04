package com.cwll.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cwll on 2018/1/26.
 */
public class Train implements Serializable { private int tid;
    private Date begintime;
    private Date endtime;
    private String tname;
    private String content;
    private int state;
    private Employee employeeid;

    public Train() {
    }

    public Train(int tid, Date begintime, Date endtime, String tname, String content, int state, Employee employeeid) {
        this.tid = tid;
        this.begintime = begintime;
        this.endtime = endtime;
        this.tname = tname;
        this.content = content;
        this.state = state;
        this.employeeid = employeeid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public String toString() {
        return "Train{" +
                "tid=" + tid +
                ", begintime=" + begintime +
                ", endtime=" + endtime +
                ", tname='" + tname + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", employeeid=" + employeeid +
                '}';
    }
}

