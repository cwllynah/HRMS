package com.cwll.controller;

import com.cwll.model.Post;
import com.cwll.model.Resume;
import com.cwll.model.User;
import com.cwll.service.ResumeService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by cwll on 2018/1/29.
 */
@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @RequestMapping(value = "/addResume.do")
    public String addResume(User user, Resume resume, Post post, ModelMap model, HttpSession session){
//        User user1 = (User) session.getAttribute("user");
//        user.setId(user1.getId());
        resume.setUserid(user);

        resume.setJob(post);
        resumeService.addResume(resume);
        return "forward:resume.do";
    }
    @ResponseBody
    @RequestMapping(value = "/selectResume",method = RequestMethod.POST ,produces="application/json;charset=UTF-8")
    public void selectResume(String state,String userId,HttpServletResponse response){
        List<Resume> resumes=resumeService.selectResume(new Integer(state),new  Integer(userId));
        System.out.println("选择简历的ajax："+resumes.size());
        JSONArray array=JSONArray.fromObject(resumes);
        try {
            response.getWriter().println(array);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
