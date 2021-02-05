package com.qfedu.controller;

import com.qfedu.entity.Category;
import com.qfedu.service.CategoryService;
import com.qfedu.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminCategoryServlet")
public class AdminCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.selectBook();
        request.setAttribute("categoryList", categories);
        request.getRequestDispatcher("/adminjsps/admin/category/list.jsp").forward(request, response);
    }
}
