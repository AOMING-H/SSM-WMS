package com.ssm.ming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.ming.domain.User;
import com.ssm.ming.service.UserService;
import com.ssm.ming.util.Response;


/**
 * @author Wenming.Huang
 * @date 2018-02-13
 * @version 1.0
 */
@Controller
@RequestMapping("/authc")
public class RestControler {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{id}")
    public @ResponseBody Response findById(@PathVariable("id") Integer id) {
        Response response = new Response();
        User user = userService.findById(id);
        if(user == null) {
            response.failure("id " + id + " is not exist!");
        } else {
            response.success(user);
        }
        return response;
    };
    
    // public @ResponseBody Response login(@RequestParam("account") String account, @RequestParam("password") String password) {

}
