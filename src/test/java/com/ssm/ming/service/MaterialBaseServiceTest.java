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
    Integer id;
    
    
    @Autowired
    private MaterialBaseService materialBaseService;
    
    @Test
    public void test001SaveMaterialBaseInfo() throws Exception {
        MaterialBase materialBase = new MaterialBase();
        String materialNo = (int)(Math.random()*1000000000) +"";
        materialBase.setMaterialNo(materialNo);
        materialBase.setName("TestMaterial");
        materialBase.setCategory("RM");
        materialBase.setUnit("PCE");
        materialBase.setCreateUser("1");
        materialBase.setUpdateUser("1");
        Integer ret = materialBaseService.saveMaterialBaseInfo(materialBase);
        id = materialBase.getId();
        logger.info("保存结果 ret = " + ret + ", id = " + materialBase.getId()); 
    }
    
    @Test
    public void test002FindMaterialBaseInfo() throws Exception {
        PagedResult<MaterialBase> pagedResult = materialBaseService.selectMaterialBaseInfo(1,10,"id","asc","");
        logger.info("查找结果" + pagedResult.getDataList()); 
    }
    
    @Test
    public void test003EditMaterialBaseInfo() throws Exception {
        test001SaveMaterialBaseInfo();
        
        MaterialBase materialBase = new MaterialBase();
        materialBase.setId(id);
        materialBase.setName("TestMaterial123");
        materialBase.setUpdateUser("1");
        Integer ret = materialBaseService.editMaterialBaseInfo(materialBase);
        logger.info("修改结果 ret = " + ret); 
    }
    
    @Test
    public void test004DeleteMaterialBaseInfo() throws Exception {
        test001SaveMaterialBaseInfo();
        Integer[] ids = {id};
        Integer ret = materialBaseService.deleteMaterialBaseInfo(ids);
        logger.info("删除结果 ret = " + ret); 
    }
}
