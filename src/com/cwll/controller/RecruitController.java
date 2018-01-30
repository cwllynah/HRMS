package com.cwll.controller;

import com.cwll.model.Post;
import com.cwll.model.Recruit;
import com.cwll.model.Resume;
import com.cwll.model.User;
import com.cwll.service.RecruitService;
import com.cwll.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by cwll on 2018/1/29.
 */
@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;
    @Resource
    public ResumeService resumeService;
    //    游客浏览招聘
    @RequestMapping(value = "/recruit",method = RequestMethod.GET)
    public String showRecruit(ModelMap model, HttpSession session){
//        浏览管理员发布的招聘
        List<Recruit> recruits = recruitService.showRecruits();
        User user = (User) session.getAttribute("user");
        if (user==null) return "index";
        session.setAttribute("recruits",recruits);

//        查询游客未投递的简历信息
        List<Resume> resumes=resumeService.selectResume(0,user.getId());
        model.addAttribute("resumes",resumes);

        return "pages/tourist/recruit";
    }
    //    管理员添加一条招聘信息
    @RequestMapping(value = "/punishRecruit",method = RequestMethod.POST)
    public String punishRecruit(Recruit recruit, Post post, ModelMap modelMap){

        recruit.setPostid(post);
//        System.out.println("发布招聘："+recruit);
        boolean b=recruitService.punishRecruit(recruit);
        if (b){
            modelMap.put("info","发布招聘成功");
        }else {
            modelMap.put("info","发布招聘失败");
        }
        return "pages/admin/publishRecruit";
    }

    //    管理员查看招聘信息
    @RequestMapping("adminRecruit")
    public String adminShowRecruit(HttpSession session){
        List<Recruit> recruits = recruitService.showRecruits();
        session.setAttribute("recruits",recruits);
        return "pages/admin/adminRecruits";
    }
}

