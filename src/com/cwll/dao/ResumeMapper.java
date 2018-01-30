package com.cwll.dao;

import com.cwll.model.Resume;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface ResumeMapper {

    List<Resume> findResumes(int userId);

    boolean addResume(Resume resume);

    List<Resume> findResumeByRecruitId(int recruitId);

    List<Resume> selectResume(Resume resume);

    void addRecruitToResume(Resume resume);

    List<Resume> finDeliverydResumes(int userId);



    List<Resume> adminShowInvitationResume(int state);

    boolean updateResumeStateById(Resume resume);

    Resume findResumeById(int resumeId);

    void updateResume(Resume resume);
}
