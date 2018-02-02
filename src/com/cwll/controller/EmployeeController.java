package com.cwll.controller;

import com.cwll.model.Employee;
import com.cwll.model.Post;
import com.cwll.service.EmployeeService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by cwll on 2018/1/29.
 */
@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/employee.Show")
    public String employeeShow(ModelMap modelMap){
        List<Employee> employees= employeeService.showEmployee();
        modelMap.addAttribute("employees",employees);
        return "pages/admin/showEmployees";
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployeeById(int employeeId){
        boolean b= employeeService.deleteEmployeeById(employeeId);
        return "forward:employee.Show";
    }

    @RequestMapping("/changePostShow")
    public String changeEmployeeShowById(int employeeId,ModelMap modelMap){
        Employee employee= employeeService.showEmployeeById(employeeId);
        modelMap.addAttribute("employee",employee);
        return "pages/admin/changePostShow";
    }
    @RequestMapping("/changePost")
    public String changeEmployeeById(Employee employee, Post post){
        employee.setPostid(post);
        boolean b= employeeService.changeEmployeePostById(employee);
        return "forward:employee.Show";
    }
    @RequestMapping("/listEmployeeByDeptId")
    public void listEmployeeByDeptId(int deptId, HttpServletResponse response){
        List<Employee> employees = employeeService.listEmployeeByDeptId(deptId);
        JSONArray array=JSONArray.fromObject(employees);
        System.out.println("Employee:"+array);
        try {
            response.getWriter().println(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

