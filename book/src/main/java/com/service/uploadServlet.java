package com.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class uploadServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -237722724987080910L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断上传数据是否多段
        if(ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory工厂实现类
            FileItemFactory file = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类
            ServletFileUpload FileUpload = new ServletFileUpload(file);
            //解析上传数据，得到表单项
            try {
                @SuppressWarnings("unchecked")
                List<FileItem> pars = FileUpload.parseRequest(req);
                for (FileItem fileItem : pars) {
                    if (fileItem.isFormField()) {
                        System.out.println("属性" + fileItem.getFieldName());
                        System.out.println("value" + fileItem.getString("UTF-8"));
                    } else {
                        System.out.println("表单项" + fileItem.getFieldName());
                        System.out.println("文件名" + fileItem.getName());
                        fileItem.write(new File("/usr/local/tomcat/" + fileItem.getName()));
                    }
                }
			} catch (Exception e) {
				e.printStackTrace();
			};
            
        }
    }
    
    
}
