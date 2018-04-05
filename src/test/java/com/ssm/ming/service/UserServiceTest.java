package com.ssm.ming.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.ming.entity.User;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void findByUserNameTest() {
        User user = userService.findByUserName("测试帐号1");
        System.out.println(user.getUserName());
    }
    
    @Test
    public void findByAccountTest() {
        User user = userService.findByAccount("account1");
        System.out.println(user.getUserName());
    }

}
