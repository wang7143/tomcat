package com.dao;

import java.util.List;

import com.pojo.Book;

public interface Bookdao {
    public int addBoook(Book book);
    
    public int deleteBokkByID(Integer id);

    public int updateBook(Book book);

    public Book queryBookByID(Integer id);

    public List<Book> queryBooks();

	public Integer queryCount();

	public List<Book> queryForPageItems(int begin, int pageSize);

	public Integer queryCountbyprice(int min, int max);

	public List<Book> queryForPageItemsbyprice(int begin, int pageSize, int min, int max);
}
