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
@WebServlet(name = "Statistics1Servlet",urlPatterns = "/manageSite/Statistics1.show")
public class Statistics1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StatisticsDao sDao = new StatisticsDao();
        /*车主数量*/
        int num1 = sDao.getCountOfOwner();
        /*车源数量*/
        int num2 = sDao.getCountOfCarInfo();
        /*货主数量*/
        int num3 = sDao.getCountOfShipper();
        /*货源数量*/
        int num4 = sDao.getCountOfGoods();
        Statistics s1 = new Statistics("车主", num1);
        Statistics s2 = new Statistics("车源" , num2);
        Statistics s3 = new Statistics("货主" , num3);
        Statistics s4 = new Statistics("货源" , num4);
        ArrayList<Statistics> ss = new ArrayList<Statistics>();
        ss.add(s1);
        ss.add(s2);
        ss.add(s3);
        ss.add(s4);
        JSONArray jsonArray = new JSONArray(ss);
        String result = jsonArray.toString();
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
