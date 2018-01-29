package com.cwll.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cwll on 2018/1/26.
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
    private String sex;
    private int age;
    private String phone;
    private String email;
    private int identity;
    private Date createtime;
    public User() {
    }

    public User(int id, String name, String password, String sex, int age, String phone, String email, int identity, Date createtime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.identity = identity;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", identity=" + identity +
                ", createtime=" + createtime +
                '}';
    }
}
