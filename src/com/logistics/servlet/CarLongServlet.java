package com.logistics.servlet;

import com.logistics.bean.CarLong;
import com.logistics.dao.CarLongDao;

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
@WebServlet(name = "CarLongServlet",urlPatterns = "/manageSite/carLong.html")
public class CarLongServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        CarLongDao carLongDao = new CarLongDao();
        ArrayList<CarLong> carLongs = carLongDao.getAllCarLongs();
        request.setAttribute("carLongs" , carLongs);
        request.getRequestDispatcher("carLong.jsp").forward(request , response);
    }
}
