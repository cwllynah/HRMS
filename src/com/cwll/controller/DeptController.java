package com.cwll.controller;

import com.cwll.model.Dept;
import com.cwll.service.DeptService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by cwll on 2018/1/29.
 */
@Controller
public class DeptController {
    @Resource
    private DeptService deptService;
    @RequestMapping(value = "/listDepts" ,method = RequestMethod.POST)
    public void getDepts(HttpServletResponse response){
        List<Dept> depts = deptService.listDepts();
        JSONArray array=JSONArray.fromObject(depts);

        try {
            response.getWriter().println(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/addDept" ,method = RequestMethod.GET)
    public String addDept(Dept dept,ModelMap modelMap ){
        dept.setCreatetime(new Date());
        System.out.println("部门添加"+dept);
        boolean p = deptService.addDept(dept);
        if (p)modelMap.put("info","部门添加成功");
        else modelMap.put("info","部门添加失败");
        return "pages/admin/deptAndPost";
    }

    @RequestMapping(value = "/deleteDeptById",method = RequestMethod.GET)
    public String deleteDeptById( int deptId,ModelMap modelMap){
        boolean b=deptService.deleteDeptById(deptId);
        if (b)
            modelMap.put("info","删除部门成功");
        else
            modelMap.put("info","删除部门失败");
        return "pages/admin/deptAndPost";
    }

    @RequestMapping(value = "/updateShowDeptById",method = RequestMethod.GET)
    public String updateShowDeptById( int deptId,ModelMap modelMap){
        Dept dept=deptService.selectDeptById(deptId);
        if (dept!=null)
            modelMap.put("dept",dept);
        else
            modelMap.put("info","获取部门失败");
        return "pages/admin/updateShowDept";
    }
    @RequestMapping(value = "/updateDeptById",method = RequestMethod.GET)
    public String updateDeptById( Dept dept,ModelMap modelMap){
        boolean b=deptService.updateDeptById(dept);
        if (dept!=null)
            modelMap.put("info","修改部门成功");
        else
            modelMap.put("info","获取部门失败");
        return "pages/admin/deptAndPost";
    }
}

