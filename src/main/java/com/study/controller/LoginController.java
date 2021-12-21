package com.study.controller;

import com.study.service.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller

@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserMapperImpl userMapperImpl;


    /**
     * @author 管鑫逸 2018150353
     * @param username
     * @param password
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session,
                        Model model){
        System.out.println("进入了请求login。。。");
        System.out.println(username);
        System.out.println(password);
        if(userMapperImpl.login(username, password)!=null){
            System.out.println("登陆成功");
            session.setAttribute("LoginUser",username);
            return "redirect:/main.html";
        }else{
            System.out.println("登陆失败");
            model.addAttribute("msg","登陆失败");
            return "index";
        }

    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }

}
