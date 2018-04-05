package com.ssm.ming.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.ming.entity.MaterialBase;

/**
 * @author Wenming.Huang
 * @date 2018-03-20
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class MaterialBaseServiceTest {
    @Autowired
    public MaterialBaseService materialBaseService;
    
    @Test
    public void findAllTest() {
        List<MaterialBase> materialBases = materialBaseService.findAll();
        System.out.println(materialBases.get(2).getMaterialNo());
    }
}
