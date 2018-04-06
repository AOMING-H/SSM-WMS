package com.ssm.ming.service;

import com.ssm.ming.domain.MaterialBase;
import com.ssm.ming.util.PagedResult;

/**
 * @author Wenming.Huang
 * @date 2018-03-20
 * @version 1.0
 */
public interface MaterialBaseService {
    PagedResult<MaterialBase> findAllMaterialBaseInfo(Integer pageNo,Integer pageSize);

}
