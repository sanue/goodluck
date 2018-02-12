package com.logistics.uiServlet;

import com.logistics.bean.News;
import com.logistics.bean.RecordSet;
import com.logistics.dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/28.
 */
@WebServlet(name = "ShowNewsServlet",urlPatterns = "/uiSite/news.html")
public class ShowNewsServlet extends HttpServlet {
    private int pageSize = 10;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有的新闻的列表
        NewsDao newsDao = new NewsDao();
        ArrayList<News> news=newsDao.getAllNews();

        //获取前几条新闻的详情
       int limit = 1;
        NewsDao title = new NewsDao();
       ArrayList<News> newses = title.getNewsBYLimit(limit);
//        System.out.print("newses"+newses);
        //
        String ID = request.getParameter("Id");
        if(ID!=null){
            /*int id = Integer.parseInt(ID);*/
            request.setAttribute("id",ID);
        }else {
            request.setAttribute("id",null);
        }
        //
        int pageCount = 1;
        if(null != request.getParameter("page")){
            pageCount = Integer.parseInt(request.getParameter("page"));
        }
        int start = (pageCount -1 ) * pageSize;
        NewsDao Dao = new NewsDao();
        RecordSet<News> News = Dao.getAllNewsByPage(start, pageSize);

        // 保存，发送到news.jsp
        request.setAttribute("BookList" , News);
        request.setAttribute("Page" , pageCount + 1);
        request.setAttribute("NewsList",news);
        request.setAttribute("NewsesList",newses);
        request.getRequestDispatcher("news.jsp").forward(request,response);
    }
}
