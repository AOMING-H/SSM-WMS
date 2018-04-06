package com.ssm.ming.util;

import java.util.List;

import com.github.pagehelper.Page;

/**
 * @author Wenming.Huang
 * @date 2018-04-06
 * @version 1.0
 */
public class BeanUtil {
    
    public static <T> PagedResult<T> toPagedResult(List<T> datas) {
        PagedResult<T> result = new PagedResult<T>();
        if (datas instanceof Page) {
            Page<T> page = (Page<T>) datas;
            result.setPageNo(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
        } else {
            result.setPageNo(1);
            result.setPageSize(datas.size());
            result.setDataList(datas);
            result.setTotal(datas.size());
        }
        return result;
    }

}
