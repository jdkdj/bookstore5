package com.qfedu.test;

import com.qfedu.dao.impl.BookDaoImpl;
import com.qfedu.entity.Book;
import com.qfedu.service.BookService;
import com.qfedu.service.impl.BookServiceImpl;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.sql.CommonDataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Demo {
    public static void main(String[] args) {
//        BookServiceImpl bookService = new BookServiceImpl();
//        BookDaoImpl bookDao = new BookDaoImpl();
//        List<Book> books = bookService.selectBook();
//        for (Book book : books) {
//            System.out.println(book);
//        }

        BookServiceImpl bookService = new BookServiceImpl();
        int i = bookService.deleteByBid("15");
        System.out.println(i);


    }
}
