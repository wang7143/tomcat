package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.utils.jdbcutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public abstract class basedao {

    // 使用DButils
    private QueryRunner que = new QueryRunner();

    public int update(String sql, Object... args) {
        Connection con = jdbcutils.getcon();
        try {
            return que.update(con, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type,String sql,Object...args){
        Connection con = jdbcutils.getcon();
        System.out.println(con);
        try {
            return que.query(con, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            
            e.printStackTrace();
        } finally{
            jdbcutils.close(con);
        }
        return null;
    }

    public <T>List<T> queryForList(Class<T> type,String sql,Object...args) {
        Connection con = jdbcutils.getcon();
        try {
            return que.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            
            e.printStackTrace();
        } finally {
            jdbcutils.close(con);
        }
        return null;
    }

    public Object queryForSingleValue(String sql,Object...args) {
        Connection con = jdbcutils.getcon();
        try {
            return que.query(con, sql,new ScalarHandler<>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            jdbcutils.close(con);
        }
        return null;
    }


}
