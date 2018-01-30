package com.cwll.service.impl;

import com.cwll.dao.RecruitMapper;
import com.cwll.model.Recruit;
import com.cwll.service.RecruitService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
@Transactional
@Component
public class RecruitServiceImpl  implements RecruitService {
    @Resource
    private RecruitMapper recruitMapper;

    //    浏览招聘信息
    @Override
    public List<Recruit> showRecruits() {
        return recruitMapper.findRecruits();
    }

    //    管理员发布招聘信息
    @Override
    public boolean punishRecruit(Recruit recruit) {
        recruitMapper.addRecruit(recruit);
        return true;
    }
}
