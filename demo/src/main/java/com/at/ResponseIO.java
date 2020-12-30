package com.at;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseIO extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setCharacterEncoding("UTF-8");
        // resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        // resp.setContentType("text/html; charset=UTF-8");
        // PrintWriter writer = resp.getWriter();
        // writer.write("5446465你好");

        //重定向
        // resp.setStatus(302);
        // resp.setHeader("Location", "http://www.baidu.com");
        resp.sendRedirect("http://www.163.com");
    }

    
    
}
