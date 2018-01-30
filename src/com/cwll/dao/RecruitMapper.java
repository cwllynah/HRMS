package com.cwll.dao;

import com.cwll.model.Recruit;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface RecruitMapper {

    List<Recruit> findRecruits();

    void addRecruit(Recruit recruit);
}
