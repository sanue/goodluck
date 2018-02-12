package com.logistics.servlet;

import com.logistics.bean.CarInfo;
import com.logistics.dao.CarInfoDao;

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
@WebServlet(name = "CarInfoServlet",urlPatterns = "/manageSite/carinfo.html")
public class CarInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        CarInfoDao cDao = new CarInfoDao();
        ArrayList<CarInfo> carInfos = cDao.getAllCarInfo();
        request.setAttribute("carInfos" , carInfos);
        request.getRequestDispatcher("carinfo.jsp").forward(request , response);
    }
}
