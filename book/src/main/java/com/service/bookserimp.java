package com.service;

import java.util.List;

import com.dao.Bookdao;
import com.dao.Bookimpl;
import com.pojo.Book;
import com.pojo.Page;

public class bookserimp implements bookservice {

    private Bookdao bookdao = new Bookimpl();

    @Override
    public void addBook(Book book) {
        bookdao.addBoook(book);
    }

    @Override
    public void deleteBokkByID(Integer id) {
        bookdao.deleteBokkByID(id);

    }

    @Override
    public void updateBook(Book book) {
        bookdao.updateBook(book);

    }

    @Override
    public Book queryBookBiId(Integer id) {
        return bookdao.queryBookByID(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookdao.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNum, Integer pageSize) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);

        Integer pagecount = bookdao.queryCount();
        page.setPageTotalCount(pagecount);
        
        Integer pageTotal = pagecount / pageSize;

        if(pagecount % pageSize > 0) {
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);
        page.setPageNum(pageNum);
        int begin = (page.getPageNum() - 1) * pageSize;
        //当前页数据
        List<Book> items = bookdao.queryForPageItems(begin,pageSize);
        
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNum, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);

        int pagecount = bookdao.queryCountbyprice(min,max);
        page.setPageTotalCount(pagecount);
        
        int pageTotal = pagecount / pageSize;

        if(pagecount % pageSize > 0) {
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);
        page.setPageNum(pageNum);
        int begin = (page.getPageNum() - 1) * pageSize;
        if(begin < 0){
            begin = 0;
        }
        //当前页数据
        List<Book> items = bookdao.queryForPageItemsbyprice(begin,pageSize,min,max);
        
        page.setItems(items);
        return page;
    }
}
