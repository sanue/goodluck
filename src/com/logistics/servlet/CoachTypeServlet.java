package com.logistics.servlet;

import com.logistics.bean.CoachType;
import com.logistics.dao.CoachTypeDao;

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
@WebServlet(name = "CoachTypeServlet",urlPatterns = "/manageSite/coachtype.html")
public class CoachTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        CoachTypeDao coachTypeDao = new CoachTypeDao();
        ArrayList<CoachType> coachTypes = coachTypeDao.getAllCoachTypes();
        request.setAttribute("coachTypes" , coachTypes);
        request.getRequestDispatcher("coachtype.jsp").forward(request , response);
    }
}
