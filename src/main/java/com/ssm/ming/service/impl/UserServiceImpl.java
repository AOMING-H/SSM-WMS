package com.ssm.ming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.ming.dao.UserDao;
import com.ssm.ming.domain.User;
import com.ssm.ming.service.UserService;

/**
 * @author Wenming.Huang
 * @date 2018-02-12
 * @version 1.0
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    /*
     * (non-Javadoc)
     * 
     * @see com.ssm.ming.service.UserService#findByUserName(java.lang.String)
     */
    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ssm.ming.service.UserService#findByAccount(java.lang.String)
     */
    @Override
    public User findByAccount(String account) {
        return userDao.findByAccount(account);
    }

    /* (non-Javadoc)
     * @see com.ssm.ming.service.UserService#findById(java.lang.String)
     */
    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

}
