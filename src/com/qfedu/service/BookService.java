package com.qfedu.service;

import com.qfedu.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> selectBook();
    public void add(Book book);
    public Book load(String bid);
    public List<Book> findByCategory(String cid);
    public int deleteByBid(String bid);
    public int Update(Book book);
}
