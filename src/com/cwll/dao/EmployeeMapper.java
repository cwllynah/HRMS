package com.cwll.dao;

import com.cwll.model.Employee;
import com.cwll.model.Resume;
import com.cwll.model.User;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface EmployeeMapper {
    void addEmployee(Resume resume);

    List<Employee> showEmployee();

    void updateEmployeeStateById(Employee employee);

    Employee showEmployeeById(int employeeId);

    void updateEmployeePostById(Employee employee);

    List<Employee> listEmployeeByDeptId(int deptId);

    boolean arrangeTrain(Employee employee);

    Employee findEmployeeByUser(User user);



    List<Employee> showEmployeeByTrainId(int trainId);

    void cancelTrain(int employeeId);
}
