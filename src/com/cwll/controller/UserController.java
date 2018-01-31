package com.cwll.controller;


import com.cwll.model.User;
import com.cwll.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by cwll on 2018/1/29.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping(value = "register",method = RequestMethod.POST)
    public  String registerUser(User user, ModelMap modelMap, BindingResult bindingResult){
        boolean b = userService.register(user);
        if(b){
            modelMap.addAttribute("info","register ok");
            return "index";
        }else{
            modelMap.addAttribute("info","register filed");
            return "pages/tourist/register";
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginUser(User user1,ModelMap model,HttpSession session){
        User user = userService.login(user1);
        if(null!=user){
            session.setAttribute("user",user);
            if(user.getIdentity()==0){
                return "pages/tourist/touristIndex";
            }else if(user.getIdentity()==1){
                return "index";
            }
        }
        return "index";
    }
}
