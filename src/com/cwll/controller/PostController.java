package com.cwll.controller;

import com.cwll.model.Dept;
import com.cwll.model.Post;
import com.cwll.service.PostService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by cwll on 2018/1/29.
 */
@Controller
public class PostController {

    @Resource
    private PostService postService;

    @RequestMapping(value = "/listPostByDeptId",method = RequestMethod.POST)
    public void listPostByDeptId(int deptId, HttpServletResponse response){
        List<Post> posts = postService.listPostByDeptId(deptId);
        JSONArray array=JSONArray.fromObject(posts);
//        System.out.println("post:"+array);
        try {
            response.getWriter().println(array);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/addPost",method = RequestMethod.POST)
    public String addPost(Dept dept, Post post, ModelMap modelMap){
        post.setDeptid(dept);
//        System.out.println(post);
        boolean b=  postService.addPost(post);
        if (b)
            modelMap.put("info","添加岗位成功");
        else
            modelMap.put("info","添加岗位失败");
        return "page/admin/deptAndPost";
    }

    @RequestMapping(value = "/deletePostById",method = RequestMethod.GET)
    public String deletePostById( int postId,ModelMap modelMap){
        boolean b=postService.deletePostById(postId);
        if (b)
            modelMap.put("info","删除岗位成功");
        else
            modelMap.put("info","删除岗位失败");
        return "page/admin/deptAndPost";
    }

    @RequestMapping(value = "/updateShowPostById",method = RequestMethod.GET)
    public String updateShowPostById( int postId,ModelMap modelMap){
        Post post =postService.selectPostById(postId);
        if (post!=null)
            modelMap.put("post",post);
        else
            modelMap.put("info","获取岗位信息失败");
        return "page/admin/updateShowPost";
    }

    @RequestMapping(value = "/updatePostById",method = RequestMethod.GET)
    public String updatePostById( Post post,ModelMap modelMap){
        boolean b =postService.updatePostById(post);
        if (b)
            modelMap.put("info","修改岗位成功");
        else
            modelMap.put("info","修改岗位失败");
        return "page/admin/updateShowPost";
    }
}
