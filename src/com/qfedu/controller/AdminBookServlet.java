package com.qfedu.controller;

import com.qfedu.entity.Book;
import com.qfedu.entity.Category;
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

@WebServlet("/AdminBookServlet")
public class AdminBookServlet extends BaseServlet {
   public void findAll (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        //查看所有图书 1.从数据库里面找到所有的图书
       //2.转发给展示页面
       request.setCharacterEncoding("utf-8");
       BookService bookService = new BookServiceImpl();
       List<Book> bookList = bookService.selectBook();
       request.setAttribute("bookList",bookList);
       request.getRequestDispatcher("/adminjsps/admin/book/list.jsp").forward(request,response);

   }
   public void addPre (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
       request.setCharacterEncoding("utf-8");
       Book book = new Book();
        //创建一个实体类接一下前端传过来的数据

       double price = 0;

       String priceString = request.getParameter("price");
       if (priceString != null && !"".equals(priceString)) {
           price = Double.parseDouble(priceString);
       }

       book.setBid(request.getParameter("bid"));
       book.setPrice(price);
       book.setBname(request.getParameter("bname"));
       book.setImage(request.getParameter("image"));
       book.setAuthor(request.getParameter("author"));
       book.setCid(request.getParameter("cid"));
       Category category = new Category();
       category.setCid(request.getParameter("cid"));
       book.setCategory(category);
//       //测试
//       System.out.println("haha");
//       System.out.println(request.getParameter("bname"));
       //将book发送到sql
       BookService bookService = new BookServiceImpl();
       bookService.add(book);

       response.sendRedirect("AdminBookServlet?method=findAll");
   }

   public void load (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
       request.setCharacterEncoding("utf-8");
       String bid = request.getParameter("bid");
       BookService bookService = new BookServiceImpl();
       Book book = bookService.load(bid);
       request.setAttribute("book",book);
       System.out.println(book);
       request.getRequestDispatcher("/adminjsps/admin/book/desc.jsp").forward(request,response);
   }

   public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
       request.setCharacterEncoding("utf-8");
       String bid = request.getParameter("bid");
       BookService bookService = new BookServiceImpl();
       bookService.deleteByBid(bid);
       response.sendRedirect("AdminBookServlet?method=findAll");
   }

   public void edit (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
       request.setCharacterEncoding("utf-8");
       Book book = new Book();
       String bid = request.getParameter("bid");
       String bname = request.getParameter("bname");
       String author = request.getParameter("author");
       String priceString = request.getParameter("price");
       double price = 0;
       if (priceString != null && !"".equals(priceString)) {
           price = Double.parseDouble(priceString);
       }
       String cid = request.getParameter("cid");

       book.setBid(bid);
       book.setBname(bname);
       book.setPrice(price);
       book.setCid(cid);
       book.setAuthor(author);
       BookService bookService = new BookServiceImpl();
       bookService.Update(book);
       response.sendRedirect("AdminBookServlet?method=findAll");
    }
}
