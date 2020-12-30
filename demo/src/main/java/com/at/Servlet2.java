package com.at;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String username = req.getParameter("username");
        // System.out.println("查看柜台一参数" + username);

        // Object att = req.getAttribute("key");
        // System.out.println(att);

        // System.out.println("完成");

        resp.getWriter().write("tiaozhuan");
    }
    
}
