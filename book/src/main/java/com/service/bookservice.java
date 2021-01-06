package com.service;

import java.util.List;

import com.pojo.Book;
import com.pojo.Page;

public interface bookservice {
    public void addBook(Book book);

    public void deleteBokkByID(Integer id); 

    public void updateBook(Book book); 

    public Book queryBookBiId(Integer id);

    public List<Book> queryBooks();

	public Page<Book> page(Integer pageNum, Integer pageSize);

	public Page<Book> pageByPrice(int pageNum, int pageSize, int min, int max);
}
