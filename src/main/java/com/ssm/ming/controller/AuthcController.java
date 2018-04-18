package com.ssm.ming.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.ming.domain.User;

/**
 * @author Wenming.Huang
 * @date 2018-02-12
 * @version 1.0
 */
@Controller
@RequestMapping("authc")
public class AuthcController {
    // /authc/** = authc 任何通过表单登录的用户都可以访问
    @RequestMapping("anyuser")
    public ModelAndView anyuser() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        System.out.println(user);
        return new ModelAndView("inner");
    }

    // /authc/admin = user[admin] 只有具备admin角色的用户才可以访问，否则请求将被重定向至登录界面
    @RequestMapping("admin")
    public ModelAndView admin() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        System.out.println(user);
        return new ModelAndView("inner");
    }
}
