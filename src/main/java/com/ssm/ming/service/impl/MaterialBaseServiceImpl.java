package com.ssm.ming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.ming.dao.MaterialBaseDao;
import com.ssm.ming.domain.MaterialBase;
import com.ssm.ming.service.MaterialBaseService;
import com.ssm.ming.util.BeanUtil;
import com.ssm.ming.util.PagedResult;

/**
 * @author Wenming.Huang
 * @date 2018-03-20
 * @version 1.0
 */
@Service("materialBaseService")
public class MaterialBaseServiceImpl implements MaterialBaseService{
    @Autowired
    private MaterialBaseDao materialBaseDao;

    @Override
    public PagedResult<MaterialBase> selectMaterialBaseInfo(Integer pageNumber, Integer pageSize, String sort,
            String sortOrder, String materialNo) throws Exception {
        pageNumber = pageNumber == null ? 1 : pageNumber;
        pageSize = pageSize == null ? 10 : pageSize;
        // startPage是告诉拦截器说我要开始分页了。分页参数是这两个
        PageHelper.startPage(pageNumber, pageSize);
        return BeanUtil.toPagedResult(materialBaseDao.selectMaterialBaseInfo(sort, sortOrder, materialNo));
    }

    @Override
    public Integer saveMaterialBaseInfo(MaterialBase materialBase) throws Exception {
        return materialBaseDao.insertMaterialBaseInfo(materialBase);
    }

    @Override
    public Integer editMaterialBaseInfo(MaterialBase materialBase) throws Exception {
        return materialBaseDao.updateMaterialBaseInfo(materialBase);
    }

    @Override
    public Integer deleteMaterialBaseInfo(Integer[] ids) throws Exception {
        return materialBaseDao.batchDeleteMaterialBaseInfo(ids);
    }
    
}
