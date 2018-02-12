package com.logistics.servlet;

import com.logistics.bean.CarType;
import com.logistics.dao.CarTypeDao;

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
@WebServlet(name = "CarTypeServlet",urlPatterns = "/manageSite/carType.html")
public class CarTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        CarTypeDao carTypeDao = new CarTypeDao();
        ArrayList<CarType> carTypes = carTypeDao.getAllCarTypes();
        request.setAttribute("carTypes" , carTypes);
        request.getRequestDispatcher("carType.jsp").forward(request , response);
    }
}
