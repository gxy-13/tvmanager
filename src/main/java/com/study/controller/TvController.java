package com.study.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.pojo.Tv;
import com.study.service.impl.TvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/tv")
public class TvController {
    @Autowired
    TvServiceImpl tvServiceImpl;

    /**
     * 分页
     * @author 管鑫逸 2018150353
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/list")
    public String selectAll(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Tv> tvs = tvServiceImpl.allTv();
        for (Tv tv : tvs) {
            System.out.println(tv);
        }
        PageInfo<Tv> pageInfo = new PageInfo<Tv>(tvs);
        model.addAttribute("pageInfo",pageInfo);
//        model.addAttribute("tvs",tvs);
        return "tvs/list";
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "tvs/add";
    }

    /**
     * 添加电视
     * @author 管鑫逸2018150353
     * @param tv
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(Tv tv,
                      Model model){
        System.out.println(tv);
        if(tv==null){
           model.addAttribute("msg","输入内容不能有空");
        }
        tvServiceImpl.add(tv);
//        重定向进主页面
        return "redirect:/tv/list";
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")int id,
                           Model model){
        System.out.println(id);
         Tv tv = tvServiceImpl.selectByPno(id);
         model.addAttribute("tv",tv);
         return "tvs/update";
    }

    /**
     * @author 管鑫逸 2018150353
     * @param tv
     * @return
     */
    @RequestMapping("/update")
    public String update(Tv tv){
        System.out.println(tv);
        int i = tvServiceImpl.update(tv);
        if(i>0){
            System.out.println("修改成功");
        }
        return "redirect:/tv/list";
    }


    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id")int id){
        tvServiceImpl.del(id);
        return "redirect:/tv/list";
    }


}
