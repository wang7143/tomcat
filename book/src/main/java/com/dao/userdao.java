package com.dao;

import com.pojo.User;

public interface userdao {
    
    
    public User queryUserByUsername(String username) ;

    public int saveUser(User user) ;

    public User queryUserByUsernamePassword(String username,String password) ;
}
