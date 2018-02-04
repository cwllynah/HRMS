package com.cwll.controller;


import com.cwll.model.Employee;
import com.cwll.model.User;
import com.cwll.service.EmployeeService;
import com.cwll.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cwll on 2018/1/29.
 */
@Controller
//@Component(value = "userController")
//@SessionAttributes(value = {"user"}, types = {User.class})
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private EmployeeService employeeService;
    //    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(new UserValidator());
//    }
    @RequestMapping(value = "/nameExit",method = RequestMethod.POST)
    public void nameExit(String  name, HttpServletResponse response){
//        System.out.println(name);
        try {
            if(userService.nameExit(name)){
                response.getWriter().println("OK");
            }else {
                response.getWriter().println("NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerUser( User user, ModelMap modelMap, BindingResult br){


        boolean b = userService.register(user);
        if (b){
            modelMap.addAttribute("info","register ok");
            return "index";
        }else {
            modelMap.addAttribute("info","register filed");
            return "pages/tourist/register";
        }


    }
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String loginUser(User user1, ModelMap model,HttpSession session){
        User user = userService.login(user1);
        if (user!=null) {
            session.setAttribute("user",user);
//            model.put("user",user);
            if(user.getIdentity()==0)
                return "pages/tourist/touristIndex";
            else if (user.getIdentity()==1) {
                Employee employee=employeeService.getEmployeeByUser(user);
//                System.out.println(employee);
                if (employee==null||employee.getUserid().getIdentity()<1){
                    model.addAttribute("info","loginFiled");
                    return "index";
                }
                session.setAttribute("employee",employee);
                return "pages/employee/employeeIndex";
            }
            else if (user.getIdentity()==3)
                return "pages/admin/adminIndex";
            else{
                model.addAttribute("info","Identified Exception");
                return "index";
            }
        }else {
            model.addAttribute("info","loginFiled");
            return "index";
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("employee");
        session.removeAttribute("admin");
//        session.setAttribute("user",null);
//        session.setAttribute("employee",null);
//        session.setAttribute("admin",null);

        return "index";
    }

}
