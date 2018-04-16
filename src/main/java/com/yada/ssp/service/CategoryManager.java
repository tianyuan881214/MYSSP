package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.CategoryDaoImpl;
import com.yada.ssp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianyong
 */
@Service
public class CategoryManager extends BaseService<Category, String> {
    @Autowired
    private CategoryDaoImpl categoryDao;

    @Override
    protected BaseDao<Category, String> getBaseDao() {
        return categoryDao;
    }
}
