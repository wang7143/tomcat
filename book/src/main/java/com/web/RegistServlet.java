package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.User;
import com.service.Userservice;
import com.service.Userserviceimp;

/**
 * RegistServlet
 */
/**
 * RegistServlet
 */
public class RegistServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Userservice userS = new Userserviceimp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if("abcde".equalsIgnoreCase(code)){
            if(userS.existsusername(name)){
                req.setAttribute("email", email);
                req.setAttribute("msg", "用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }else{
                userS.registUser(new User(null,name,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", name);
            req.setAttribute("email", email);
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}