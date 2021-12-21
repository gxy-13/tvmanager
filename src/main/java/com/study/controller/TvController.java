package com.study.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.bean.Tv;
import com.study.service.TvMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tv")
public class TvController {
    @Autowired
    TvMapperImpl tvMapperImpl;

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
        List<Tv> tvs = tvMapperImpl.allTv();
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
        tvMapperImpl.add(tv);
//        重定向进主页面
        return "redirect:/tv/list";
    }

    /**
     * 修改电视
     * @author 管鑫逸 201810353
     * @param pno
     * @param model
     * @return
     */
    @RequestMapping("/toUpdate/{pno}")
    public String toUpdate(@PathVariable("pno")int pno,
                           Model model){
        System.out.println(pno);
         Tv tv = tvMapperImpl.selectByPno(pno);
         model.addAttribute("tv",tv);
         return "tvs/update";
    }
    @RequestMapping("/update")
    public String update(Tv tv){
        System.out.println(tv);
        int i = tvMapperImpl.update(tv);
        if(i>0){
            System.out.println("修改成功");
        }
        return "redirect:/tv/list";
    }

    /**
     * 删除电视
     * @author 管鑫逸 2018150353
     * @param pno
     * @return
     */
    @RequestMapping("/del/{pno}")
    public String del(@PathVariable("pno")int pno){
        tvMapperImpl.del(pno);
        return "redirect:/tv/list";
    }

}
