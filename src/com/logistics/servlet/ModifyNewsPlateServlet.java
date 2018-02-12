package com.logistics.servlet;

import com.logistics.bean.News;
import com.logistics.dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/27.
 */
@WebServlet(name = "ModifyNewsPlateServlet" , urlPatterns = "/manageSite/modifyNews.html")
public class ModifyNewsPlateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        NewsDao nDao = new NewsDao();
        News news = nDao.getNewsById(id);
        request.setAttribute("news" , news);
        request.getRequestDispatcher("modifyNews.jsp").forward(request , response);
    }
}
