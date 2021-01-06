package com.service;

import com.pojo.User;

public interface Userservice {
    public void registUser(User user) ;

    public User login(User user) ;

    public boolean existsusername(String name) ;

}
