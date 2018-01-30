package com.cwll.service;

import com.cwll.model.Resume;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface ResumeService {
    List<Resume> showResumes(int userId);

    boolean addResume(Resume resume);

    List<Resume> resumeByRecruitId(int recruitId);

    List<Resume> selectResume(int state, int userId);

    boolean addRecruitToResume(int recruitId, int resumeId);

    boolean Invitation(int resumeId);

    List<Resume> showDeliveryResumes(int id);

    boolean sureInterview(int resumeId);

    List<Resume> adminShowInvitationResume();


    boolean cancelEmployment(int resumeId);

    Resume getResumeById(int resumeId);

    boolean updateResume(Resume resume);
}
