package com.ssm.ming.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    public @ResponseBody Response findAllMaterialBaseInfo(
            @RequestParam(value = "pageNumber", required = true) Integer pageNumber,
            @RequestParam(value = "pageSize", required = true) Integer pageSize, 
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "sortOrder", required = false) String sortOrder,
            @RequestParam(value = "materialNo", required = false) String materialNo) {
        logger.info("请求入参：pageNumber:{}, pageSize:{}, sort:{}, sortOrder:{}, materialNo:{}", pageNumber, pageSize, sort,
                sortOrder, materialNo);

        if(sort == null) {
            sort = "id";
        }
        if(sortOrder == null) {
            sortOrder = "asc";
        }
        
        Response response = new Response();
        PagedResult<MaterialBase> materialBases = materialBaseService.findMaterialBaseInfo(pageNumber, pageSize,
                sort, sortOrder, materialNo);
        response.success(materialBases);
        return response;
    };
    
    @RequestMapping(value = "materials", method = RequestMethod.POST)
    public @ResponseBody Response saveMaterialBaseInfo(@RequestBody MaterialBase materialBase) {
        logger.info("请求入参：materialBase:{}", materialBase);

        Response response = new Response();
        response.success("");
        return response;
    };

    
}
