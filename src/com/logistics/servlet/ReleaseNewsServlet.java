package com.logistics.servlet;

import com.logistics.bean.News;
import com.logistics.dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/27.
 */
@WebServlet(name = "ReleaseNewsServlet" , urlPatterns = "/manageSite/releaseNews.do")
public class ReleaseNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String time = request.getParameter("time");
        String title = request.getParameter("title");
        String content = request.getParameter("myText");
        News n = new News(0 , time , title , content);
        NewsDao nDao = new NewsDao();
        int result = nDao.addNews(n);
        if(result>0){
            response.sendRedirect("showNews.html");
        }else{
            response.sendRedirect("releaseNews.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
