package com.qfedu.dao.impl;

import com.qfedu.dao.BookDao;
import com.qfedu.entity.Book;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public List<Book> selectBook() {
        String sql = "select * from book";
        Object[] objs = {};
        List<Book> books = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, objs);
            while (resultSet.next()) {
                Book book = new Book();
                book.setBid(resultSet.getString("bid"));
                book.setBname(resultSet.getString("bname"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getDouble("price"));
                book.setCid(resultSet.getString("cid"));
                book.setImage(resultSet.getString("image"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void add(Book book) {
        String sql = "insert into book values(?,?,?,?,?,?)";
        Object[] objs = {book.getBid(), book.getBname(), book.getPrice(),
                book.getAuthor(), book.getImage(), book.getCategory().getCid()};
        this.setUpdate(sql, objs);
    }

    @Override
    public Book findByBid(String bid) {
        String sql = "select * from book where bid = ?";
        Object[] objs = {bid};
        Book book = new Book();
        try {
            ResultSet resultSet = this.select(sql, objs);
            while (resultSet.next()) {
                book.setImage(resultSet.getString("image"));
                book.setBid(resultSet.getString("bid"));
                book.setBname(resultSet.getString("bname"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthor(resultSet.getString("author"));
                book.setCid(resultSet.getString("cid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> findByCategory(String cid) {
        String sql = "select * from book where cid = ?";
        Object[] objs = {cid};
        List<Book> books = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, objs);
            while (resultSet.next()) {
                Book book = new Book();
                book.setBid(resultSet.getString("bid"));
                book.setBname(resultSet.getString("bname"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getDouble("price"));
                book.setCid(resultSet.getString("cid"));
                book.setImage(resultSet.getString("image"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public int deleteByBid(String bid) {
        String sql = "delete from book where bid = ?";
        Object[] obj = {bid};
        return this.setUpdate(sql, obj);
    }

    @Override
    public int Update (Book book) {
//        book.setBid(bid);
//        book.setBname(bname);
//        book.setPrice(price);
//        book.setCid(cid);
//        book.setAuthor(author);
        String sql = "update book set bname = ?,price = ? ,cid = ? , author = ? where bid = ? ";
        Object[] obj = {book.getBname(),book.getPrice(),book.getCid(),book.getAuthor(),book.getBid()};
        return this.setUpdate(sql,obj);
    }
}
