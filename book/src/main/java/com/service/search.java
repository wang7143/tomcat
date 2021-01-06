package com.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class search extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -1133058569356324975L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> stu = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            int t = i +1;
            stu.add(new Student(t,"name"+t,18+t,"phone"+t));
        }
        req.setAttribute("stuList", stu);
        req.getRequestDispatcher("/showstu.jsp").forward(req,resp);
    }
}
