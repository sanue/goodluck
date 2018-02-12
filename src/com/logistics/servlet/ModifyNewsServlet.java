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
@WebServlet(name = "ModifyNewsServlet" , urlPatterns = "/manageSite/modifyNews.do")
public class ModifyNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("hideId"));
        String time = request.getParameter("time");
        String title = request.getParameter("title");
        String content = request.getParameter("myText");
        News n = new News(id , time , title , content);
        NewsDao nDao = new NewsDao();
        int result = nDao.modifyNews(n);
        if(result==1){
            response.sendRedirect("showNews.html");
        }else{
            response.sendRedirect("modifyNews.html?id="+id);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
