package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Book;
import com.pojo.Page;
import com.service.bookserimp;
import com.service.bookservice;
import com.utils.webutils;

public class bookservlet extends BaseServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private bookservice bookser = new bookserimp();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = webutils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;
        Book book = webutils.copyParatoBean(req.getParameterMap(), new Book());
        bookser.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookservlet?action=page&pageNo=" + pageNo);
    }
    
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer i = Integer.parseInt(id);
        bookser.deleteBokkByID(i);
        int pageNo = webutils.parseInt(req.getParameter("pageNo"), 0);
        resp.sendRedirect(req.getContextPath() + "/manager/bookservlet?action=page&pageNo=" + pageNo);
    }
    
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookser.queryBooks();

        req.setAttribute("books", books);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        
        Book book = bookser.queryBookBiId(id);

        req.setAttribute("book", book);

        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = webutils.copyParatoBean(req.getParameterMap(), new Book());
        bookser.updateBook(book);
        String pageNo = req.getParameter("pageNo");
        resp.sendRedirect(req.getContextPath() + "/manager/bookservlet?action=page&pageNo=" + pageNo);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNum = webutils.parseInt(req.getParameter("pageNo"),1);

        Integer pageSize = webutils.parseInt(req.getParameter("pageSize"),Page.PAGE_SIZE);
        Page<Book> page = bookser.page(pageNum,pageSize);
        page.setUrl("manager/bookservlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }
    
    
}
