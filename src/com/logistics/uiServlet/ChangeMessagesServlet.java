package com.logistics.uiServlet;

import com.logistics.bean.News;
import com.logistics.dao.NewsDao;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Administrator on 2016/10/30.
 */
@WebServlet(name = "ChangeMessagesServlet",urlPatterns = "/uiSite/ChangeMessages.html")
public class ChangeMessagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        request.setCharacterEncoding("utf-8");
        //通过Id获取新闻信息

        int id = Integer.parseInt(request.getParameter("Id"));
        NewsDao newsDao = new NewsDao();
        News news = newsDao.getNewsById(id);
        //响应
        JSONObject jsonObject = new JSONObject(news);
        String result = jsonObject.toString();
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
