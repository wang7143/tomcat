package com.service;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;



public class Download extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = "index.jpg";
        ServletContext ser = getServletContext();
        String mimeType = ser.getMimeType("/usr/local/tomcat/"+ file);
        resp.setContentType(mimeType);
        resp.setHeader("Content-Disposition", "attachment; filename=" + file);
        System.out.println(mimeType);
        InputStream res = ser.getResourceAsStream("/WEB-INF/index.jpg");
        System.out.println();
        ServletOutputStream out = resp.getOutputStream();
        IOUtils.copy(res, out);
    }
}
