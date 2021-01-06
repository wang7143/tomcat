package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Book;
import com.pojo.Page;
import com.service.bookserimp;
import com.service.bookservice;
import com.utils.webutils;

public class clientbookser extends BaseServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private bookservice bookser = new bookserimp();
    
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNum = webutils.parseInt(req.getParameter("pageNo"), 1);

        Integer pageSize = webutils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookser.page(pageNum, pageSize);
        page.setUrl("clientbookser?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

    protected void pageByPrices(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNum = webutils.parseInt(req.getParameter("pageNo"),1);

        int pageSize = webutils.parseInt(req.getParameter("pageSize"),Page.PAGE_SIZE);
        int min = webutils.parseInt("min", 0);
        int max = webutils.parseInt("max", Integer.MAX_VALUE);
        System.out.println(pageNum);
        System.out.println(pageSize);
        Page<Book> page = bookser.pageByPrice(pageNum,pageSize,min,max);
        System.out.println(page.toString());
        StringBuilder str = new StringBuilder("clientbookser?action=pageByPrice");
        if(req.getParameter("min") != null){
            str.append("&min").append(req.getParameter("min"));
        }
        if(req.getParameter("max") != null){
            str.append("&max").append(req.getParameter("max"));
        }
        page.setUrl(str.toString());
        req.setAttribute("page", page);
        System.out.println(page.toString());
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

    

}
