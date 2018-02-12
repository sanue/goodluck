package com.logistics.servlet;

import com.logistics.bean.ShipperAuthentication;
import com.logistics.dao.ShipperAuthenticationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/26.
 */
@WebServlet(name = "ShipperAuthenticationServlet" , urlPatterns = "/manageSite/shipperAuthentication.html")
public class ShipperAuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ShipperAuthenticationDao saDao = new ShipperAuthenticationDao();
        ArrayList<ShipperAuthentication> authentications = saDao.getAllShipperAnthenticationInfo();
        request.setAttribute("authentications" , authentications);
        request.getRequestDispatcher("shipperAuthentication.jsp").forward(request , response);
    }
}
