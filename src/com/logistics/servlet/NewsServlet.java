package com.logistics.servlet;

import com.logistics.bean.News;
import com.logistics.dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
@WebServlet(name = "NewsServlet" , urlPatterns = "/manageSite/showNews.html")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        NewsDao nDao = new NewsDao();
        ArrayList<News> newses = nDao.getAllNews();
        request.setAttribute("allNews" , newses);
        request.getRequestDispatcher("showNews.jsp").forward(request , response);
    }
}
