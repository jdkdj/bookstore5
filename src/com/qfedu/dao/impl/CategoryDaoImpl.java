package com.qfedu.dao.impl;

import com.qfedu.dao.CategoryDao;
import com.qfedu.entity.Category;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    @Override
    public List<Category> selectBook() {
        String sql = "select * from category";
        Object[] objs = {};
        List<Category> categories = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, objs);
            while (resultSet.next()) {
                Category category = new Category();
                category.setCid(resultSet.getString("cid"));
                category.setCname(resultSet.getString("cname"));
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
