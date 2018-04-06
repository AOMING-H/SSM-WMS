package com.ssm.ming.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.ming.entity.User;
import com.ssm.ming.service.UserService;
import com.ssm.ming.util.Response;

/**
 * @author Wenming.Huang
 * @date 2018-02-12
 * @version 1.0
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public @ResponseBody ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody Response login(@RequestBody User user) {
        Response response = new Response();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            response.failure("password error!");
            return response;
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            response.failure("username error!");
            return response;
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            response.failure("times error!");
            return response;
        }
        User userInfo = userService.findByAccount(user.getAccount());
        subject.getSession().setAttribute("user", userInfo);
        response.success(userInfo);
        return response;
    }
}
