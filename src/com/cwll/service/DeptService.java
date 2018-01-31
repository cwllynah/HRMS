package com.cwll.service;

import com.cwll.model.Dept;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface DeptService {
    List<Dept> listDepts();

    boolean addDept(Dept dept);

    boolean deleteDeptById(int deptId);

    Dept selectDeptById(int deptId);

    boolean updateDeptById(Dept dept);
}
