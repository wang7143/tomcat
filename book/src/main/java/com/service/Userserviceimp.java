package com.service;

import com.dao.UserDaoImpl;
import com.dao.userdao;
import com.pojo.User;

public class Userserviceimp implements Userservice{

    private userdao userd = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userd.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userd.queryUserByUsernamePassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsusername(String name) {
        if(userd.queryUserByUsername(name) == null){
            return false;
        }
        return true;
    }


    
    
}
