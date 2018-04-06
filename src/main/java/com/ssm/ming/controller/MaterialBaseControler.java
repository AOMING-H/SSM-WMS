package com.ssm.ming.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.ming.domain.MaterialBase;
import com.ssm.ming.service.MaterialBaseService;
import com.ssm.ming.util.PagedResult;
import com.ssm.ming.util.Response;

/**
 * @author Wenming.Huang
 * @date 2018-04-06
 * @version 1.0
 */
@Controller
@RequestMapping("/base")
public class MaterialBaseControler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MaterialBaseService materialBaseService;
    
    @RequestMapping(value = "materials", method = RequestMethod.GET)
    public @ResponseBody Response findAllMaterialBaseInfo(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize) {
        logger.info("分页查询用户信息列表请求入参：pageNumber{}, pageSize{}", pageNumber,pageSize);
        
        Response response = new Response();
        PagedResult<MaterialBase> materialBases = materialBaseService.findAllMaterialBaseInfo(pageNumber, pageSize);
        response.success(materialBases);
        return response;
    };

    
}
