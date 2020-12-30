package com.at;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class demo implements Servlet {


    

    @Override
    public void destroy() {
        System.out.println("4.销毁");

    }

    @Override
    public ServletConfig getServletConfig() {
        
        return null;
    }

    @Override
    public String getServletInfo() {
        
        return null;
    }

    @Override
    public void init(ServletConfig arg0) throws ServletException {
        System.out.println("2.init方法");
    }

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        System.out.println("3.this is a test");
        HttpServletRequest rq = (HttpServletRequest) arg0;
        String method = rq.getMethod();
        if("GET".equals(method)){
            System.out.println("GET");
        }else{
            System.out.println("POST");
        }
    }

    public demo() {
        System.out.println("1.构造器");
    }
    
}
