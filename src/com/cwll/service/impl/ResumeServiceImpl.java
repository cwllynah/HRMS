package com.cwll.service.impl;

import com.cwll.dao.ResumeMapper;
import com.cwll.model.Recruit;
import com.cwll.model.Resume;
import com.cwll.model.User;
import com.cwll.service.ResumeService;
import com.cwll.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
@Transactional
@Component(value = "resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;
    @Resource
    private UserService userService;

    @Override
    public List<Resume> showResumes(int userId) {
        return resumeMapper.findResumes(userId);
    }

    @Override
    public boolean addResume(Resume resume) {
        boolean b=userService.updateById(resume.getUserid());
        resume.setCreatetime(new Date());
//        System.out.println("service*********************");
//        System.out.println(resume);
        return resumeMapper.addResume(resume);
    }

    @Override
    public List<Resume> resumeByRecruitId(int recruitId) {
        return resumeMapper.findResumeByRecruitId(recruitId);
    }

    //    查询指定用户指定状态的简历
    @Override
    public List<Resume> selectResume (int state, int userId) {
        Resume resume=new Resume();
        resume.setState(state);
        User user=new User();
        user.setId(userId);
        resume.setUserid(user);
        return resumeMapper. selectResume(resume) ;
    }

    //    绑定招聘信息到简历表：投简历
    @Override
    public boolean addRecruitToResume(int recruitId, int resumeId) {
        Resume resume=new Resume();
        resume.setId(resumeId);
        Recruit recruit=new Recruit();
       /* recruit.setId(recruitId);*/
        resume.setRecruitid(recruit);

        resumeMapper.addRecruitToResume(resume);
        resume.setState(1);
        resumeMapper.updateResumeStateById(resume);
        return true;
    }

    //    管理员邀请面试：简历状态更新到3，
    @Override
    public boolean Invitation(int resumeId) {
        Resume resume=new Resume();
        resume.setId(resumeId);
        resume.setState(2);
        resumeMapper.updateResumeStateById(resume);
        return true;
    }

    @Override
    public List<Resume> showDeliveryResumes(int userId) {
        return resumeMapper.finDeliverydResumes(userId);
    }

    @Override
    public boolean sureInterview(int resumeId) {
        Resume resume=new Resume();
        resume.setId(resumeId);
        resume.setState(3);
        resumeMapper.updateResumeStateById(resume);
        return true;
    }

    @Override
    public List<Resume> adminShowInvitationResume() {

        return resumeMapper.adminShowInvitationResume(3);
    }

    @Override
    public boolean cancelEmployment(int resumeId) {
        Resume resume=new Resume();
        resume.setId(resumeId);
        resume.setState(0);
        return resumeMapper.updateResumeStateById(resume);
    }

    @Override
    public Resume getResumeById(int resumeId) {

        return resumeMapper.findResumeById(resumeId);
    }

    @Override
    public boolean updateResume(Resume resume) {
        resumeMapper.updateResume(resume);
        return true;
    }


}
