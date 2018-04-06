package com.ssm.ming.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.ming.domain.MaterialBase;
import com.ssm.ming.util.PagedResult;

/**
 * @author Wenming.Huang
 * @date 2018-03-20
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class MaterialBaseServiceTest {
    Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
    @Autowired
    private MaterialBaseService materialBaseService;
    
    @Test
    public void findAllTest() {
        PagedResult<MaterialBase> pagedResult = materialBaseService.findAllMaterialBaseInfo(1,10);
        logger.debug("查找结果" + pagedResult); 
    }
}
