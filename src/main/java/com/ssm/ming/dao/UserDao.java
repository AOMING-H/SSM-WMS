package com.ssm.ming.dao;

import com.ssm.ming.domain.User;

/**
 * @author Wenming.Huang
 * @date 2018-02-12
 * @version 1.0
 */
public interface UserDao {
    User findByUserName(String userName);

    User findByAccount(String account);
    
    User findById(Integer id);
}