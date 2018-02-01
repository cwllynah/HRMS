package com.cwll.service;

import com.cwll.model.Employee;
import com.cwll.model.Resume;
import com.cwll.model.User;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface EmployeeService {
    boolean addEmployee(Resume resume);

    List<Employee> showEmployee();

    boolean deleteEmployeeById(int employeeId);

    Employee showEmployeeById(int employeeId);

    boolean changeEmployeePostById(Employee employee);

    List<Employee> listEmployeeByDeptId(int deptId);

    List<Employee> showEmployeeNoTrain();

    boolean arrangeTrain(Employee employee);

    Employee getEmployeeByUser(User user);



    List<Employee> showEmployeeByTrainId(int trainId);

    boolean cancelTrain(int employeeId);
}
