package com.cwll.service.impl;

import com.cwll.dao.EmployeeMapper;
import com.cwll.dao.ResumeMapper;
import com.cwll.model.Employee;
import com.cwll.model.Resume;
import com.cwll.model.User;
import com.cwll.service.EmployeeService;
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
@Component
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private UserService userService;
    @Resource
    private ResumeMapper resumeMapper;
    @Override
    public boolean addEmployee(Resume resume) {
//        用户身份提升为员工
        boolean c= userService.identityEmployee(resume.getUserid());

//       员工简历状态修改
        resume.setState(5);
        resumeMapper.updateResumeStateById(resume);

//        员工表插入一条记录：状态和时间由resume携带
        resume.setState(0);
        resume.setCreatetime(new Date());
        employeeMapper.addEmployee(resume);
        return true;
    }

    @Override
    public List<Employee> showEmployee() {
        return employeeMapper.showEmployee();
    }

    @Override
    public boolean deleteEmployeeById(int employeeId) {
        Employee employee=new Employee();
        employee.setId(employeeId);
        employee.setState(-1);
        employeeMapper.updateEmployeeStateById(employee);
        return true;
    }

    @Override
    public Employee showEmployeeById(int employeeId) {
        return employeeMapper.showEmployeeById(employeeId) ;
    }

    @Override
    public boolean changeEmployeePostById(Employee employee) {
        employeeMapper.updateEmployeePostById(employee);
        return true;
    }

    @Override
    public List<Employee> listEmployeeByDeptId(int deptId) {
        return employeeMapper. listEmployeeByDeptId(deptId);
    }

    @Override
    public List<Employee> showEmployeeNoTrain() {

        return employeeMapper.showEmployee();
    }

    @Override
    public boolean arrangeTrain(Employee employee) {
        boolean b= employeeMapper.arrangeTrain(employee);
        return true;
    }

    @Override
    public Employee getEmployeeByUser(User user) {
        return employeeMapper.findEmployeeByUser(user);
    }

    @Override
    public List<Employee> showEmployeeByTrainId(int trainId) {
        return employeeMapper.showEmployeeByTrainId(trainId) ;
    }

    @Override
    public boolean cancelTrain(int employeeId) {
        employeeMapper.cancelTrain(employeeId);
        return true;
    }

}

