package com.cwll.service;

import com.cwll.model.Recruit;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface RecruitService {
    List<Recruit> showRecruits();

    boolean punishRecruit(Recruit recruit);
}
