package com.logistics.servlet;

import com.logistics.bean.Statistics;
import com.logistics.dao.StatisticsDao;
import com.sun.org.glassfish.external.statistics.Statistic;
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
 * Created by Administrator on 2016/10/28.
 */
@WebServlet(name = "Statistics4Servlet",urlPatterns = "/manageSite/Statistics4.show")
public class Statistics4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StatisticsDao sDao = new StatisticsDao();
        int value1 = sDao.getCountOfGoods();
        int value2 = sDao.getCountOfFormOrder();
        Statistics s1 = new Statistics("货源",value1);
        Statistics s2 = new Statistics("订单",value2);
        ArrayList<Statistics> ss = new ArrayList<Statistics>();
        ss.add(s1);
        ss.add(s2);
        JSONArray jsonArray = new JSONArray(ss);
        String result = jsonArray.toString();
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
