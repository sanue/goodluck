package com.logistics.servlet;

import com.logistics.bean.Statistics;
import com.logistics.dao.StatisticsDao;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
@WebServlet(name = "Statistics3Servlet",urlPatterns = "/manageSite/Statistics3.show")
public class Statistics3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request , response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*不同地方的货源数量*/
        request.setCharacterEncoding("utf-8");
        StatisticsDao sDao = new StatisticsDao();
        ArrayList<Statistics> ss = sDao.getCountOfGoodsByRegion();
        JSONArray jsonArray = new JSONArray(ss);
        String result = jsonArray.toString();
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
