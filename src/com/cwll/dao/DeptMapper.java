package com.cwll.dao;

import com.cwll.model.Dept;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface DeptMapper {
    List<Dept> listDepts();

    void addDept(Dept dept);

    void deleteDeptById(int deptId);

    Dept selectDeptById(int deptId);

    void updateDeptById(Dept dept);
}
