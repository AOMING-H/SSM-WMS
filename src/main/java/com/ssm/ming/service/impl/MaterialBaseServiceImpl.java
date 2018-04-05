package com.ssm.ming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.ming.dao.MaterialBaseDao;
import com.ssm.ming.entity.MaterialBase;
import com.ssm.ming.service.MaterialBaseService;

/**
 * @author Wenming.Huang
 * @date 2018-03-20
 * @version 1.0
 */
@Service("materialBaseService")
public class MaterialBaseServiceImpl implements MaterialBaseService{
    @Autowired
    public MaterialBaseDao materialBaseDao;

    @Override
    public List<MaterialBase>  findAll() {
        return materialBaseDao.findAll();
    }
    
}
