package com.qfedu.dao;

import com.qfedu.entity.Book;

import java.util.List;

public interface BookDao {
    public List<Book> selectBook();
    public void add(Book book);
    public Book findByBid(String bid);
    public List<Book> findByCategory(String cid);
    public int deleteByBid(String bid);
    public int Update(Book book);
}
