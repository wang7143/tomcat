package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.User;
import com.service.Userservice;
import com.service.Userserviceimp;

public class LoginServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Userservice users = new Userserviceimp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        User login = users.login(new User(null,name,password,null));

        if(login == null){
            req.setAttribute("msg", "用户名密码错误！");
            req.setAttribute("username", name);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
    
    
}
