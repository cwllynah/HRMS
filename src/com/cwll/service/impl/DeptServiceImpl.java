package com.cwll.service.impl;

import com.cwll.dao.DeptMapper;
import com.cwll.model.Dept;
import com.cwll.service.DeptService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
@Transactional
@Component
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;
    @Override
    public List<Dept> listDepts() {
        return deptMapper.listDepts();
    }

    @Override
    public boolean addDept(Dept dept) {
        deptMapper.addDept(dept);
        return true;
    }

    @Override
    public boolean deleteDeptById(int deptId) {
        deptMapper.deleteDeptById(deptId);
        return true;
    }

    @Override
    public Dept selectDeptById(int deptId) {

        return deptMapper.selectDeptById(deptId);
    }

    @Override
    public boolean updateDeptById(Dept dept) {
        deptMapper.updateDeptById(dept);
        return true;
    }
}
