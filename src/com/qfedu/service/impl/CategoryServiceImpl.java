package com.qfedu.service.impl;

import com.qfedu.dao.CategoryDao;
import com.qfedu.dao.impl.CategoryDaoImpl;
import com.qfedu.entity.Category;
import com.qfedu.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> selectBook() {
        CategoryDao categoryDao = new CategoryDaoImpl();
        List<Category> categories = categoryDao.selectBook();
        return categories;
    }
}
