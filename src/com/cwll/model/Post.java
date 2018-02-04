package com.cwll.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by cwll on 2018/1/26.
 */
public class Post implements Serializable {

    private int pid;
    private String pname;
    private Dept deptid;
    private String describe;
    private Date createtime;

    public Post() {
    }

    public Post(int id, String pname, Dept deptid, String describe, Timestamp createtime) {
        this.pid = id;
        this.pname = pname;
        this.deptid = deptid;
        this.describe = describe;
        this.createtime = createtime;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Dept getDeptid() {
        return deptid;
    }

    public void setDeptid(Dept deptid) {
        this.deptid = deptid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", deptid=" + deptid +
                ", describe='" + describe + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}

