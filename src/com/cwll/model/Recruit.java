package com.cwll.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cwll on 2018/1/26.
 */
public class Recruit implements Serializable {
    private int id;
    private String address;
    private Post postid;
    private String name;
    private Employee interviewer;
    private Date granttime;
    private String description;
    private int state;
    private Date createtime;

    public Recruit() {
    }

    public Recruit(int id, String address, Post postid, String name, Employee interviewer, Date granttime, String description, int state, Date createtime) {
        this.id = id;
        this.address = address;
        this.postid = postid;
        this.name = name;
        this.interviewer = interviewer;
        this.granttime = granttime;
        this.description = description;
        this.state = state;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Post getPostid() {
        return postid;
    }

    public void setPostid(Post postid) {
        this.postid = postid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGranttime() {
        return granttime;
    }

    public void setGranttime(Date granttime) {
        this.granttime = granttime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Employee getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Employee interviewer) {
        this.interviewer = interviewer;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", postid=" + postid +
                ", name='" + name + '\'' +
                ", interviewer=" + interviewer +
                ", granttime=" + granttime +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
