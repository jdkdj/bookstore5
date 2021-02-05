package com.qfedu.service.impl;

import com.qfedu.dao.BookDao;
import com.qfedu.dao.impl.BookDaoImpl;
import com.qfedu.entity.Book;
import com.qfedu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> selectBook() {
        List<Book> books = bookDao.selectBook();
        return books;
    }

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public Book load(String bid) {
        return bookDao.findByBid(bid);
    }

    @Override
    public List<Book> findByCategory(String cid) {
        List<Book> books = bookDao.findByCategory(cid);
        return books;
    }

    @Override
    public int deleteByBid(String bid) {
       return bookDao.deleteByBid(bid);
    }

    @Override
    public int Update(Book book) {
        return bookDao.Update(book);
    }


}
