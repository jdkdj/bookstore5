package com.qfedu.controller;

import com.qfedu.entity.Book;
import com.qfedu.service.BookService;
import com.qfedu.service.impl.BookServiceImpl;
import com.qfedu.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
    public void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        List<Book> books = bookService.selectBook();
        request.setAttribute("bookList", books);
        request.getRequestDispatcher("/jsps/book/list.jsp").forward(request, response);
    }
    public void load(HttpServletRequest request , HttpServletResponse response)
            throws ServletException,IOException{
        BookService bookService = new BookServiceImpl();
        request.setAttribute("book", bookService.load(request.getParameter("bid")));
        request.getRequestDispatcher("/jsps/book/desc.jsp").forward(request, response);
    }
    public void findByCategory(HttpServletRequest request , HttpServletResponse response)
            throws ServletException, IOException{
        BookService bookService = new BookServiceImpl();
        String cid = request.getParameter("cid");
        request.setAttribute("bookList", bookService.findByCategory(cid));
        request.getRequestDispatcher("/jsps/book/list.jsp").forward(request, response);
    }
}
