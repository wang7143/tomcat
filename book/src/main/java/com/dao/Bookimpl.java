package com.dao;

import java.util.List;

import com.pojo.Book;

public class Bookimpl extends basedao implements Bookdao {

    @Override
    public int addBoook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());

    }

    @Override
    public int deleteBokkByID(Integer id) {
        String sql = "delete from  t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookByID(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryCount() {
        String sql = "select count(*) from t_book";
        Number query = (Number) queryForSingleValue(sql);
        return query.intValue();
        
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,?";
        return queryForList(Book.class, sql, begin,pageSize);
    }

    @Override
    public Integer queryCountbyprice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number query = (Number) queryForSingleValue(sql,min,max);
        return query.intValue();
    }

    @Override
    public List<Book> queryForPageItemsbyprice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where price between ? and ? order by price limit ?,?";
        return queryForList(Book.class, sql, min, max, begin,pageSize);
        //标记
    }

    
}
