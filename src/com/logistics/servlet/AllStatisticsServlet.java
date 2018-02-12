package com.logistics.servlet;

import com.logistics.bean.Statistics;
import com.logistics.dao.StatisticsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/31.
 */
@WebServlet(name = "AllStatisticsServlet",urlPatterns = "/manageSite/index.html")
public class AllStatisticsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StatisticsDao sDao = new StatisticsDao();
        /*车主数量*/
        int num1 = sDao.getCountOfOwner();
        /*车源数量*/
      int num2 = sDao.getCountOfCarInfo();
        /*货主数量*/
       int num3 = sDao.getCountOfShipper();
       /*货源数量*/
        int num4 = sDao.getCountOfGoods();
        //车主信息审核数量
        int num5=sDao.getCountOfOwnerAuthentication();
        //货主信息审核数量
        int num6=sDao.getCountOfShipperAuthentication();
        //车型类型数量
        int num7=sDao.getCountOfCarType();
        //车长类型数量
        int num8=sDao.getCountOfCarLong();
        //车厢类型数量
        int num9=sDao.getCountOfCoachType();
        //新闻数量
        int num10=sDao.getCountOfNews();
        Statistics s1 = new Statistics("车主", num1);
        Statistics s2 = new Statistics("车源" , num2);
        Statistics s3 = new Statistics("货主" , num3);
        Statistics s4 = new Statistics("货源" , num4);
        Statistics s5 = new Statistics("车主信息审核" , num5);
        Statistics s6 = new Statistics("货主信息审核" , num6);
        Statistics s7=new Statistics("车型类型数量",num7);
        Statistics s8=new Statistics("车长类型数量",num8);
        Statistics s9=new Statistics("车厢类型数量",num9);
        Statistics s10=new Statistics("新闻数量",num10);
        request.setAttribute("statistics1" , s1);
        request.setAttribute("statistics2" , s2);
        request.setAttribute("statistics3" , s3);
        request.setAttribute("statistics4" , s4);
        request.setAttribute("statistics5" , s5);
        request.setAttribute("statistics6" , s6);
        request.setAttribute("statistics7" , s7);
        request.setAttribute("statistics8" , s8);
        request.setAttribute("statistics9" , s9);
        request.setAttribute("statistics10" , s10);
        request.getRequestDispatcher("index.jsp").forward(request , response);
    }
}
