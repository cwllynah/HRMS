package com.cwll.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cwll on 2018/1/26.
 */
public class Employee implements Serializable {
    private int id;
    private String no;
    private Post postid;
    private int state;
    private User userid;
    private Train trainid;
    private Date createtime;

    public Employee() {
    }

    public Employee(int id, String no, Post postid, int state, User userid, Train trainid, Date createtime) {
        this.id = id;
        this.no = no;
        this.postid = postid;
        this.state = state;
        this.userid = userid;
        this.trainid = trainid;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Post getPostid() {
        return postid;
    }

    public void setPostid(Post postid) {
        this.postid = postid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Train getTrainid() {
        return trainid;
    }

    public void setTrainid(Train trainid) {
        this.trainid = trainid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", no='" + no + '\'' +
                ", postid=" + postid +
                ", state='" + state + '\'' +
                ", userid=" + userid +
                ", trainid='" + trainid + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}

