package com.ssm.ming.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.ming.domain.MaterialBase;

/**
 * @author Wenming.Huang
 * @date 2018-03-20
 * @version 1.0
 */
public interface MaterialBaseDao {
    List<MaterialBase> findMaterialBaseInfo(@Param("sort") String sort, @Param("sortOrder") String sortOrder,
            @Param("materialNo") String materialNo);
}
