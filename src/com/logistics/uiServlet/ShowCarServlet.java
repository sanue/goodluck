package com.logistics.uiServlet;

import com.logistics.bean.*;
import com.logistics.dao.*;

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
@WebServlet(name = "ShowCarServlet",urlPatterns = "/uiSite/car.html")
public class ShowCarServlet extends HttpServlet {
    private int pageSize = 10;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取所有车的详情
        CarInfoDao Dao = new CarInfoDao();
        ArrayList<CarInfo> car=Dao.getAllCarInfos();

        //获取所有车的长度
        CarLongDao Long = new CarLongDao();
        ArrayList<CarLong> carLong = Long.getAllCarLongs();
        // System.out.print(carLong);
        //获取所有的车的类型
        CarTypeDao type = new CarTypeDao();
        ArrayList<CarType> carType = type.getAllCarTypes();
        //获取所有的车厢类型
        CoachTypeDao coachTypeDao = new CoachTypeDao();
        ArrayList<CoachType> coachType = coachTypeDao.getAllCoachTypes();

        //获取前几条车源信息
        int limit = 4;
        CarInfoDao dao = new CarInfoDao();
        ArrayList<CarInfo> carLimit=dao.getCarInfos(limit);
        //分页
        int pageCount = 1;
        if(null != request.getParameter("page")){
            pageCount = Integer.parseInt(request.getParameter("page"));
        }
        int start = (pageCount -1 ) * pageSize;
        CarInfoDao bookDao = new CarInfoDao();
        RecordSet<CarInfoAndPhone> carInfos = bookDao.getCarInfosAndPhone(start, pageSize);
        request.setAttribute("BookList" , carInfos);
        request.setAttribute("Page" , pageCount + 1);


        //保存发送到car.jsp
        request.setAttribute("CarInfoList",car);
        request.setAttribute("CarLongList",carLong);
        request.setAttribute("CarTypeList",carType);
        request.setAttribute("CoachTypeList",coachType);
        request.setAttribute("CarLimitList",carLimit);

        request.getRequestDispatcher("car.jsp").forward(request,response);

    }
}
