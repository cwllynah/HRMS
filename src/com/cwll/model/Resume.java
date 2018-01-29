package com.cwll.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by cwll on 2018/1/26.
 */
public class Resume implements Serializable {
    private int id;
    private Post job;
    private String experience;//经历
    private String education;//学历
    private String school;//学校
    private String content;//内容
    private String specialty;//专业
    private int state;//
    // 0:未投递 1：投递未邀请面试 2：邀请面试未确认 3：确认面试未参加 4：参见面试未录用 5：入职转员工
    private User userid;//个人信息
    private Recruit recruitid;//招聘信息
    private String interview;//面试
    private Date createtime;//时间

    public Resume() {
    }

    public Resume(int id, Post job, String experience, String education, String school, String content, String specialty, int state, User userid, Recruit recruitid, String interview, Timestamp createtime) {
        this.id = id;
        this.job = job;
        this.experience = experience;
        this.education = education;
        this.school = school;
        this.content = content;
        this.specialty = specialty;
        this.state = state;
        this.userid = userid;
        this.recruitid = recruitid;
        this.interview = interview;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getJob() {
        return job;
    }

    public void setJob(Post job) {
        this.job = job;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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

    public Recruit getRecruitid() {
        return recruitid;
    }

    public void setRecruitid(Recruit recruitid) {
        this.recruitid = recruitid;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (id != resume.id) return false;
        if (state != resume.state) return false;
        if (job != null ? !job.equals(resume.job) : resume.job != null) return false;
        if (experience != null ? !experience.equals(resume.experience) : resume.experience != null) return false;
        if (education != null ? !education.equals(resume.education) : resume.education != null) return false;
        if (school != null ? !school.equals(resume.school) : resume.school != null) return false;
        if (content != null ? !content.equals(resume.content) : resume.content != null) return false;
        if (specialty != null ? !specialty.equals(resume.specialty) : resume.specialty != null) return false;
        if (userid != null ? !userid.equals(resume.userid) : resume.userid != null) return false;
        if (recruitid != null ? !recruitid.equals(resume.recruitid) : resume.recruitid != null) return false;
        if (interview != null ? !interview.equals(resume.interview) : resume.interview != null) return false;
        return createtime != null ? createtime.equals(resume.createtime) : resume.createtime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (recruitid != null ? recruitid.hashCode() : 0);
        result = 31 * result + (interview != null ? interview.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }




    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", job='" + job + '\'' +
                ", experience='" + experience + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", content='" + content + '\'' +
                ", specialty='" + specialty + '\'' +
                ", state=" + state +
                ", userid=" + userid +
                ", recruitid=" + recruitid +
                ", interview='" + interview + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
