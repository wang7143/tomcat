package com.web;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.User;
import com.service.Userservice;
import com.service.Userserviceimp;


public class UserServlet extends BaseServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Userservice users = new Userserviceimp();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // User user = webutils.copyParatoBean(req.getParameterMap(), new User());
        if("abcde".equalsIgnoreCase(code)){
            if(users.existsusername(name)){
                req.setAttribute("email", email);
                req.setAttribute("msg", "用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }else{
                users.registUser(new User(null,name,password,email));
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
    // @Override
    // protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //     String para = req.getParameter("action");
    //     try {
    //         Method method = this.getClass().getDeclaredMethod(para,HttpServletRequest.class,HttpServletResponse.class);
    //         method.invoke(this,req,resp);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
}
