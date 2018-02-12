package com.logistics.uiServlet;

import com.logistics.bean.CarLong;
import com.logistics.bean.CarType;
import com.logistics.bean.CoachType;
import com.logistics.dao.CarLongDao;
import com.logistics.dao.CarTypeDao;
import com.logistics.dao.CoachTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "LoadBasicInfoServlet",urlPatterns = "/uiSite/basicInfo.html")
public class LoadBasicInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarLongDao carLongDao = new CarLongDao();
        CarTypeDao carTypeDao = new CarTypeDao();
        CoachTypeDao coachTypeDao = new CoachTypeDao();

        ArrayList<CarType> carTypes = carTypeDao.getAllCarTypes();
        ArrayList<CarLong> carLongs = carLongDao.getAllCarLongs();
        ArrayList<CoachType> coachTypes = coachTypeDao.getAllCoachTypes();



        request.setAttribute("carTypes",carTypes);
        request.setAttribute("carLongs",carLongs);
        request.setAttribute("coachTypes",coachTypes);


        request.getRequestDispatcher("basicInfo.jsp").forward(request, response);

    }
}
